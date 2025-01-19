package com.theanh.securityproject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true, nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String displayName;

    @Builder.Default
    @Column(nullable = false)
    boolean deleted = false;

    @ManyToMany(mappedBy = "roles")
    List<User> users;
}
