package com.bankManagement.project.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankManagement.project.userservice.DataObject.UserDetails;
import com.bankManagement.project.userservice.proxy.BankAccountDetailsServiceProxy;
import com.bankManagement.project.userservice.repo.UserDetailsRepo;

@RestController
public class UserServiceController {

	@Autowired
	private UserDetailsRepo userDetailsRepo;
	
	@Autowired
	private BankAccountDetailsServiceProxy bankDetailsProxy;
	
	@GetMapping("/users")
	public List<UserDetails> getAllUserDetails() {
		return userDetailsRepo.findAll();
	}
	
	@GetMapping("/users/{uId}")
	public UserDetails getAllUserDetails(@PathVariable Long uId) {
		Optional<UserDetails> userOptional = userDetailsRepo.findById(uId);
		UserDetails user = new UserDetails();
		if(userOptional.isPresent()) {
			user = userOptional.get();
		}
		return user;
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody UserDetails user) {
		UserDetails bankDetails = new UserDetails();
		bankDetails.setbalance(user.getbalance());
		bankDetails.setbankAccNo(user.getbankAccNo());
		bankDetails.setIfscCode(user.getIfscCode());
		bankDetailsProxy.createNewBankAccount(user);
		userDetailsRepo.save(user);
//		return user;
	}
	
	@PutMapping("/users")
	public void updateBankDetailsForUser(@RequestBody UserDetails user) {
		UserDetails userOptional = userDetailsRepo.findByBankAccNo(user.getbankAccNo());
		userOptional.setbalance(user.getbalance());
		userDetailsRepo.save(userOptional);
	}
}
