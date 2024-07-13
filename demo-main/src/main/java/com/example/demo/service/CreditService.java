package com.example.demo.service;

import com.example.demo.entities.Credit;
import com.example.demo.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public ResponseEntity<Credit> update(Long id, Credit creditDetails) {
        Optional<Credit> creditOpt = creditRepository.findById(id);
        if (creditOpt.isPresent()) {
            Credit credit = creditOpt.get();
            credit.setDate_creation(creditDetails.getDate_creation());
            credit.setMontant(creditDetails.getMontant());

            Credit savedCredit = creditRepository.save(credit);
            return new ResponseEntity<>(savedCredit, HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>(creditDetails, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> delete(Long id) {
        Credit credit = creditRepository.findById(id).orElse(null);
        if (credit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        creditRepository.delete(credit);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Credit> create(Credit credit) {
        Credit savedCredit = creditRepository.save(credit);
        return new ResponseEntity<>(savedCredit, HttpStatus.CREATED);
    }

    public ResponseEntity<Credit> getCreditById(Long id) {
        Credit credit = creditRepository.findById(id).orElse(null);
        if (credit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(credit, HttpStatus.OK);
    }

    public List<Credit> findAll() {
        return creditRepository.findAll();
    }
}
