package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Employees;

@Repository
public class EmployeeDAO {
	private static Employees list = new Employees();
	static {
		list.getEmployees().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
		list.getEmployees().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
		list.getEmployees().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
	}

	public Employees getAllEmployees() {
		return list;
	}

	public void addEmployee(Employee employee) {
		list.getEmployees().add(employee);
	}

	public Employee getEmployeeByname(String name) {
		return list.getEmployeeByname(name);
	}
}
