package com.upgrad.bookmyconsultation.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.upgrad.bookmyconsultation.entity.Doctor;
import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.exception.ResourceUnAvailableException;
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

	public void submitRatings(Rating rating) {
		rating.setId(UUID.randomUUID().toString());
		ratingsRepository.save(rating);

		String doctorId = rating.getDoctorId();
		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceUnAvailableException());

		Double newRating = rating.getRating().doubleValue();
		Double oldRating = doctor.getRating() == null ? 0.0 : doctor.getRating();

		int ratingsCount = ratingsRepository.findByDoctorId(doctorId).size();

		Double newAverageRating = (oldRating * (ratingsCount - 1) + newRating) / ratingsCount;

    doctor.setRating(newAverageRating);

    doctorRepository.save(doctor);
	}

}
