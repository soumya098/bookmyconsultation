package com.upgrad.bookmyconsultation.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.bookmyconsultation.entity.UserAuthToken;

@Repository
public interface UserAuthTokenRepository extends CrudRepository<UserAuthToken, Long> {

	UserAuthToken findFirstByUserEmailIdOrderByLoginAtDesc(@NotNull String userId);

	UserAuthToken findByAccessToken(String token);

}
