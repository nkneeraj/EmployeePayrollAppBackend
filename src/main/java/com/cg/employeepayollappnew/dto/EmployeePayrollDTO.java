package com.cg.employeepayollappnew.dto;

import javax.validation.constraints.Min;

import javax.validation.constraints.Pattern;

import com.cg.employeepayollappnew.model.Employee;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
//	@Size(max = 10, min = 3, message = "Name length should be between 3-10." )
//	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,9}$" , message = "Invalid name")
//	public String name;
//	@Min(value = 9, message = "Salary digit should be greater than 1")
//	public long salary;
//	public String gender;
//	
//	public EmployeePayrollDTO(String name, long salary) {
//		this.name=name;
//		this.salary=salary;
//	}

	private String name;
	private String gender;
	private String department;
	private double basic_pay;
	private String startDate;
	public EmployeePayrollDTO() {

	}

	public EmployeePayrollDTO(Employee employee) {
		this.name = employee.getName();
		this.gender = employee.getGender();
		this.department = employee.getDepartment();
		this.basic_pay = employee.getBasic_pay();
		this.startDate = employee.getStart();
	}
}
