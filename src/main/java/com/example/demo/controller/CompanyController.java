package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.CompanyIDAlreadyExistsExceptions;
import com.example.demo.model.Company;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.CompanyService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1.0/market")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/company/getall")
	public ResponseEntity<?> getAllCompanies(){
		List<Company> companyList = companyService.getAllCompanies();
		if(companyList!=null) {
			//CacheControl cacheControl=CacheControl.maxAge(5,TimeUnit.MINUTES);
			//return ResponseEntity.ok().cacheControl(cacheControl).body(ResponseHandler.generateResponse("Succesfully retrieved the data", HttpStatus.OK,companyList));
			return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Company List is Empty!",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/company/register", consumes = "application/json; charset=utf-8")
	public ResponseEntity<?> addCompany(@RequestBody Company company) throws CompanyIDAlreadyExistsExceptions{
		if(companyService.addCompany(company)!=null) {
			 return new ResponseEntity<Company>(company, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Sorry data is not inserted!",HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/company/delete/{companycode}")
	public ResponseEntity<?> deleteCompany(@PathVariable("companycode") int companyCode){
		if(companyService.deleteCompany(companyCode)) {
			return new ResponseEntity<String>("Records Deleted",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Cannt delete due to error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/company/info/{companycode}")
	public ResponseEntity<?> getCompany(@PathVariable("companycode") int companyCode){
		Company company=companyService.getCompany(companyCode);
		if(company!=null) {
			return new ResponseEntity<Company>(company, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No company found with ID", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/stock/add/{companycode}", consumes = "application/json; charset=utf-8")
	public ResponseEntity<?> addStockPrice(@PathVariable("companycode") int companyCode,@RequestBody Company company){
		Company company1 = companyService.addStockPrice(companyCode, company);
		if(company1!=null) {
			return new ResponseEntity<Company>(company1, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Stock price not inserted",HttpStatus.CONFLICT);
	}
	
	@PutMapping(value="/stock/put/{companycode}", consumes = "application/json; charset=utf-8")
	public ResponseEntity<?> updateStockPrice(@PathVariable("companycode") int companyCode,@RequestBody Company company){
		Company company1 = companyService.updateStockPrice(companyCode, company);
		if(company1!=null) {
			return new ResponseEntity<Company>(company1, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Stock price not updated",HttpStatus.CONFLICT);
	}
}
