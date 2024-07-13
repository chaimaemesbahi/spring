package com.example.demo.DTO;

import com.example.demo.entities.User;
import com.example.demo.entities.Type;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.Credit;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private User user;
    private Type type;
    private List<Transaction> transactionList;
    private List<Credit> creditList;

    // Optionally, you can add methods to manipulate or access data if needed
    public String getFullName() {
        return this.nom + " " + this.prenom;
    }
}
