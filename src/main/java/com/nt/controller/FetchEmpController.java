package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
@Controller
public class FetchEmpController {
	@Autowired
	private EmployeeMgmtService service;

	//To bring the effect of  ParameterizableViewController to get the home page
	@RequestMapping("/welcome.htm")
	public String getHome() {
		return "home";
	}
	//To bring the effect of AbstractController for  request processing
	@RequestMapping("/getAllEmp.htm")
	public String getWishMsg(Map<String, Object> map)
			throws Exception {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.frtchAllEmps();
		map.put("listDTO", listDTO);
		return "show_AllEmp";
	}

	//Processing InitialPhase Request
	@GetMapping("edit.htm")
	public String launchUpdateForm(@RequestParam("eno")int no,
			@ModelAttribute("empCmd")EmployeeCommand cmd) {
		EmployeeDTO dto=null;
		//use service
		dto=service.fetchEmpByNo(no);
		//convert dto to cmd
		BeanUtils.copyProperties(dto, cmd);
		return "show_update_page";		
	}
	//processing post-back request
	@PostMapping("/edit.htm")
	public String processUpdateForm(Map<String,Object> map,
			@ModelAttribute("empCmd")EmployeeCommand cmd) {
		EmployeeDTO dto=null;
		String msg=null;
		List<EmployeeDTO> listDTO=null;
		//convert cmd to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.modifyByEmpNo(dto);
		listDTO=service.frtchAllEmps();
		//keep msg as model attribute
		map.put("msg", msg);
		map.put("listDTO", listDTO);
		return "show_AllEmp";
	}

	@RequestMapping("/delete.htm")
	public String deleteEmployee(Map<String , Object> map,@RequestParam("eno")int eno) {
		String msg=null;
		List<EmployeeDTO> listDTO=null;
		//use service
		msg=service.removeEmpByEno(eno);
		listDTO=service.frtchAllEmps();
		//keep result as model attribute
		map.put("msg", msg);
		map.put("listDTO", listDTO);
		return "show_AllEmp";
	}

	//InitialPhase request processing to insert record 
	@GetMapping("/register.htm")
	public String registerFormLaunch(@ModelAttribute("empCmd")EmployeeCommand cmd) {
		//set default values to Command class object properties	
		cmd.setJob("Manager");
		cmd.setSalary(5500);	
		return "insert_emp";
	}
	//postback request processing
	@PostMapping("register.htm")
	public String registerFormProcess(Map<String,Object> map,
			                                                                        @ModelAttribute("empCmd")EmployeeCommand cmd) {
		EmployeeDTO dto=null;
		String msg=null;
		List<EmployeeDTO> listDTO=null;
		//convert cmd to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.registerEmployee(dto);
		listDTO=service.frtchAllEmps();
		//make result as model attribute
		map.put("msg", msg);
		map.put("listDTO", listDTO);
		return "show_AllEmp";
	}

}
