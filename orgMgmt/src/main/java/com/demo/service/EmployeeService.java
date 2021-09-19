package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	/*
	 * @PostConstruct private void postConstruct() {
	 * 
	 * Asset asset = new Asset(); asset.setAssetName("Laptop");
	 * asset.setAssetType("Hardware");
	 * 
	 * Organization org = new Organization(); org.setOrgId(1);
	 * org.setOrgName("Org"); org.setBranch("Chennai");
	 * 
	 * Employee employee1 = new Employee("Sandhya", "Kalidasan", "abc@gmail.com",
	 * "Lead", 1); Employee employee2 = new Employee("John", "Peter",
	 * "xyz@gmail.com", "Developer", 2);
	 * 
	 * employeeRepository.save(employee1); employeeRepository.save(employee2); }
	 */

	// getting all employee records
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}

	// getting a specific record
	public Employee getEmployeeById(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with the id - " + id + " not exist"));

		if (employee == null)
			throw new ResourceNotFoundException("id-" + id);

		return employee;
	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee update(long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with the id - " + id + " not exist"));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());		
		employee.setDesignation(employeeDetails.getDesignation());
		employee.setOrg(employeeDetails.getOrg());
		 
		return employeeRepository.save(employee);
	}

	// deleting a specific record
	public void delete(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with the id - " + id + " not exist"));
		employeeRepository.delete(employee);
		if (employee == null)
			throw new ResourceNotFoundException("id-" + id);
	}
}
