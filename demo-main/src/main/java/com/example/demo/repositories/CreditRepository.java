package com.example.demo.repositories;

import com.example.demo.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
   // List<credit> findByMontant(double montant);
}
