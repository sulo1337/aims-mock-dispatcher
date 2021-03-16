package com.shadowhawk.aimsmockdispatcher.controller;

import com.shadowhawk.aimsmockdispatcher.entity.Site;
import com.shadowhawk.aimsmockdispatcher.repository.SiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SiteController {

    @Autowired
    private SiteRepository siteRepository;
    @RequestMapping(value = "/api/site", method = RequestMethod.POST)
    public ResponseEntity<?> saveSite(@RequestBody Site site) {
        try{
            log.info(site.toString());
            return ResponseEntity.ok(siteRepository.save(site));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/api/site/{id}")
    public ResponseEntity<?> deleteSite(@PathVariable("id") Long id){
        try{
            siteRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/api/site/insertAll")
    public ResponseEntity<?> insertAll(@RequestBody List<Site> siteList){
        List<Site> savedSiteList = new ArrayList<>();
        try {
            siteList.forEach((site) -> {
                Site savedSite = siteRepository.save(site);
                savedSiteList.add(savedSite);
            });
            return ResponseEntity.ok(savedSiteList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
