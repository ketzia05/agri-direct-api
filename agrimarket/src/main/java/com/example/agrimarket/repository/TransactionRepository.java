package com.example.agrimarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.agrimarket.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findByBuyerId(int buyerId);

	List<Transaction> findByFarmerId(int farmerId);

}
