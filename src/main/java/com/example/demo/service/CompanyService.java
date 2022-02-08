package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Company;

public interface CompanyService {

	public List<Company> getAllCompanies();
	
	public Company addCompany(Company company);
	
	public boolean deleteCompany(int companyId);
	
	public Company getCompany(int companyId);
	
	public Company addStockPrice(int companyId,Company company);
	
	public Company updateStockPrice(int companyId,Company company);
}
