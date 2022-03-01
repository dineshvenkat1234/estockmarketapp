package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;

@Service
public class StockServiceImpl  implements StockService{

	@Autowired
	private StockRepository stockrepository;
	
	@Override
	public Stock addStock(Stock stock) {
		return stockrepository.saveAndFlush(stock);
	}

	@Override
	public List<Stock> getAllStockByCompanyId(int companyId) {
		List<Stock> stockList = stockrepository.getAllStockByCompanyId(companyId);
		return stockList;
	}

}
