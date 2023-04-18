package com.example.LMS.entities;

import com.example.LMS.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING)
    Genre genre;

    private int noOfPages;
    private int price;

    private boolean isIssued= false;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL)
    List<Transactions> transactionList;
}
