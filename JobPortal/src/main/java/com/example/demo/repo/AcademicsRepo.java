package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Academics;

public interface AcademicsRepo extends CrudRepository<Academics, Integer> {

}
