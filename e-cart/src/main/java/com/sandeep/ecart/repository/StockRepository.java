package com.sandeep.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.ecart.model.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {

}
