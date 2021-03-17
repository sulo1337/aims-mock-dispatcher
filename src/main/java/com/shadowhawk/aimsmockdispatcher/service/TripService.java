package com.shadowhawk.aimsmockdispatcher.service;

import com.shadowhawk.aimsmockdispatcher.dao.TripDao;
import com.shadowhawk.aimsmockdispatcher.entity.Site;
import com.shadowhawk.aimsmockdispatcher.entity.Source;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSite;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSource;
import com.shadowhawk.aimsmockdispatcher.repository.SiteRepository;
import com.shadowhawk.aimsmockdispatcher.repository.SourceRepository;
import com.shadowhawk.aimsmockdispatcher.repository.TripRepository;
import com.shadowhawk.aimsmockdispatcher.vo.Fuel;
import com.shadowhawk.aimsmockdispatcher.vo.InsertTripRequestVO;
import com.shadowhawk.aimsmockdispatcher.vo.SiteFuelInfo;
import com.shadowhawk.aimsmockdispatcher.vo.SourceFuelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    TripDao tripDao;

    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    SiteRepository siteRepository;

    public Trip save(InsertTripRequestVO tripRequestBody) throws Exception {
//        List<SourceFuelInfo> sources = tripRequest.getSource();
//        List<SiteFuelInfo> sites = tripRequest.getSite();
//
//        Trip trip = new Trip(
//                tripRequest.getTripID(),
//                tripRequest.getTripLog(),
//                tripRequest.getTruckID(),
//                tripRequest.getTruckName(),
//                tripRequest.getTravelID(),
//                tripRequest.getTravelType()
//        );
//
//        for(SourceFuelInfo sourceInfo: sources){
//            Optional<Source> thisSourceOptional = sourceRepository.findById(sourceInfo.getSourceID());
//            thisSourceOptional.orElseThrow(() -> new Exception("Source with id: "+sourceInfo.getSourceID()+ "not found."));
//            Source thisSource = thisSourceOptional.get();
//            String type = sourceInfo.getFuel().getType();
//            Double volume = sourceInfo.getFuel().getQuantity().getVolume();
//            String measure = sourceInfo.getFuel().getQuantity().getMeasure();
//        }
//
//        for(SiteFuelInfo siteInfo: sites) {
//            Optional<Site> thisSiteOptional = siteRepository.findById(siteInfo.getSiteID());
//            thisSiteOptional.orElseThrow(() -> new Exception("Site with id: "+siteInfo.getSiteID()+"not found."));
//            Site thisSite = thisSiteOptional.get();
//            String type = siteInfo.getFuel().getType();
//            Double volume = siteInfo.getFuel().getQuantity().getVolume();
//            String measure = siteInfo.getFuel().getQuantity().getMeasure();
//        }

        return tripDao.saveOrUpdate(tripRequestBody);
    }

    public List<Trip> findAll() {
        return null;
    }
}
