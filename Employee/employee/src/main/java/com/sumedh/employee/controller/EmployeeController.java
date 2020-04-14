package com.sumedh.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sumedh.employee.model.EmployeeDetails;
import com.sumedh.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<EmployeeDetails> saveEmployee(@RequestBody EmployeeDetails employeeDetails) {

		return new ResponseEntity<EmployeeDetails>(employeeService.saveEmployee(employeeDetails), HttpStatus.OK);
	}

	@PostMapping(value = "/getEmployee")
	public ResponseEntity<EmployeeDetails> getEmployee(@RequestBody Integer id) {

		return new ResponseEntity<EmployeeDetails>(employeeService.getEmployee(id), HttpStatus.OK);
	}

	@PostMapping(value = "/deleteEmployee")
	public ResponseEntity<Boolean> deleteEmployee(@RequestBody Integer id) {

		return new ResponseEntity<Boolean>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllEmployee")
	public ResponseEntity<List<EmployeeDetails>> getAllEmployee() {

		return new ResponseEntity<List<EmployeeDetails>>(employeeService.getAllEmployeeDetails(), HttpStatus.OK);
	}
}
