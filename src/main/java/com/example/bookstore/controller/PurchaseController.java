package com.example.bookstore.controller;

import com.example.bookstore.model.Purchase;
import com.example.bookstore.service.PurchaseService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // 구매 내역 목록 표시
    @GetMapping
    public String getPurchases(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        List<Purchase> purchases = purchaseService.getPurchasesByUsername(username);
        model.addAttribute("purchases", purchases);
        return "purchases";
    }

    // 도서 구매 처리
    @PostMapping
    public String createPurchase(@RequestParam Long bookId, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        try {
            purchaseService.createPurchase(username, bookId);
            redirectAttributes.addFlashAttribute("success", "도서가 성공적으로 구매되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/books/" + bookId;
    }
}
