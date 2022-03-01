package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1.0/stockmarket")
public class StockController {
	
	@Autowired
	StockService stockService;

	@GetMapping("/stock/getallstocks/{companyid}")
	public ResponseEntity<?> getAllStocks(@PathVariable("companyid") int companyId){
		List<Stock> stockList = stockService.getAllStockByCompanyId(companyId);
		if(stockList!=null) {
			return new ResponseEntity<List<Stock>>(stockList, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No stocks with company Id", HttpStatus.NO_CONTENT);
	}
}
