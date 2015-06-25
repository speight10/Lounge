package com.demo;

import javax.persistence.Table;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name="company")
public interface CompanyDao extends CrudRepository<Company, String> {

	  /**
	   * This method is not implemented and its working code will be
	   * automagically generated from its signature by Spring Data JPA.
	   *
	   * @param email the user email.
	   * @return the user having the passed email or null if no user is found.
	   */
	 // public Company findByCompanyName(String CompanyName);

	} // class UserDao