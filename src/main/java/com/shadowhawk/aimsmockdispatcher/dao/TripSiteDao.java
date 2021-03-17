package com.shadowhawk.aimsmockdispatcher.dao;

import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSite;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSource;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TripSiteDao {
    @Autowired
    EntityManager entityManager;

    public List<TripSite> findAllByTripId(Long tripID) {
        Session session = entityManager.unwrap(Session.class);

        String hql = "from TripSite T where T.id.tripID = :tripID";
        Query<TripSite> query = session.createQuery(hql, TripSite.class);
        query.setParameter("tripID", tripID);
        return query.list();
    }
}
