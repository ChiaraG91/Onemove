package com.team1.progettocarsharingteam1.services;

import com.team1.progettocarsharingteam1.entities.Rent;
import com.team1.progettocarsharingteam1.entities.User;
import com.team1.progettocarsharingteam1.entities.Vehicle;
import com.team1.progettocarsharingteam1.entities.enums.ChargeEnum;
import com.team1.progettocarsharingteam1.entities.enums.TypeVehicleEnum;
import com.team1.progettocarsharingteam1.repositories.RentRepository;
import com.team1.progettocarsharingteam1.repositories.UserRepository;
import com.team1.progettocarsharingteam1.repositories.VehicleRepository;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleService vehicleService;

    public Rent create(Rent rent){
        Rent newRent = rentRepository.save(rent);
        return newRent;
    }


    public List<Rent> findAll() {
        List<Rent> rentList = rentRepository.findAll();
        return rentList;
    }

    public Optional<Rent> findById(Long id) {
        Optional<Rent> rentOPT = rentRepository.findById(id);
        return rentOPT;
    }

    public Optional<Rent> edit(Long id, Rent rent){
        Optional<Rent> updatedRent = rentRepository.findById(id);
        if (updatedRent.isPresent()){
            updatedRent.get().setPrice(rent.getPrice());
            updatedRent.get().setStartTme(rent.getStartTme());
            updatedRent.get().setEndTime(rent.getEndTime());
            rentRepository.save(updatedRent.get());
        } else {
            return Optional.empty();
        }
        return updatedRent;
    }

    public Optional<Rent> delete(Long id){
        Optional<Rent> deletedRentOPT = rentRepository.findById(id);
        if(deletedRentOPT.isPresent()){
            rentRepository.delete(deletedRentOPT.get());
            return deletedRentOPT;
        }else{
            return Optional.empty();
        }
    }

    public Rent startRent(Long userId, Long vehicleId) {
        Rent newRent = new Rent();
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(vehicleId);

        if(userOpt.isPresent() && vehicleOpt.isPresent()) {
            newRent.setStartTme(LocalDateTime.now());
            newRent.setUser(userOpt.get());
            newRent.setPrice(10.0);
            newRent.setVehicle(vehicleOpt.get());

            vehicleOpt.get().setAvailable(false);
            vehicleRepository.save(vehicleOpt.get());

            Rent savedRent = rentRepository.save(newRent);
            return savedRent;
        }
        return null;
    }

    public Optional<Rent> endRent(Long userId, Long vehicleId) {
        Optional<Rent> rentOpt = rentRepository.findById(userId);
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(vehicleId);

        if (rentOpt.isPresent() && vehicleOpt.isPresent()) {
            rentOpt.get().setEndTime(LocalDateTime.now());

            vehicleOpt.get().setAvailable(true);
            vehicleRepository.save(vehicleOpt.get());

            Rent endRent = rentRepository.save(rentOpt.get());
            return Optional.of(endRent);
        } else {
            return Optional.empty();
        }
    }


    public double RentalPriceCalculator(ChargeEnum chargeEnum, Integer rentalTime) {
        double hourlyPrice = switch (chargeEnum) {
            case SHORT -> 6.0;
            case MEDIUM -> 5.5;
            case LONG -> 5.0;
        };

        return hourlyPrice * rentalTime;
    }
}

