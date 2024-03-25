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

    @PostMapping("/create")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        Review reviewNuova = reviewService.create(review);
        return ResponseEntity.ok().body(reviewNuova);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> findAll() {
        List<Review> reviews = reviewService.findAll();
        return ResponseEntity.ok().body(reviews);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id) {
        Optional<Review> reviewOpt = reviewService.findById(id);
        if (reviewOpt.isPresent()) {
            return ResponseEntity.ok().body(reviewOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Review> edit(@PathVariable Long id, @RequestBody Review review) {
        Optional<Review> reviewOpt = reviewService.edit(id, review);
        if (reviewOpt.isPresent()) {
            return ResponseEntity.ok().body(reviewOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Review> delete(@PathVariable Long id) {
        Optional<Review> reviewOpt = reviewService.delete(id);
        if (reviewOpt.isPresent()) {
            return ResponseEntity.ok().body(reviewOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
