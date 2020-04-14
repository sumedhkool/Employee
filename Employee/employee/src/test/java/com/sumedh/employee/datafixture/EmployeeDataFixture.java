package com.sumedh.employee.datafixture;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sumedh.employee.model.EmployeeDetails;

public class EmployeeDataFixture {

	public static final Integer id = 1;

	public static final String name = "Sumedh";

	public static final Double salary = 50000.00d;

	public static final String department = "Technologgy";

	public static EmployeeDetails stadardEmployee() {
		return new EmployeeDetails(id, name, salary, department);
	}

	public static Optional<EmployeeDetails> getStandardEmployeeOptional() {
		Optional<EmployeeDetails> optional = Optional.of(new EmployeeDetails(id, name, salary, department));
		return optional;

	}

	public static List<EmployeeDetails> standardEmployeeList() {
		List<EmployeeDetails> list = new ArrayList<EmployeeDetails>();
		list.add(stadardEmployee());
		return list;
	}

}
