package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.DTO.UserDTO;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> findCurrentUser(){
        UserDTO dto = service.findCurrentUser();
        return ResponseEntity.ok().body(dto);
    }
}
