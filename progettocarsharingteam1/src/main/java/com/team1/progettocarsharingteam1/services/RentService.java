package com.team1.progettocarsharingteam1.services;

import com.team1.progettocarsharingteam1.entities.Rent;
import com.team1.progettocarsharingteam1.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public Rent createRent(Rent rent){
        Rent newRent = rentRepository.save(rent);
        return newRent;
    }


    public List<Rent> viewAllRentals() {
        List<Rent> rentList = rentRepository.findAll();
        return rentList;
    }

    public Optional<Rent> viewRent(Long id) {
        Optional<Rent> rentOPT = rentRepository.findById(id);
        return rentOPT;
    }

    public Optional<Rent> updateRent(Long id,Rent rent){
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

    public Optional<Rent> deleteRentById(Long id){
        Optional<Rent> deletedRentOPT = rentRepository.findById(id);
        if(deletedRentOPT.isPresent()){
            rentRepository.delete(deletedRentOPT.get());
            return deletedRentOPT;
        }else{
            return Optional.empty();
        }
    }

}

