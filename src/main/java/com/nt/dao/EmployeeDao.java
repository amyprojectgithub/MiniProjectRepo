package com.nt.dao;

import java.util.List;
import com.nt.bo.EmployeeBO;

public interface EmployeeDao {
	List<EmployeeBO> getAllEmps();
	EmployeeBO getEmpByNo(int eno);
	int updateByEmpNo(EmployeeBO bo);
	int deleteEmpByEno(int eno);
	int insertEmployee(EmployeeBO bo);
}
