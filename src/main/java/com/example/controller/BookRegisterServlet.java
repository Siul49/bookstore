package com.example.controller;

import com.example.model.Book;
import com.example.repository.BookRepository;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

// 사용자가 제출한 도서 정보를 받아 등록하고, 결과 페이지로 전달하는 서블릿
@WebServlet("/register")
public class BookRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 요청 인코딩 설정 (한글 깨짐 방지)
        req.setCharacterEncoding("UTF-8");

        // 폼에서 전달된 도서 정보 파라미터 받기
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String publisher = req.getParameter("publisher");
        int price = Integer.parseInt(req.getParameter("price"));

        // Book 객체 생성
        Book newBook = new Book(id, title, publisher, price);

        // 도서 리스트에 추가
        BookRepository.addBook(newBook);

        // 도서 목록을 JSP로 전달
        req.setAttribute("books", BookRepository.getBooks());

        // bookList.jsp로 포워딩
        RequestDispatcher dispatcher = req.getRequestDispatcher("bookList.jsp");
        dispatcher.forward(req, resp);
    }
}
