package com.upgrad.bookmyconsultation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.bookmyconsultation.entity.Address;




//mark it as repository
//create an interface AddressRepository that extends CrudRepository

@Repository
public interface AddressRepository extends CrudRepository<Address, String>{
  
}