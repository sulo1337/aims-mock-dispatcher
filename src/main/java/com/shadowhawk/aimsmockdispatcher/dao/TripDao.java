package com.shadowhawk.aimsmockdispatcher.dao;


import com.shadowhawk.aimsmockdispatcher.vo.InsertTripRequestVO;
import com.shadowhawk.aimsmockdispatcher.vo.TripResponseVO;

import java.util.List;

public interface TripDao {
    List<TripResponseVO> findTripById(Long tripID) throws Exception;
    TripResponseVO saveOrUpdate(InsertTripRequestVO trip) throws Exception;
}
