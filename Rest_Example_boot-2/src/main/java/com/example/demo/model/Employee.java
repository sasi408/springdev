package com.example.demo.model;

//http://localhost:8080/add/employee?empId=1&name=rao
public class Employee {
	private String empId;
	private String name;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
