package com.shadowhawk.aimsmockdispatcher.controller;

import com.shadowhawk.aimsmockdispatcher.entity.Trucker;
import com.shadowhawk.aimsmockdispatcher.repository.TruckerRepository;
import com.shadowhawk.aimsmockdispatcher.service.TruckerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TruckerController {

    @Autowired
    TruckerService truckerService;

    @RequestMapping(method = RequestMethod.POST, value = "/api/trucker")
    public ResponseEntity<?> insertTrucker(@RequestBody Trucker trucker) {
        try{
            return ResponseEntity.ok(truckerService.save(trucker));
        } catch (Exception e) {
            if(e instanceof JpaObjectRetrievalFailureException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("One or more trips could not be found.");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("One or more of the trip is already assigned to another trucker.");
            }
        }
    }
}
