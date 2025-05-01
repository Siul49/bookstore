package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Purchase;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.PurchaseRepository;
import com.example.bookstore.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public PurchaseService(PurchaseRepository purchaseRepository,
                          UserRepository userRepository,
                          BookRepository bookRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void createPurchase(String username, Long bookId) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다: " + username));

        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다: " + bookId));

        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setBook(book);
        purchase.setPrice(book.getPrice());
        purchase.setPurchaseDate(LocalDateTime.now());

        purchaseRepository.save(purchase);
    }

    public List<Purchase> getPurchasesByUsername(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다: " + username));

        return purchaseRepository.findByUserOrderByPurchaseDateDesc(user);
    }
}
