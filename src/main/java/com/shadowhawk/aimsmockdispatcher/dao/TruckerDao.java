package com.shadowhawk.aimsmockdispatcher.dao;

import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.entity.Trucker;
import com.shadowhawk.aimsmockdispatcher.service.TripService;
import com.shadowhawk.aimsmockdispatcher.vo.TripResponseVO;
import com.shadowhawk.aimsmockdispatcher.vo.TruckerInfoResponse;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TruckerDao {

    @Autowired
    EntityManager entityManager;

    @Autowired
    TripService tripService;

    @Transactional
    public TruckerInfoResponse findOne(Long truckerID) throws Exception {
        Session session = entityManager.unwrap(Session.class);

        Trucker thisTrucker = session.get(Trucker.class, truckerID);
        if(thisTrucker == null) {
            throw new Exception("Trucker not found");
        }
        TruckerInfoResponse truckerInfoResponse = new TruckerInfoResponse(
                thisTrucker.getTruckerID(),
                thisTrucker.getTruckerName(),
                null
        );

        List<TripResponseVO> tripsResponseBody = new ArrayList<>();
        for(Trip trip: thisTrucker.getTrip()){
            TripResponseVO tripResponseVO = tripService.findTripById(trip.getTripID());
            tripsResponseBody.add(tripResponseVO);
        }

        truckerInfoResponse.setTrip(tripsResponseBody);
        return truckerInfoResponse;
    }
}
