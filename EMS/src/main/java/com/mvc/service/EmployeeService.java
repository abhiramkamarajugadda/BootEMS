package com.mvc.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.model.Employee;
import com.mvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}
	public Employee checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		return repository.findByEmailAndPassword(email, password).orElse(new Employee());
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Employee searchEmployee(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email).orElse(new Employee());
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
