package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Stock;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer>{

	@Query(value="select s from Stock s where s.companyId= :companyId ")
	public List<Stock> getAllStockByCompanyId(int companyId);
}
