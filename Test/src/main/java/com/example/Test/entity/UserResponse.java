package com.example.Test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private int id;
	private String name;
	private String lat;
	private String lng;
	private String title;
	private String body;
}
