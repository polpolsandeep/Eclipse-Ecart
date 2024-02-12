package com.sandeep.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.Stock;
import com.sandeep.ecart.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	public Stock addStock(Stock stock) {
		try {
		    return stockRepository.save(stock);
		}
		catch(Exception px) {
			System.err.println("Exception Occured In addStock :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public boolean deleteStock(int stockId) {
         try {
        	 stockRepository.deleteById(stockId);
        	 return true;
         }		
         catch(Exception px) {
        	 System.err.println("Exception Occured In deleteStock :"+px.getMessage()+"Cause :"+px.getCause());
         }
         return false;
	}
	public List<Stock> getStocks(){
		try {
			return stockRepository.findAll();
		}
		catch(Exception px) {
			System.err.println("Exception Occured In getStocks:"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public Stock getStock(int stockId) {
		try {
		  return stockRepository.findById(stockId).get();	
		}
		catch(Exception px) {
			System.err.println("Exception Occured In getStock :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}

}
