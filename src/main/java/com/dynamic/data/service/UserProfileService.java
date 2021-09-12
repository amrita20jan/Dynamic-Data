package com.dynamic.data.service;

import java.util.List;

import com.dynamic.data.entity.UserProfileModel;

public interface UserProfileService {

	public UserProfileModel registerUserProfile(UserProfileModel userProfileModel);

	public List<UserProfileModel> getUSerByEmail(String email);

}
