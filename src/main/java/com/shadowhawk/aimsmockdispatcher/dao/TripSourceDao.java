package com.shadowhawk.aimsmockdispatcher.dao;

import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSource;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TripSourceDao {

    @Autowired
    EntityManager entityManager;

    public List<TripSource> findAllByTripId(Long tripID) {
        Session session = entityManager.unwrap(Session.class);

        String hql = "from TripSource T where T.id.tripID = :tripID";
        Query<TripSource> query = session.createQuery(hql, TripSource.class);
        query.setParameter("tripID", tripID);
        return query.list();
    }
}
