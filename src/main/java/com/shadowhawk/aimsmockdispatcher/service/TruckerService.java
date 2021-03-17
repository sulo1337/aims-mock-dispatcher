package com.shadowhawk.aimsmockdispatcher.service;

import com.shadowhawk.aimsmockdispatcher.dao.TruckerDao;
import com.shadowhawk.aimsmockdispatcher.entity.Trucker;
import com.shadowhawk.aimsmockdispatcher.repository.TruckerRepository;
import com.shadowhawk.aimsmockdispatcher.vo.TruckerInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckerService {

    @Autowired
    TruckerDao truckerDao;

    @Autowired
    TruckerRepository truckerRepository;


    public TruckerInfoResponse save(Trucker trucker) throws Exception{
        Long truckerId = truckerRepository.save(trucker).getTruckerID();
        return findTrucker(truckerId);
    }

    public TruckerInfoResponse findTrucker(Long truckerID) throws Exception{
        return truckerDao.findOne(truckerID);
    }
}
