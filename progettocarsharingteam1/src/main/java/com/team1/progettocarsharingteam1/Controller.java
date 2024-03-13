package com.team1.progettocarsharingteam1;

import com.team1.progettocarsharingteam1.entities.Car;
import com.team1.progettocarsharingteam1.entities.Motorcycle;
import com.team1.progettocarsharingteam1.entities.Scooter;
import com.team1.progettocarsharingteam1.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
    @Autowired
    private Repo repo;

    @PostMapping("/addcar")
    public Vehicle add(@RequestBody Car car) {
        return repo.save(car);
    }

    @PostMapping("/addmoto")
    public Vehicle add(@RequestBody Motorcycle motorcycle) {
        return repo.save(motorcycle);
    }

    @PostMapping("/addsco")
    public Vehicle add(@RequestBody Scooter scooter) {
        return repo.save(scooter);
    }
}
