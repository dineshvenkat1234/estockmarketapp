package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Company addCompany(Company company) {
		if(company!=null) {
			return companyRepository.saveAndFlush(company);
		}
		return null;
	}
}
