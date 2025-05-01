package com.example.bookstore.repository;

import com.example.bookstore.model.Purchase;
import com.example.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByUserOrderByPurchaseDateDesc(User user);
}
