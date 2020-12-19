package com.cg.employeepayollappnew.dto;

import java.util.List;

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

	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}" , message = "Invalid name")
	private String name;
	private String profile;
	private String gender;
	private List<String> department;
	private String salary;
	private String startDate;
	private String notes;
	public EmployeePayrollDTO() {

	}

	public EmployeePayrollDTO(Employee employee) {
		this.name = employee.getName();
		this.gender = employee.getGender();
		this.department = employee.getDepartment();
		this.salary = employee.getSalary();
		this.startDate = employee.getStartDate();
		this.notes = employee.getNotes();
		this.profile = employee.getProfile();
	}
}
