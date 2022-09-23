package com.example.Test.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Test.entity.Details;
import com.example.Test.entity.UserDetailsResponseVo;
import com.example.Test.entity.UserResponse;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;

	Logger log = LoggerFactory.getLogger(UserService.class);

	public List<UserResponse> getUserDetails() {

		log.info("Entered getUserDetails() of UserService");

		List<UserResponse> resp = new ArrayList<>();
		try {
			ResponseEntity<List<UserDetailsResponseVo>> responseEntity = restTemplate.exchange(
					"https://jsonplaceholder.typicode.com/users", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<UserDetailsResponseVo>>() {
					});
			List<UserDetailsResponseVo> userDetails = responseEntity.getBody();

			ResponseEntity<List<Details>> data = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<Details>>() {
					});
			List<Details> det = data.getBody();

			for (UserDetailsResponseVo d : userDetails) {

				for (Details info : det) {

					if (d.getId() == info.getId()) {
						UserResponse res = new UserResponse();
						res.setId(info.getId());
						res.setName(d.getName());
						res.setLat(d.getAddress().getGeo().getLat());
						res.setLng(d.getAddress().getGeo().getLng());
						res.setBody(info.getBody());
						res.setTitle(info.getTitle());
						resp.add(res);
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		log.info("Exiting getUserDetails() of UserService");

		return resp;
	}

}
