package com.dynamic.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.dynamic.data.entity.UserProfileModel;
import com.dynamic.data.repository.UserProfileRepository;
import com.dynamic.data.service.UserProfileService;
import com.dynamic.data.utils.CommonValidator;
import com.dynamic.data.utils.UserValidation;
import com.dynamic.exception.EmailIdAlreadyExist;
import com.dynamic.exception.IncorrectPassword;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserProfileServiceImpl implements UserProfileService{
	@Autowired UserProfileRepository userProfileRepository;
	@Autowired UserValidation userValidation;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired UserValidation usrValidation;
	
		
	@Override
	public UserProfileModel registerUserProfile(UserProfileModel userProfileModel) {
		System.out.println("Email has been registered to User :" +userProfileModel);
		boolean checkEmail=userValidation.checkEmailExist(userProfileModel.getEmail());
		if(!checkEmail) {
			return userProfileRepository.save(userProfileModel);	
		}
		throw new EmailIdAlreadyExist("Email ID already exist");
	}

	@Override
	public List<UserProfileModel> getUSerByEmail(String email) {
		UserDetails usrName = myUserDetailsService
				.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		System.out.println("username is "+usrName.getUsername());
		boolean checkIfUserExist = usrValidation.checkEmailExist(email);
		log.debug("checking username********************"+usrName.getUsername());
		if(checkIfUserExist) {
			List<UserProfileModel> profileModels=userProfileRepository.findUserByEmail(email);
			log.debug("checking profileModels********************"+profileModels.size());
			if(!CommonValidator.checkIfEmpty(profileModels)) {
				return profileModels;
			}else
			throw new EmailIdAlreadyExist("Email ID Not exist");
		}
		 else
			throw new IncorrectPassword("Incorrect Password");
	}
}
