package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeDTO {

    private Integer id;
    private String nom;

    // Optionally, you can add methods to manipulate or access data if needed
}
