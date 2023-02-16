package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTO.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;
    public List<GenreDTO> findAll() {
        List<Genre> genres = repository.findAll();
        return genres.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
    }
}
