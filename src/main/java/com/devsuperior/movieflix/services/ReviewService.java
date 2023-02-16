package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTO.ReviewFormDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public ReviewFormDTO insert(ReviewFormDTO dto) {
        try {
            Movie movie = getMovie(dto);
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepository.findByEmail(username);
            Review review = saveReview(dto, movie, user);
            return new ReviewFormDTO(review);

        }catch (Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }

    private Movie getMovie(ReviewFormDTO dto) {
        Optional<Movie> obj = movieRepository.findById(dto.getMovieId());
        Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        return movie;
    }

    private Review saveReview(ReviewFormDTO dto, Movie movie, User user) {
        Review review = new Review();
        review.setText(dto.getText());
        review.setMovie(movie);
        review.setUser(user);
        review = reviewRepository.save(review);
        return review;
    }
}
