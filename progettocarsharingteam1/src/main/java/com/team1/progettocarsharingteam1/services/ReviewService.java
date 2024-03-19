package com.team1.progettocarsharingteam1.services;

import com.team1.progettocarsharingteam1.entities.Review;
import com.team1.progettocarsharingteam1.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        Review reviewNuova = reviewRepository.save(review);
        return reviewNuova;
    }

    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(Long id) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);

        if(reviewOpt.isPresent()) {
            return reviewOpt;
        }
        return Optional.empty();
    }

    public Optional<Review> updateReview(Long id, Review review) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);

        if(reviewOpt.isPresent()) {
            reviewOpt.get().setName(review.getName());
            reviewOpt.get().setDescrizione(review.getDescrizione());
            reviewOpt.get().setVoto(review.getVoto());
            reviewOpt.get().setRent(review.getRent());

            Review reviewUpdated = reviewRepository.save(reviewOpt.get());
            return Optional.of(reviewUpdated);
        }
        return Optional.empty();
    }

    public Optional<Review> deleteReview(Long id) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);

        if(reviewOpt.isPresent()) {
            reviewRepository.deleteById(id);
            return reviewOpt;
        }
        return Optional.empty();
    }

}

