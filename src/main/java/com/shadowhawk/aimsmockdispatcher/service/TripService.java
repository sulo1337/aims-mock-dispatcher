package com.shadowhawk.aimsmockdispatcher.service;

import com.shadowhawk.aimsmockdispatcher.dao.TripDao;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.repository.SiteRepository;
import com.shadowhawk.aimsmockdispatcher.repository.SourceRepository;
import com.shadowhawk.aimsmockdispatcher.vo.InsertTripRequestVO;
import com.shadowhawk.aimsmockdispatcher.vo.TripResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    TripDao tripDao;

    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    SiteRepository siteRepository;

    public TripResponseVO save(InsertTripRequestVO tripRequestBody) throws Exception {
        return tripDao.saveOrUpdate(tripRequestBody);
    }

    public List<TripResponseVO> findAll() throws Exception{
        return tripDao.findTripById(0L);
    }

    public TripResponseVO findTripById(Long tripID) throws Exception{
        TripResponseVO trip = tripDao.findTripById(tripID).get(0);
        if(trip == null) {
            throw new Exception("Trip with given id "+tripID+" not found.");
        } else{
            return trip;
        }
    }
}
