package com.example.LMS.entities;

import com.example.LMS.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @Column(unique = true)
    private String mobile;

    private String email;
    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Card card;
}
