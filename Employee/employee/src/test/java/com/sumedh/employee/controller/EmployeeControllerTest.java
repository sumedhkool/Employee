package com.sumedh.employee.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sumedh.employee.datafixture.EmployeeDataFixture;
import com.sumedh.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void saveEmployeeTest() throws Exception {
		when(employeeService.saveEmployee(EmployeeDataFixture.stadardEmployee()))
				.thenReturn(EmployeeDataFixture.stadardEmployee());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveEmployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":1,\"name\":\"Sumedh\",\"salary\":50000.00,\"department\":\"Technology\"}");

		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content()
				.json("{\"id\":1,\"name\":\"Sumedh\",\"salary\":50000.00,\"department\":\"Technology\"}", false));
	}

	@Test
	public void deleteEmployeeTest() throws Exception {
		when(employeeService.deleteEmployee(EmployeeDataFixture.id)).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/deleteEmployee")
				.contentType(MediaType.APPLICATION_JSON).content("{\"id\":1}");

		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}

	@Test
	public void getEmployeeTest() throws Exception {
		when(employeeService.getEmployee(EmployeeDataFixture.id)).thenReturn(EmployeeDataFixture.stadardEmployee());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getEmployee")
				.contentType(MediaType.APPLICATION_JSON).content("{\"id\":1}");

		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content()
				.json("{\"id\":1,\"name\":\"Sumedh\",\"salary\":50000.00,\"department\":\"Technology\"}", false));
	}

}
