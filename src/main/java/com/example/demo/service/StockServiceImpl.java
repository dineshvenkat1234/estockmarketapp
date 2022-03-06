package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.model.Stock;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.StockRepository;

@Service
public class StockServiceImpl  implements StockService{

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	private StockRepository stockrepository;
	
	@Override
	public Stock addStock(Stock stock) {
		Company company = companyRepository.findById(stock.getCompanyCode()).get();
		stock.setCompany(company);
		stock.setTimeStamp();
		return stockrepository.saveAndFlush(stock);
	}

	@Override
	public List<Stock> getAllStockByCompanyId(int companyId) {
		List<Stock> stockList = stockrepository.findAllByCompanyCompanyCode(companyId);
		return stockList;
	}

	@Override
	public Stock updateStock(int companyId,Stock stock) {
		/*stock.setCompanyCode(companyId);
		stock.setTimeStamp();
		return stockrepository.saveAndFlush(stock);*/
		return null;
	}

}
