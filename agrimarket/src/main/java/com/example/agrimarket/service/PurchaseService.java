package com.example.agrimarket.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.agrimarket.model.Buyer;
import com.example.agrimarket.model.Farmer;
import com.example.agrimarket.model.Product;
import com.example.agrimarket.model.Transaction;
import com.example.agrimarket.repository.*;

@Service
public class PurchaseService {

	private ProductRepository productRepo;
	private BuyerRepository buyerRepo;
	private TransactionRepository transactionRepo;
	private FarmerRepository farmrepo;

	public PurchaseService(ProductRepository productRepo, BuyerRepository buyerRepo, TransactionRepository transactionRepo, FarmerRepository farmrepo) {
	    this.productRepo = productRepo;
	    this.buyerRepo = buyerRepo;
	    this.transactionRepo = transactionRepo;
	    this.farmrepo = farmrepo;
	}
	
	public String purchase(int productId, int buyerId, int qty) {
	    Product p = productRepo.findById(productId).orElse(null);
	    if (p == null) return "Product not found";

	    if (qty <= 0) return "Invalid quantity";
	    if (p.getQty() < qty) return "Insufficient stock";

	    Buyer b = buyerRepo.findById(buyerId).orElse(null);
	    if (b == null) return "Buyer not found";

	    int total = p.getPrice() * qty;
	    if (b.getWallet() < total) return "Insufficient balance";

	    // ✅ Fetch farmer directly from repo — guaranteed managed entity
	    Farmer f = farmrepo.findById(p.getFarmer().getId()).orElse(null);
	    if (f == null) return "Farmer not found";

	    // ✅ Single clean update — no double addition
	    p.setQty(p.getQty() - qty);
	    b.setWallet(b.getWallet() - total);
	    f.setWallet(f.getWallet() + total);

	    Transaction t = new Transaction();
	    t.setProduct(p);
	    t.setQty(qty);
	    t.setTotalPrice(total);
	    t.setBuyer(b);
	    t.setFarmer(f);
	    t.setPurchaseDate(LocalDateTime.now());

	    transactionRepo.save(t);
	    productRepo.save(p);
	    buyerRepo.save(b);
	    farmrepo.save(f);   // ✅ Now saves a properly managed entity

	    return "Purchase successful";
	}
	
}
