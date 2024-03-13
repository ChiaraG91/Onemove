package com.team1.progettocarsharingteam1;

import com.team1.progettocarsharingteam1.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Vehicle, Float> {
}
