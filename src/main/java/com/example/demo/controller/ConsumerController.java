package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@RestController
public class ConsumerController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	public void getAuthToken() {
		List<ServiceInstance> instances = discoveryClient.getInstances("user-producer");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		RestTemplate restTemplate = new RestTemplate();
		baseUrl+="/auth/v1/login";
		
		String response = null;
		
	
		try {
			response = restTemplate.postForObject(baseUrl,getHeaders(), String.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Result*****"+response);
		
	}
	
	private static HttpEntity<?> getHeaders() throws Exception
	{
		User user = new User();
		user.setUsername("dinesh");
		user.setPassword("pass123");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<User>(user,headers);
	}
}
