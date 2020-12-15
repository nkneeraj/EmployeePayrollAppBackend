package com.cg.employeepayollappnew.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.employeepayollappnew.dto.EmployeePayrollDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "employee_payroll")
public class Employee implements Serializable{
	
	  
		private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
        private String name;
        private String gender;
        private String department;
        private double basic_pay;
        private String start;
        
        public Employee() {
			// TODO Auto-generated constructor stub
		}
        
        public Employee(EmployeePayrollDTO employeePayrollDTO) {
        	this.name = employeePayrollDTO.getName();
        	this.gender = employeePayrollDTO.getGender();
        	this.department = employeePayrollDTO.getDepartment();
        	this.basic_pay = employeePayrollDTO.getBasic_pay();
        	this.start = employeePayrollDTO.getStartDate();
    	}
        
        public Employee(String name, String gender, String department, double salary, String startDate) {
        	
        }
}
