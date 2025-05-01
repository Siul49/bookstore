package com.example.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {
    @Id
    private Long id;

    private String username;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
}
