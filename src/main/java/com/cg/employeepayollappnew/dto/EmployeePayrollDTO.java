package com.cg.employeepayollappnew.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
//	@Size(max = 10, min = 3, message = "Name length should be between 3-10." )
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,9}$" , message = "Invalid name")
	public String name;
	@Min(value = 2, message = "Salary digit should be greater than 1")
	public long salary;
	
	public EmployeePayrollDTO(String name, long salary) {
		this.name=name;
		this.salary=salary;
	}
}
