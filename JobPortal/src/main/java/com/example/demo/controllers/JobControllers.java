package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.JobAddress;
import com.example.demo.models.Jobs;
import com.example.demo.services.JobServices;
import com.example.demo.wrappers.ResponseWrapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobControllers {

	@Autowired
	JobServices jobServices;

	@GetMapping("")
	public ResponseEntity getAllJobs() {
		ResponseWrapper wrapper = new ResponseWrapper();
		wrapper.setMsg("all users");
		wrapper.setData(this.jobServices.getAllJobs());
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity getJobById(@PathVariable int id) {

		ResponseWrapper wrapper = new ResponseWrapper();
		wrapper.setMsg("user with id " + id);
		wrapper.setData(this.jobServices.getJobById(id));
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}

	@GetMapping("/find-by-name")
	public ResponseEntity getJobByTitle(@RequestParam String title) {

		ResponseWrapper wrapper = new ResponseWrapper();
		wrapper.setMsg("user with name " + title);
		wrapper.setData(this.jobServices.getByTitle(title));
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}

	@GetMapping("/find-by-CompanyName")
	public ResponseEntity getJobByCompanyName(@RequestParam String companyName) {

		ResponseWrapper wrapper = new ResponseWrapper();
		wrapper.setMsg("user with name " + companyName);
		wrapper.setData(this.jobServices.getByCompanyName(companyName));
		return new ResponseEntity(wrapper, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity addJob(@RequestBody @Valid Jobs jobs) {
		ResponseWrapper wrapper = new ResponseWrapper();
		wrapper.setMsg("job added successfully");
		wrapper.setData(this.jobServices.addJob(jobs));
		return new ResponseEntity(wrapper, HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteJob(@PathVariable int id) {
		this.jobServices.deleteJob(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@PutMapping("{id}")
	public ResponseEntity updateJob(@PathVariable int id, @RequestBody Jobs updatedData) {
		ResponseWrapper wrapper = new ResponseWrapper();
		wrapper.setMsg("job updated successfully");
		wrapper.setData(this.jobServices.updateJob(id, updatedData));

		return new ResponseEntity(wrapper, HttpStatus.OK);
	}
	
	@PostMapping("/{id}/address")
	public ResponseEntity addJobAddress(@PathVariable int id,@RequestBody JobAddress jobAddress) {
		ResponseWrapper wrapper=new ResponseWrapper();
		wrapper.setMsg("Address added successfully");
		wrapper.setData(this.jobServices.addJobAddress(id, jobAddress));
		
		return new ResponseEntity(wrapper,HttpStatus.OK);
	}
}
