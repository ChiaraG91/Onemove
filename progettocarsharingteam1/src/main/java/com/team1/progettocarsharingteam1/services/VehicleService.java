package com.team1.progettocarsharingteam1.services;

import com.team1.progettocarsharingteam1.entities.Vehicle;
import com.team1.progettocarsharingteam1.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Optional<Vehicle> modify(Long id, Vehicle vehicle) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            vehicleOpt.get().setBrand(vehicle.getBrand());
            vehicleOpt.get().setModel(vehicle.getModel());
            vehicleOpt.get().setDetails(vehicle.getDetails());
            vehicleOpt.get().setAvailable(vehicle.isAvailable());
            vehicleOpt.get().setTypeVehicle(vehicle.getTypeVehicle());
            vehicleRepository.save(vehicleOpt.get());
        } else {
            Optional.empty();
        }
        return vehicleOpt;
    }

    public Optional<Vehicle> delete(Long id) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            vehicleRepository.delete(vehicleOpt.get());
            return vehicleOpt;
        } else {
            return Optional.empty();
        }
    }
}
