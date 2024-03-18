package com.team1.progettocarsharingteam1.repositories;

import com.team1.progettocarsharingteam1.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
}
