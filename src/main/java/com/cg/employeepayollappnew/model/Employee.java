package com.cg.employeepayollappnew.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

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
//		@Pattern(regexp = "^[A-Z]{1}[a-z A-Z]{2,} //s [A-Z]{0,}[a-z A-Z]{0,}", message = "Invalid Name")
        private String name;
        
//        @Column(unique=true)
        private String gender;
        
        @Column(name = "department")
        @ElementCollection
        @CollectionTable(name="Employee_departmentt", joinColumns = @JoinColumn(name = "id")) //one to many 
        private List<String> department;
//        @OneToMany(cascade = CascadeType.ALL)
        

        private String salary;
        private String startDate;
        private String notes;
        private String profile;
        
        public Employee() {
			// TODO Auto-generated constructor stub
		}
        
        public Employee(EmployeePayrollDTO employeePayrollDTO) {
        	this.name = employeePayrollDTO.getName();
        	this.gender = employeePayrollDTO.getGender();
        	this.department = employeePayrollDTO.getDepartment();
        	this.salary = employeePayrollDTO.getSalary();
        	this.startDate = employeePayrollDTO.getStartDate();
        	this.notes = employeePayrollDTO.getNotes();
        	this.profile = employeePayrollDTO.getProfile();
    	}
        
//        public Employee(String name, char gender, String department, double basic_pay, String startDate) {
//        	
//        }
}
