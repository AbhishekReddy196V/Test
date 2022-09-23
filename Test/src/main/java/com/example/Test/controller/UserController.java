package com.example.Test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test.entity.UserResponse;
import com.example.Test.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	Logger log = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/api/details")
	public ResponseEntity<List<UserResponse>> getDetails() {
		
		log.info("Entered getDetails() of UserController");

		List<UserResponse> resp=userService.getUserDetails();
		
		log.info("Exiting getDetails() of UserController");

		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

}
