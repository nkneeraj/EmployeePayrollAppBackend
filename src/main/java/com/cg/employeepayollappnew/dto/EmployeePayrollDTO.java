package com.cg.employeepayollappnew.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeePayrollDTO {
//	@Size(max = 10, min = 3, message = "Name length should be between 3-10." )
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,9}$" , message = "Invalid name")
	public String name;
//	@Pattern(regexp = "^[0-9]{2,10}$" , message = "Invalid Salary")
	@Min(value = 2, message = "Salary digit should be greater than 1")
	public long salary;
	
	public EmployeePayrollDTO(String name, long salary) {
		this.name=name;
		this.salary=salary;
	}

	public EmployeePayrollDTO() {
		// TODO Auto-generated constructor stub
	}

}
