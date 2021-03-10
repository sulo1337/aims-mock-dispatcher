package com.shadowhawk.aimsmockdispatcher.controller;

import com.shadowhawk.aimsmockdispatcher.vo.Contract;
import com.shadowhawk.aimsmockdispatcher.vo.TruckNav;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    @RequestMapping(value = "/api/location", method =  RequestMethod.POST)
    public ResponseEntity<?> updateLocation(@RequestBody TruckNav navigation) {
        try {
            return ResponseEntity.ok(navigation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/api/contract", method = RequestMethod.POST)
    public ResponseEntity<?> updateContract(@RequestBody Contract contract) {
        try {
            return ResponseEntity.ok(contract);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
