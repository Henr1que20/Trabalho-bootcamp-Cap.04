package com.devsuperior.movieflix.DTO;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.projection.ReviewProjetion;

public class ReviewDTO {

    private Long id;
    private String text;
    private String name;
    public ReviewDTO() {
    }
    public ReviewDTO(Long id, String text, String name) {
        this.id = id;
        this.text = text;
        this.name = name;
    }

    public ReviewDTO(ReviewProjetion review) {
        this.id = review.getId();
        this.text = review.getText();
        this.name = review.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
