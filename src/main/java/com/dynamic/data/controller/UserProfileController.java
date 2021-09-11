package com.dynamic.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynamic.data.entity.UserProfileModel;
import com.dynamic.data.service.UserProfileService;

@RestController
@RequestMapping("/user")
public class UserProfileController {
	
	@Autowired UserProfileService userProfileService; 
	
	@PostMapping("/registerUserProfile")
	public UserProfileModel registerUserProfile(@RequestBody UserProfileModel userProfileModel) {
		return userProfileService.registerUserProfile(userProfileModel);
	}
	
	@GetMapping(value = "/getByEmailID")
public List<UserProfileModel> getUSerByEmail(@RequestParam String email){
	return userProfileService.getUSerByEmail(email);
		
	}	

}
