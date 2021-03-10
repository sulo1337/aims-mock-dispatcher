package com.shadowhawk.aimsmockdispatcher.dao;

import com.shadowhawk.aimsmockdispatcher.entity.Source;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.repository.SourceRepository;
import com.shadowhawk.aimsmockdispatcher.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TripDao {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    SourceRepository sourceRepository;

    public List<Trip> findAll() throws Exception {
//        List<Trip> allTrips = tripRepository.findAll();
//        List<TripResponseVO> allTripsResponse = new LinkedList<>();
//        allTrips.stream().map(trip -> {
//            trip.getSite()
//        });
        return tripRepository.findAll();
    }

    public Trip save(Trip trip) throws Exception{
//        List<Source> sources = trip.getSource();
//        List<Source> sourcesX = sources.stream().map(source -> {
//            Optional<Source> source1 = sourceRepository.findById(source.getSourceID());
//            if(source1.isPresent()){
//                log.info(source1.get().toString());
//                return source1.get();
//            } else {
//                log.info(source.toString());
//                source.setSourceID(0L);
//                return source;
//            }
//        }).collect(Collectors.toList());
//        trip.setSource(sourcesX);
        return tripRepository.save(trip);
    }
}
