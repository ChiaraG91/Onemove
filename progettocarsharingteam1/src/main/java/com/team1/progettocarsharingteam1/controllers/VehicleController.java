package com.team1.progettocarsharingteam1.controllers;

import com.team1.progettocarsharingteam1.entities.Vehicle;
import com.team1.progettocarsharingteam1.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/create")
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.create(vehicle));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> findAll() {
        List<Vehicle> vehicleOpt = vehicleService.findAll();
        if (vehicleOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(vehicleService.findAll());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
        Optional<Vehicle> vehicleOpt = vehicleService.findById(id);
        if (vehicleOpt.isPresent()) {
            return ResponseEntity.ok(vehicleOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Vehicle> modify(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleOpt = vehicleService.modify(id, vehicle);
        if (vehicleOpt.isPresent()) {
            return ResponseEntity.ok(vehicleOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Vehicle> delete(@PathVariable Long id) {
        Optional<Vehicle> vehicleOpt = vehicleService.delete(id);
        if (vehicleOpt.isPresent()) {
            return ResponseEntity.ok(vehicleOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}