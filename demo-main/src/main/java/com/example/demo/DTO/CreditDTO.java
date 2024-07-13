package com.example.demo.DTO;

import com.example.demo.entities.Client;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDTO {

    private Integer id;
    private String montant;
    private String dateCreation;
    private Client client;

    // Optionally, you can add methods to manipulate or access data if needed
    public String getClientFullName() {
        return this.client.getNom() + " " + this.client.getPrenom();
    }
}

