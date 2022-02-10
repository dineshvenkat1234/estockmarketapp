package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CompanyIDAlreadyExistsExceptions;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompanies() {
		List<Company> companyList = companyRepository.findAll();
		if(companyList!=null && companyList.size()>0) {
			return companyList;
		}
		return null;
	}

	@Override
	public Company addCompany(Company company) throws CompanyIDAlreadyExistsExceptions{
		Optional<Company> optional = companyRepository.findById(company.getCompanyCode());
		if(optional.isPresent()) {
			throw new CompanyIDAlreadyExistsExceptions();
		}
		return companyRepository.saveAndFlush(company);
	}

	@Override
	public boolean deleteCompany(int companyId) {
		companyRepository.deleteById(companyId);
		return true;
	}

	@Override
	public Company getCompany(int companyId) {
		
		Company company=companyRepository.findById(companyId).get();
		
		return company;
	}

	@Override
	public Company addStockPrice(int companyId, Company company) {
		Company company1= companyRepository.findById(companyId).get();
		company1.setStockPrice(company.getStockPrice());
		company1.setTimeStamp();
		return companyRepository.saveAndFlush(company1);
	}

	@Override
	public Company updateStockPrice(int companyId, Company company) {
		Company company1= companyRepository.findById(companyId).get();
		company1.setStockPrice(company.getStockPrice());
		company1.setTimeStamp();
		return companyRepository.saveAndFlush(company1);
	}
}
