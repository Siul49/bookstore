package com.example.model;

// 도서 정보를 표현하는 클래스
public class Book {
    // 도서 번호, 제목, 출판사, 가격 정보를 저장하는 멤버 변수
    private int id;
    private String title;
    private String publisher;
    private int price;

    // 생성자: 객체 생성 시 전달된 값으로 초기화 (유효성 검사를 포함)
    public Book(int id, String title, String publisher, int price) {
        setId(id);
        setTitle(title);
        setPublisher(publisher);
        setPrice(price);
    }

    // 도서 번호 getter
    public int getId() { return id; }

    // 도서 번호 setter (0 이하 값이면 예외 발생)
    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("도서번호는 양수여야 합니다.");
        this.id = id;
    }

    // 도서 제목 getter
    public String getTitle() { return title; }

    // 도서 제목 setter (null 또는 빈 문자열 허용 안 함)
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("도서 이름은 비어 있을 수 없습니다.");
        this.title = title;
    }

    // 출판사 getter
    public String getPublisher() { return publisher; }

    // 출판사 setter (null 또는 빈 문자열 허용 안 함)
    public void setPublisher(String publisher) {
        if (publisher == null || publisher.isEmpty()) throw new IllegalArgumentException("출판사는 비어 있을 수 없습니다.");
        this.publisher = publisher;
    }

    // 가격 getter
    public int getPrice() { return price; }

    // 가격 setter (음수일 경우 예외 발생)
    public void setPrice(int price) {
        if (price < 0) throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        this.price = price;
    }
}
