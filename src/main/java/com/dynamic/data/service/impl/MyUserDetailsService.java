package com.dynamic.data.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dynamic.data.entity.UserProfileModel;
import com.dynamic.data.repository.UserProfileRepository;
import com.dynamic.data.utils.CommonValidator;
import com.dynamic.exception.PasswordIncorrectException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserProfileRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		System.out.println("***********************"+emailId);
		List<UserProfileModel> userProfile = userRepository.findUserByEmail(emailId);

		log.debug("userProfile " + userProfile.size());
		System.out.println("userProfile " + userProfile.size());
		System.out.println("userProfile " + userProfile);
		if (!CommonValidator.isEmpty(userProfile)) {

			UserProfileModel userEntity = (UserProfileModel) userProfile.get(0);
			System.out.println(userEntity.getEmail() + "*******************checking jwt Service********************"
					+ userEntity.getPassword());

			System.out.println("***********************");
			return new User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
		} else
			throw new PasswordIncorrectException("Incorrect Password");
	}
}
