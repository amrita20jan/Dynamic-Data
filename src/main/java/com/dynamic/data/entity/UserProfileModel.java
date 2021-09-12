package com.dynamic.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserProfile")
public class UserProfileModel {

	@Id
	private String userId;
	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private String role;

}
