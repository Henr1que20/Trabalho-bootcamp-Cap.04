package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.DTO.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {
    @Autowired
    private GenreService service;
    @GetMapping
    public ResponseEntity<List<GenreDTO>> findAll(){
        List<GenreDTO> dto = service.findAll();
        return ResponseEntity.ok().body(dto);
    }

}
