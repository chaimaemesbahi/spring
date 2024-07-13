package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> update(Long id, User userDetails) throws InterruptedException {
        Optional<User> userOpt = userRepository.findById(id);
        System.out.println(userOpt.toString());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setTelephone(userDetails.getTelephone());


            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> delete(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<User> create(User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public List<User> findAll() {
        System.out.println("medddd");
        return userRepository.findAll();
    }
}
