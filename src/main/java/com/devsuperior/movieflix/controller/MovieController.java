package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.DTO.MovieDTO;
import com.devsuperior.movieflix.DTO.MovieReviewDTO;
import com.devsuperior.movieflix.DTO.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findMovie(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId, Pageable pageable) {
        Page<MovieDTO> dto = service.findMovie(pageable, genreId);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieReviewDTO> findById(@PathVariable Long id){
        MovieReviewDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReviews(@PathVariable Long id){
        List<ReviewDTO> dto = service.findReview(id);
        return ResponseEntity.ok().body(dto);
    }

}
