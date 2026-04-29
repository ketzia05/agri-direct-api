package com.example.agrimarket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findByBuyerId(int buyerId);

	List<Transaction> findByFarmerId(int farmerId);

}
