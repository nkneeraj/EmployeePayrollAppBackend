package com.cg.employeepayollappnew.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cg.employeepayollappnew.dto.EmployeePayrollDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empID;
	private String name;
	private Long salary;

	public Employee() {

	}

	public Employee(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}
