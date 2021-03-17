package com.shadowhawk.aimsmockdispatcher.dao;


import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.vo.InsertTripRequestVO;

import java.util.List;

public interface TripDao {
    List<Trip> findAll();
    Trip saveOrUpdate(InsertTripRequestVO trip) throws Exception;
}
