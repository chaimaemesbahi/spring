package com.example.demo.repositories;

import com.example.demo.entities.Client;
import com.example.demo.entities.Client;
import com.example.demo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  //  List<client> findByType(double client);
}
