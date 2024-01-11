package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Jobs;
import com.example.demo.projections.EmployeeProjection;
import com.example.demo.projections.JobProjections;

public interface JobRepo extends CrudRepository<Jobs, Integer> {

	public Iterable<JobProjections> findAllJobBy();
	
	public Optional<JobProjections> findJobById(int id);
	
	public Iterable<JobProjections> findByTitle(String title);
	
	public Iterable<JobProjections> findByCompanyName(String companyName);
}
