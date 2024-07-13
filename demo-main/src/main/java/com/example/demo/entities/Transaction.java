package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer  id;

    @Column(name = "montant")
    private Float montant;

    @Column(name = "date_trans")
    private Date date_trans;

    @Column(name = "type")
    private String type;


    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;


}
