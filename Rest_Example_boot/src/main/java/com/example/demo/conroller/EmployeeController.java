package com.example.demo.conroller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.exception.KeywordNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Employees;
import com.example.demo.model.ErrorDetail;

@RestController

@RequestMapping(path = "/employees")

public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDao;

	@GetMapping(path = "/", produces = "application/json")
	public Employees getEmployees() {
		return employeeDao.getAllEmployees();
	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		Integer id = employeeDao.getAllEmployees().getEmployees().size() + 1;
		employee.setId(id);

		employeeDao.addEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public Employee getEmployeeByName(@PathVariable String name) {
		if (employeeDao.getEmployeeByname(name).equals(null)) {
			throw new KeywordNotFoundException("key111");
		} else {
			return employeeDao.getEmployeeByname(name);
		}
	}

	@ExceptionHandler(KeywordNotFoundException.class)
	public ErrorDetail myError(HttpServletRequest request, Exception exception) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getLocalizedMessage());
		error.setUrl(request.getRequestURL().append("/error/111").toString());
		return error;
	}

}
