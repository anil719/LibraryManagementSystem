package com.example.LMS.entities;


import com.example.LMS.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date issuedDate;


    @UpdateTimestamp
    private Date updatedOn;

    private String validTill;

    @Enumerated(EnumType.STRING)
    private Status status;


    @OneToOne
    @JoinColumn
    Student student;


    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> bookIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade=CascadeType.ALL)
    List<Transactions> transaction = new ArrayList<>();

}
