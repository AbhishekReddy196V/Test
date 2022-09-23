package com.example.Test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsResponseVo {

	
	private int id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	private Company company;
	private Address address;
	
	
}
