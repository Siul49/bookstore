package com.example.repository;

import com.example.model.Book;
import java.util.ArrayList;
import java.util.List;

// 도서 목록을 저장하고 관리하는 클래스 (도서 저장소 역할)
public class BookRepository {

    // 모든 도서 정보를 저장할 정적 리스트 (애플리케이션 전역에서 공유됨)
    private static final List<Book> books = new ArrayList<>();

    // 클래스가 처음 로딩될 때 실행되는 static 블록: 초기 도서 5권 등록
    static {
        books.add(new Book(1, "축구의 역사", "굿스포츠", 7000));
        books.add(new Book(2, "축구 아는 여자", "나무수", 13000));
        books.add(new Book(3, "축구의 이해", "대한미디어", 22000));
        books.add(new Book(4, "골프 바이블", "대한미디어", 35000));
        books.add(new Book(5, "피겨 교본", "굿스포츠", 8000));
    }

    // 도서 리스트 전체를 반환하는 메서드 (읽기 전용)
    public static List<Book> getBooks() {
        return books;
    }

    // 새로운 도서를 리스트에 추가하는 메서드
    public static void addBook(Book book) {
        books.add(book);
    }
}
