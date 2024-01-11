package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.JobAddress;

public interface JobAddressRepo extends CrudRepository<JobAddress, Integer> {

}
