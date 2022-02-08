package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	private int companyCode;
	private String companyName;
	private String companyCEO;
	private String turnover;
	private String website;
	private String stockExchange;
	private double stockPrice;
	private String timeStamp;
	
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
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
	
	
	
	
	
}
