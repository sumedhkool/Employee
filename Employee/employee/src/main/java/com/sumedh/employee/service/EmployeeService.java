package com.sumedh.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sumedh.employee.data.EmployeeRepository;
import com.sumedh.employee.model.EmployeeDetails;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeDetails saveEmployee(EmployeeDetails details) {
		return employeeRepository.save(details);
	}

	public EmployeeDetails getEmployee(Integer id) {
		return employeeRepository.findById(id).get() != null ? employeeRepository.findById(id).get() : null;
	}

	public Boolean deleteEmployee(Integer id) {
		try {
			employeeRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<EmployeeDetails> getAllEmployeeDetails() {
		return employeeRepository.findAll();
	}
}
