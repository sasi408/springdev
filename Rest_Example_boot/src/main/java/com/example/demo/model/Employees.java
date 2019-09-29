package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	List<Employee> employees;

	public List<Employee> getEmployees() {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployeeByname(String name) {
		// TODO Auto-generated method stub
		Employee employe = null;
		for (Employee employee : employees) {
			if (employee.getFirstName().equals(name)) {

				employe = employee;

			}

		}
		return employe;

	}

}
