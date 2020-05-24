package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("empDao")
public final class EmployeeDaoImpl implements EmployeeDao {
	private static final String GET_ALLEMP="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	private static final String GET_EMP_BY_EMPNO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String UPDATE_EMP_BY_EMPNO="UPDATE EMP SET ENAME=?,JOB=?,SAL=?  WHERE EMPNO=?";
	private static final String DELETE_EMP_BY_EMPNO="DELETE FROM  EMP  WHERE EMPNO=?";
	private static final String INSERT_EMP="INSERT INTO EMP (EMPNO,ENAME,JOB,SAL)  VALUES(EMP_SEQ.NEXTVAL,?,?,?)";
		
	
	@Autowired
	private JdbcTemplate jt;



	@Override
	public List<EmployeeBO> getAllEmps() {
		List<EmployeeBO> listBO=jt.query(GET_ALLEMP, new EmployeeExtractor());
		return listBO;
	}

	private class EmployeeExtractor implements ResultSetExtractor<List<EmployeeBO>>{
		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO=null;
			EmployeeBO bo=null;
			listBO=new ArrayList<EmployeeBO>();
			while(rs.next()) {
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEmpName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getDouble(4));
				listBO.add(bo);
			}
			return listBO;
		}		

	}

	@Override
	public EmployeeBO getEmpByNo(int eno) {
		EmployeeBO bo=jt.queryForObject(GET_EMP_BY_EMPNO, (rs,index)->{
			EmployeeBO bo1=null;
			bo1=new EmployeeBO();
			bo1.setEmpNo(rs.getInt(1));
			bo1.setEmpName(rs.getString(2));
			bo1.setJob(rs.getString(3));
			bo1.setSalary(rs.getDouble(4));		
			return bo1;		
		}, eno);
		return bo;
	}
	
	@Override
	public int updateByEmpNo(EmployeeBO bo) {
		int count=jt.update(UPDATE_EMP_BY_EMPNO, bo.getEmpName(),bo.getJob(),bo.getSalary(),bo.getEmpNo());
		return count;
	}
	
	@Override
	public int deleteEmpByEno(int eno) {
		int count=jt.update(DELETE_EMP_BY_EMPNO, eno);
		return count;
	}
	@Override
	public int insertEmployee(EmployeeBO bo) {
		int count=jt.update(INSERT_EMP, bo.getEmpName(),bo.getJob(),bo.getSalary());
		return count;
	}

}

