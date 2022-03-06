package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	@Transient
	private int companyCode;
	private double stockPrice;
	private String timeStamp;
	

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "companyCode")
	@JsonIgnore
	private Company company;
	
	public Stock() {
		
	}
	
	
	public Stock(int stockId, int companyCode, double stockPrice, String timeStamp, Company company) {
		super();
		this.stockId = stockId;
		this.companyCode = companyCode;
		this.stockPrice = stockPrice;
		this.timeStamp = timeStamp;
		this.company = company;
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
	public int getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
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
