package com.cg.employeepayollappnew.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeepayollappnew.dto.EmployeePayrollDTO;
import com.cg.employeepayollappnew.model.Employee;
import com.cg.employeepayollappnew.services.EmployeePayrollService;
import com.cg.employeepayollappnew.services.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@GetMapping
	public String demo() {
		return "hello";
	}
	
	@GetMapping("/get/{empID}")
	public Optional<Employee> getEmployeeDetails(@PathVariable long empID) {
		return employeePayrollService.getEmployeeData(empID);
//		return new Optional<Employee>(emp,HttpStatus.OK);
	
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
		return new ResponseEntity<String>("Added EmployeePayroll Data",HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{empID}")
	public ResponseEntity updateEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO,
											@PathVariable long empId) {
		return null;
	}
	
	@DeleteMapping("/delete/{empID}")
	public ResponseEntity deleteEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO,
			@PathVariable long empId) {
			return null;
}
}
