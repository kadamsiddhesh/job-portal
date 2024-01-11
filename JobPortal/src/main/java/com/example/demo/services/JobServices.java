package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.models.JobAddress;
import com.example.demo.models.Jobs;
import com.example.demo.projections.EmployeeProjection;
import com.example.demo.projections.JobProjections;
import com.example.demo.repo.JobAddressRepo;
import com.example.demo.repo.JobRepo;

@Service
public class JobServices {

	@Autowired
	JobRepo jobRepo;
	
	@Autowired
	JobAddressRepo jobAddressRepo;
	
	public Iterable<JobProjections> getAllJobs() {
		return this.jobRepo.findAllJobBy();
	}
	
	public JobProjections getJobById(int id) {
		return this.jobRepo.findJobById(id).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found" );});
	}
	
	public Iterable<JobProjections> getByTitle(String title) {
		return this.jobRepo.findByTitle(title);
	}
	
	public Iterable<JobProjections> getByCompanyName(String companyName) {
		return this.jobRepo.findByCompanyName(companyName);
	}
	
	public Jobs addJob(Jobs jobs) {
		return this.jobRepo.save(jobs);
	}
	
	public void deleteJob(int id) {
		this.jobRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		});
		this.jobRepo.deleteById(id);
	}

	public Jobs getUserwithpassword(int id) {
		return this.jobRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		});
	}
	
	public Jobs updateJob(int id, Jobs jobs) {
		Jobs jobData = getUserwithpassword(id);
		jobs.setId(id);
		return this.jobRepo.save(jobs);
	}
	
	public JobAddress addJobAddress(int id, JobAddress jobAddress) {
		Jobs jobData = getUserwithpassword(id);
		JobAddress addressdata = this.jobAddressRepo.save(jobAddress);
		jobData.setAddress(addressdata);
		this.jobRepo.save(jobData);
		return addressdata;
	}
	
}
