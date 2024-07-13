package com.example.demo.Controller;

import com.example.demo.entities.Credit;
import com.example.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("")
    public List<Credit> getAllCredits() {
        return creditService.findAll();
    }

    @GetMapping("/{id}")
    public Credit getCreditById(@PathVariable("id") Long id) {
        return creditService.getCreditById(id).getBody();
    }

    @PostMapping("")
    public ResponseEntity<Credit> createCredit(@RequestBody Credit credit) {
        return creditService.create(credit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credit> updateCredit(@PathVariable("id") Long id, @RequestBody Credit creditDetails) {
        return creditService.update(id, creditDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCredit(@PathVariable("id") Long id) {
        return creditService.delete(id);
    }
}
