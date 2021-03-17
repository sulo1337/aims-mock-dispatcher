package com.shadowhawk.aimsmockdispatcher.controller;

import com.shadowhawk.aimsmockdispatcher.dao.TripDao;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.service.TripService;
import com.shadowhawk.aimsmockdispatcher.service.TruckerService;
import com.shadowhawk.aimsmockdispatcher.vo.InsertTripRequestVO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripController {

    @Autowired
    TripService tripService;

    @Autowired
    TruckerService truckerService;

    @RequestMapping(value = "/api/trip", method = RequestMethod.POST)
    public ResponseEntity<?> saveTrip(@RequestBody InsertTripRequestVO trip){
        try{
            return ResponseEntity.ok(tripService.save(trip));
        }catch (Exception e) {
            if(e instanceof NotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }
    }

    @RequestMapping(value = "/api/trip", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTrip() {
        try {
            return ResponseEntity.ok(tripService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/api/trips", method = RequestMethod.GET)
    public ResponseEntity<?> getTripsByTruckerId(@RequestParam("truckerID") Long truckerID){
        try{
            return ResponseEntity.ok(truckerService.findTrucker(truckerID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
