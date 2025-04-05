package com.upgrad.bookmyconsultation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.upgrad.bookmyconsultation.repository.DoctorRepository;
import com.upgrad.bookmyconsultation.repository.RatingsRepository;

@Service
public class RatingsService {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private RatingsRepository ratingsRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	// create a method name submitRatings with void return type and parameter of
	// type Rating
	// set a UUID for the rating
	// save the rating to the database
	// get the doctor id from the rating object
	// find that specific doctor with the using doctor id
	// modify the average rating for that specific doctor by including the new
	// rating
	// save the doctor object to the database

}
