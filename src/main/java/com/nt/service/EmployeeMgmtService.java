package com.nt.service;

import java.util.List;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	List<EmployeeDTO> frtchAllEmps();
	EmployeeDTO fetchEmpByNo(int eno);
	String modifyByEmpNo(EmployeeDTO dto);
	String removeEmpByEno(int eno);
	String registerEmployee(EmployeeDTO dto);
   
}
