package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Company;

public interface CompanyService {

	public List<Company> getAllCompanies();
	
	public Company addCompany(Company company);
}
