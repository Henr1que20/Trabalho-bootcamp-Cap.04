package com.devsuperior.movieflix.DTO;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;

public class ReviewFormDTO {

    private Long id;
    private Long movieId;

    @NotBlank(message = "Não é permitido texto vazio na avaliação")
    private String text;

    public ReviewFormDTO() {
    }

    public ReviewFormDTO(Long id, Long movieId, String text) {
        this.id = id;
        this.movieId = movieId;
        this.text = text;
    }

    public ReviewFormDTO(Review review) {
        this.id = review.getId();
        this.movieId = review.getMovie().getId();
        this.text = review.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
