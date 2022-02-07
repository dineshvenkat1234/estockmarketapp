package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("api/v1.0/market/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllCompanies(){
		List<Company> companyList = companyService.getAllCompanies();
		if(companyList!=null) {
			return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Company List is Empty!",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/register", consumes = "application/json; charset=utf-8")
	public ResponseEntity<?> addCompany(@RequestBody Company company){
		if(companyService.addCompany(company)!=null) {
			 return new ResponseEntity<Company>(company, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Sorry data is not inserted!",HttpStatus.CONFLICT);
	}
}
