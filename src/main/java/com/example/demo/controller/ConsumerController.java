package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@RestController
@RequestMapping("auth/v1/company")
public class ConsumerController {
/*
	@Autowired
	DiscoveryClient discoveryClient;
	
	@PostMapping("/login")
	public void getAuthToken(@RequestBody User user) {
		List<ServiceInstance> instances = discoveryClient.getInstances("user-producer");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		RestTemplate restTemplate = new RestTemplate();
		baseUrl+="/auth/v1/userLogin";
		
		String response = null;
		
	
		try {
			response = restTemplate.postForObject(baseUrl,getHeaders(user), String.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Result*****"+response);
		
	}
	
	private static HttpEntity<?> getHeaders(User user) throws Exception
	{
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<User>(user,headers);
	}*/
}
