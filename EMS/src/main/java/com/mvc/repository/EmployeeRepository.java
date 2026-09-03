package com.mvc.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mvc.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Optional<Employee> findByEmailAndPassword(String email, String password);
	public Optional<Employee> findByEmail(String email); 
}
