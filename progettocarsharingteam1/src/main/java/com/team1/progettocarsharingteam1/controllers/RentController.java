package com.team1.progettocarsharingteam1.controllers;

import com.team1.progettocarsharingteam1.entities.Rent;
import com.team1.progettocarsharingteam1.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping("/add-rent")
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
        Rent rent1 = rentService.createRent(rent);
        return ResponseEntity.ok().body(rent1);
    }

    @GetMapping("/get-list")
    public ResponseEntity<List<Rent>> getAllRentals() {
        List<Rent> allRentals = rentService.viewAllRentals();
        return ResponseEntity.ok().body(allRentals);
    }

    @GetMapping("/get-rent/{id}")
    public ResponseEntity<Optional<Rent>> getRent(@PathVariable Long id) {
        Optional<Rent> rentOPT = rentService.viewRent(id);
        return ResponseEntity.ok().body(rentOPT);
    }

    @PutMapping("/update-rent/{id}")
    public ResponseEntity<Rent> updateRentById(@RequestBody Rent rent, @PathVariable Long id) {
        Optional<Rent> updatedRentOPT = rentService.updateRent(id, rent);
        if (updatedRentOPT.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rent);
    }

    @DeleteMapping("/delete-rent")
    public ResponseEntity<Optional<Rent>> deleteRentById(@RequestParam Long id) {
        Optional<Rent> deletedRentOPT = rentService.deleteRentById(id);
        if (deletedRentOPT.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(deletedRentOPT);

    }

}
