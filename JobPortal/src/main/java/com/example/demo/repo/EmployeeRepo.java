package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Employee;
import com.example.demo.projections.EmployeeProjection;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	public Iterable<EmployeeProjection> findAllUserBy();

	public Optional<EmployeeProjection> findUserById(int id);

	public Iterable<EmployeeProjection> findByName(String name);

	public Iterable<EmployeeProjection> findByNameContaining(String name);
}
