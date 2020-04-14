package com.sumedh.employee.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sumedh.employee.data.EmployeeRepository;
import com.sumedh.employee.datafixture.EmployeeDataFixture;
import com.sumedh.employee.model.EmployeeDetails;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	public void saveEmployeeTest() {
		when(employeeRepository.save(EmployeeDataFixture.stadardEmployee()))
				.thenReturn(EmployeeDataFixture.stadardEmployee());

		EmployeeDetails details = employeeService.saveEmployee(EmployeeDataFixture.stadardEmployee());
		assertEquals(details.getName(), EmployeeDataFixture.name);
		assertEquals(details.getSalary(), EmployeeDataFixture.salary);
		assertEquals(details.getDepartment(), EmployeeDataFixture.department);
		assertThat(details).hasFieldOrPropertyWithValue("name", EmployeeDataFixture.name);

	}

	@Test
	public void getEmployeeTest() {
		when(employeeRepository.findById(EmployeeDataFixture.id))
				.thenReturn(EmployeeDataFixture.getStandardEmployeeOptional());

		EmployeeDetails details = employeeService.getEmployee(EmployeeDataFixture.id);
		assertEquals(details.getName(), EmployeeDataFixture.name);
		assertEquals(details.getSalary(), EmployeeDataFixture.salary);
		assertEquals(details.getDepartment(), EmployeeDataFixture.department);
		assertThat(details).hasFieldOrPropertyWithValue("name", EmployeeDataFixture.name);

	}

	@Test
	public void deleteEmployeeTest() {
		Boolean details = employeeService.deleteEmployee(EmployeeDataFixture.id);
		assertTrue(details);
	}

	@Test
	public void getAllEmployeeTest() {
		when(employeeRepository.findAll()).thenReturn(EmployeeDataFixture.standardEmployeeList());
		List<EmployeeDetails> details = employeeService.getAllEmployeeDetails();
		assertThat(details).hasSize(1);
	}

}
