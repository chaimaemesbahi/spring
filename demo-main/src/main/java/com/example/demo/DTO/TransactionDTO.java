package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {

    private Integer id;
    private String montant;
    private String dateTrans;
    private String type;
    private Integer clientId; // Assuming you only need the client ID in DTO

    // Optionally, you can add methods to manipulate or access data if needed
}
