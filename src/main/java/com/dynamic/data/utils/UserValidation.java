package com.dynamic.data.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dynamic.data.entity.UserProfileModel;
import com.dynamic.data.repository.UserProfileRepository;

@Component
public class UserValidation {

	@Autowired
	UserProfileRepository userProfileRepository;

	public boolean checkEmailExist(String email) {
		List<UserProfileModel> profile = userProfileRepository.findUserByEmail(email);
		if (profile.size() > 0) {
			return true;
		}
		return false;
	}
}
