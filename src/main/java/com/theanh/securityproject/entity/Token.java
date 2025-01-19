package com.theanh.securityproject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String token;

    @Column
    LocalDateTime createdAt;

    @Column
    LocalDateTime expiresAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    User user;
}
