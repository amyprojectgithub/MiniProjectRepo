package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDTO;
@Service("empService")
public final class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeDao dao;
	public List<EmployeeDTO> frtchAllEmps() {
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
		List<EmployeeBO> listBO=null;
		//use service
		listBO=dao.getAllEmps();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);		
		});
		return listDTO;
	}
	@Override
	public EmployeeDTO fetchEmpByNo(int eno) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
		//create DTO object
		dto=new EmployeeDTO();
		//use dao
		bo=dao.getEmpByNo(eno);
		//convert bo to dto
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	@Override
	public String modifyByEmpNo(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.updateByEmpNo(bo);		 
		return (count==0)?"Employee updation is failed!!!!!!!":"Employee "+dto.getEmpNo()+" is successfully updated";
	}
	@Override
	public String removeEmpByEno(int eno) {
		int count=0;
		//use dao
		count=dao.deleteEmpByEno(eno);
		return (count==0)?"Employee deletion is failed!!!!!":"Employee "+eno+" is deleted successfully";
	}
@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
	//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.insertEmployee(bo);				
		return (count==0)?"Employee REgistration failed!!!!":"Employee Registration succeded";
	}

}
