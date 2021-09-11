package com.dynamic.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dynamic.data.entity.UserProfileModel;

public interface UserProfileRepository extends MongoRepository<UserProfileModel, String> {
@Query("{'email':?0}")
	public List<UserProfileModel> findUserByEmail(String email);

}
