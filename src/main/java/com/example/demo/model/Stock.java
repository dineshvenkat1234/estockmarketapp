package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	private int companyId;
	private double stockPrice;
	private String timeStamp;
	

	public Stock() {
		
	}
	public Stock(int stockId ,int companyId, double stockPrice, String timeStamp) {
		super();
		this.stockId = stockId;
		this.stockPrice = stockPrice;
		this.timeStamp = timeStamp;
		this.companyId = companyId;
	}
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp() {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		this.timeStamp=formater.format(new Date());
	}
	
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	






}
