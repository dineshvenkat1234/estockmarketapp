package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Stock;

public interface StockService {

	public Stock addStock(Stock stock);
	
	public List<Stock> getAllStockByCompanyId(int companyId);
	
	public Stock updateStock(int companyId,Stock stock );
}
