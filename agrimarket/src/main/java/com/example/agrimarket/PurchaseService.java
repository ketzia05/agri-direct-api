package com.example.agrimarket;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

	private ProductRepository productRepo;
	private BuyerRepository buyerRepo;
	private TransactionRepository transactionRepo;

	public PurchaseService(ProductRepository productRepo, BuyerRepository buyerRepo, TransactionRepository transactionRepo) {
	    this.productRepo = productRepo;
	    this.buyerRepo = buyerRepo;
	    this.transactionRepo = transactionRepo;
	}
	
	public String purchase(int productId, int buyerId, int qty) {
		Product p = productRepo.findById(productId).orElse(null);

		if (p == null) {
		    return "Product not found";
		}
		
		if (qty <= 0) {
		    return "Invalid quantity";
		}

		if (p.getQty() < qty) {
		    return "Insufficient stock";
		}
		
		Buyer b = buyerRepo.findById(buyerId).orElse(null);

		if (b == null) {
		    return "Buyer not found";
		}
		
		int total = p.getPrice() * qty;

		if (b.getBal() < total) {
		    return "Insufficient balance";
		}
		
		p.setQty(p.getQty() - qty);
		b.setBal(b.getBal() - total);
		
		Transaction t = new Transaction();

		t.setProduct(p);
		t.setQty(qty);

		t.setTotalPrice(total);

		t.setBuyer(b);

		t.setPurchaseDate(LocalDateTime.now());

		transactionRepo.save(t);
		
		productRepo.save(p);
		buyerRepo.save(b);
		
		return "Purchase successful";
	}
	
}
