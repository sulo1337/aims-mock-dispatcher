package com.shadowhawk.aimsmockdispatcher.controller;

import com.shadowhawk.aimsmockdispatcher.dao.TripDao;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripController {

    @Autowired
    TripDao tripDao;

    @RequestMapping(value = "/api/trip", method = RequestMethod.POST)
    public ResponseEntity<?> saveTrip(@RequestBody Trip trip){
        try{
            return ResponseEntity.ok(tripDao.save(trip));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/api/trip", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTrip() {
        try {
            return ResponseEntity.ok(tripDao.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
