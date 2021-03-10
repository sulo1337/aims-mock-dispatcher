package com.shadowhawk.aimsmockdispatcher.controller;

import com.shadowhawk.aimsmockdispatcher.entity.Source;
import com.shadowhawk.aimsmockdispatcher.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourceController {

    @Autowired
    SourceRepository sourceRepository;

    @RequestMapping(value = "/api/source", method = RequestMethod.POST)
    public ResponseEntity<?> saveSource(@RequestBody Source source){
        try{
            return ResponseEntity.ok(sourceRepository.save(source));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
