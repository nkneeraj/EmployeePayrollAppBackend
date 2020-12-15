package com.cg.employeepayollappnew.controllers;

import java.util.List;
import javax.validation.Valid;
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
import com.cg.employeepayollappnew.dto.ResponseDTO;
import com.cg.employeepayollappnew.exception.EmployeeException;
import com.cg.employeepayollappnew.model.Employee;
import com.cg.employeepayollappnew.services.IEmployeePayrollService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	/**
	 * @return
	 */
	@ApiOperation(value = "This api is used for demo purpose only.")
	@GetMapping
	public String demo() {
		return "hello";
	}
	
	/**
	 * @param empId
	 * @return
	 * @throws EmployeeException
	 */
	@ApiOperation(value = "This api used to fetch the employee details by empId.", notes = "Enter empId in long form.", response = Employee.class)
	@GetMapping("/get/{empId}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable long empId) throws EmployeeException {
		Employee emp = employeePayrollService.getEmployeeData(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	
	/**
	 * @return
	 */
	@ApiOperation(value = "This api is used to fetch all Employye details.", response = Employee.class)
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeesList = employeePayrollService.getAllEmployeeData();
		return new ResponseEntity<>(employeesList, HttpStatus.OK);
	}

	/**
	 * This api is used to add new Employee to database.
	 * 
	 * @param employeePayrollDTO
	 * @return
	 */

	@ApiOperation(value = "This api used to create new Employee", notes = "Enter name with first capital and length in 3-10 \n Enter Salary with digit length in 3-10", response = Employee.class)
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody @Valid EmployeePayrollDTO employeePayrollDTO) {
		System.out.println("In create api");
		Employee emp = employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Added EmployeePayroll Data", emp), HttpStatus.CREATED);
	}

	
	/**
	 * @param empId
	 * @param employeePayrollDTO
	 * @return
	 * @throws EmployeeException
	 */
	@ApiOperation(value = "This api used to update the employee details for given empId", notes = "Enter empId in long form.", response = Employee.class)
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable long empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		Employee emp = employeePayrollService.updateEmployeeById(empId, employeePayrollDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Updated EmployeePayroll Data", emp), HttpStatus.OK);
	}

	
	/**
	 * @param empId
	 * @return
	 * @throws EmployeeException
	 */
	@ApiOperation(value = "This api used to delete the employee details for given empId.", notes = "Enter empId in long form.", response = Employee.class)
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long empId) throws EmployeeException {
		Employee emp = employeePayrollService.deleteEmployeeById(empId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Deleted EmployeePayroll Data", emp), HttpStatus.OK);
	}
}
