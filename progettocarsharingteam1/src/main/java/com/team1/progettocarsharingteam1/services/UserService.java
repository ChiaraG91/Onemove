package com.team1.progettocarsharingteam1.services;

import com.team1.progettocarsharingteam1.entities.User;
import com.team1.progettocarsharingteam1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> edit(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            optionalUser.get().setName(user.getName());
            optionalUser.get().setAddress(user.getAddress());
            optionalUser.get().setEmail(user.getEmail());
            optionalUser.get().setSex(user.getSex());
            optionalUser.get().setSurname(user.getSurname());
            optionalUser.get().setLicenseNumber(user.getLicenseNumber());
            optionalUser.get().setTaxId(user.getTaxId());
            optionalUser.get().setDateOfBirth(user.getDateOfBirth());
            optionalUser.get().setVerified(user.isVerified());
            userRepository.save(optionalUser.get());
        } else {
            return Optional.empty();
        }
        return optionalUser;
    }

    public Optional<User> delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return optionalUser;
        } else {
            return Optional.empty();
        }
    }

}
