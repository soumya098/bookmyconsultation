package com.upgrad.bookmyconsultation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.bookmyconsultation.entity.Rating;

//mark it as repository
//create an interface RatingsRepository that extends CrudRepository
//create a method findByDoctorId that returns a list of type Rating
//define method parameter doctorId of type String

@Repository
public interface RatingsRepository extends CrudRepository<Rating, String> {
	public List<Rating> findByDoctorId(String doctorId);
}