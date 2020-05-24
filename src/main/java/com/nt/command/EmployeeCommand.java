package com.nt.command;

import lombok.Data;

@Data
public class EmployeeCommand {
	private int empNo;
	private String empName;
	private String job;
	private double salary;
}
