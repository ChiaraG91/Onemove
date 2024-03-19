package com.team1.progettocarsharingteam1.controllers;

import com.team1.progettocarsharingteam1.entities.Review;
import com.team1.progettocarsharingteam1.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review reviewNuova = reviewService.addReview(review);
        return ResponseEntity.ok().body(reviewNuova);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long id) {
        Optional<Review> reviewOpt = reviewService.findReviewById(id);

        if(reviewOpt.isPresent()) {
            return ResponseEntity.ok().body(reviewOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Review>> findAllReviews() {
        List<Review> reviews = reviewService.findAllReviews();
        return ResponseEntity.ok().body(reviews);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        Optional<Review> reviewOpt = reviewService.updateReview(id, review);

        if(reviewOpt.isPresent()) {
            return ResponseEntity.ok().body(reviewOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
        Optional<Review> reviewOpt = reviewService.deleteReview(id);

        if(reviewOpt.isPresent()){
            return ResponseEntity.ok().body(reviewOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

}
