package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Academics;
import com.example.demo.models.Address;
import com.example.demo.models.Employee;
import com.example.demo.projections.EmployeeProjection;
import com.example.demo.repo.AcademicsRepo;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	AcademicsRepo academicsRepo;

	public Employee getUserwithpassword(int id) {
		return this.employeeRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		});
	}

	public Iterable<EmployeeProjection> getAllUser() {
		return this.employeeRepo.findAllUserBy();
	}
	
	public EmployeeProjection getUserById(int id) {
		return this.employeeRepo.findUserById(id).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found" );});
	}

	public Iterable<EmployeeProjection> getByName(String name) {
		return this.employeeRepo.findByName(name);
	}

	public Iterable<EmployeeProjection> getByAnyName(String name) {
		return this.employeeRepo.findByNameContaining(name);
	}

	public Employee createUser(Employee employee) {
		return this.employeeRepo.save(employee);
	}

	public void deleteUser(int id) {
		this.employeeRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		});
		this.employeeRepo.deleteById(id);
	}

	public Employee updateUser(int id, Employee employee) {
		Employee userData = getUserwithpassword(id);
		employee.setId(id);
		return this.employeeRepo.save(employee);
	}

	public Address addAddress(int id, Address address) {
		Employee userData = getUserwithpassword(id);
		Address addressdata = this.addressRepo.save(address);
		userData.setAddress(addressdata);
		this.employeeRepo.save(userData);
		return addressdata;
	}

	public Academics addAcademics(int id, Academics academics) {
		Employee userData = getUserwithpassword(id);
		Academics academicdata = this.academicsRepo.save(academics);
		userData.setAcademics(academicdata);
		this.employeeRepo.save(userData);
		return academicdata;
	}
}
