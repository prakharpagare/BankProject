package com.bankManagement.project.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankManagement.project.userservice.DataObject.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
//	List<UserDetails> findAll();
	@Query("Select u from UserDetails u where bankAccNo = ?1")
	UserDetails findByBankAccNo(String bankAccNo);
}
