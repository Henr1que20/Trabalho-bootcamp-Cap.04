package com.devsuperior.movieflix.services;


import com.devsuperior.movieflix.DTO.MovieDTO;
import com.devsuperior.movieflix.DTO.MovieReviewDTO;
import com.devsuperior.movieflix.DTO.ReviewDTO;
import com.devsuperior.movieflix.DTO.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.projection.ReviewProjetion;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private UserService userService;

    public Page<MovieDTO> findMovie(Pageable pageable, Long genreId) {
        if(genreId == 0){
            Page<Movie> page = repository.find(pageable);
            return page.map(x -> new MovieDTO(x));
        }

        Page<Movie> page = repository.find(pageable, genreId);
        return page.map(x -> new MovieDTO(x));
    }

    public MovieReviewDTO findById(Long id) {
        Optional<Movie> obj = repository.findById(id);
        Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        return new MovieReviewDTO(movie);
    }

    public List<ReviewDTO> findReview(Long id) {
        Optional<Movie> movie = repository.findById(id);
        Movie movieEntity = movie.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        List<ReviewProjetion> listProjectionResults = repository.findReview(movieEntity.getId());

        List<ReviewDTO> reviews = listProjectionResults.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());

        return reviews;

    }
}
