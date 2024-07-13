package com.example.demo.Controller;

import com.example.demo.entities.Type;
import com.example.demo.repositories.TypeRepository;
import com.example.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public List<Type> getAllTypes() {
        return typeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable("id") Long id) {
        return typeService.getTypeById( id);
    }

    @PostMapping("")
    public ResponseEntity<Type> createType(@RequestBody Type type) {
        return typeService.create(type);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> updateType(@PathVariable("id") Long id, @RequestBody Type typeDetails) {
        return typeService.update(id, typeDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteType(@PathVariable("id") Long id) {
        return typeService.delete(id);
    }
}
