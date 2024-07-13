package com.example.demo.service;


import com.example.demo.entities.Type;
import com.example.demo.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository ;


    public ResponseEntity<Type> update(Long id, Type typeDetails) {
        Optional<Type> typeOpt= typeRepository.findById(id);
        if (typeOpt.isPresent()){
            Type typeReel = typeOpt.get();
            typeReel.setNom(typeDetails.getNom());
            typeReel.setId(typeDetails.getId());
            Type savedType = typeRepository.save(typeReel);
            return new ResponseEntity<>(savedType, HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>(typeDetails, HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<HttpStatus> delete(Long id) {
        Type type = typeRepository.findById(id).orElse(null);
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeRepository.delete(type);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Type> create(Type type) {
        Type savedType = typeRepository.save(type);
        return new ResponseEntity<>(savedType, HttpStatus.CREATED);
    }

    public ResponseEntity<Type> getTypeById(Long id) {
        Type type = typeRepository.findById(id).orElse(null);
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
