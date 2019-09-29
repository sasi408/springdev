package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee createEmployee(Employee employee);

	public Employee updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException;

	public Optional<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
