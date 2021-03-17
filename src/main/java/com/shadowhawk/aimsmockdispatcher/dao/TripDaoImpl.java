package com.shadowhawk.aimsmockdispatcher.dao;

import com.shadowhawk.aimsmockdispatcher.entity.Site;
import com.shadowhawk.aimsmockdispatcher.entity.Source;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSite;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSource;
import com.shadowhawk.aimsmockdispatcher.entity.primarykey.TripSitePK;
import com.shadowhawk.aimsmockdispatcher.entity.primarykey.TripSourcePK;
import com.shadowhawk.aimsmockdispatcher.vo.InsertTripRequestVO;
import com.shadowhawk.aimsmockdispatcher.vo.SiteFuelInfo;
import com.shadowhawk.aimsmockdispatcher.vo.SourceFuelInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class TripDaoImpl implements TripDao{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Trip> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Trip saveOrUpdate(InsertTripRequestVO tripRequestBody) throws Exception{
        Session session = entityManager.unwrap(Session.class);

        try {
            List<SourceFuelInfo> sources = tripRequestBody.getSource();
            List<SiteFuelInfo> sites = tripRequestBody.getSite();

            Trip trip = new Trip(
                    tripRequestBody.getTripID(),
                    tripRequestBody.getTripLog(),
                    tripRequestBody.getTruckID(),
                    tripRequestBody.getTruckName(),
                    tripRequestBody.getTravelID(),
                    tripRequestBody.getTravelType()
            );
            session.saveOrUpdate(trip);

            for(SourceFuelInfo sourceInfo: sources){
                Source thisSource = session.get(Source.class, sourceInfo.getSourceID());
                String type = sourceInfo.getFuel().getType();
                Double volume = sourceInfo.getFuel().getQuantity().getVolume();
                String measure = sourceInfo.getFuel().getQuantity().getMeasure();
                TripSourcePK tripSourcePK = new TripSourcePK(trip.getTripID(), thisSource.getSourceID());
                TripSource tripSource = new TripSource(
                        tripSourcePK,
                        trip,
                        thisSource,
                        type,
                        volume,
                        measure
                );
                session.save(tripSource);
            }

            for(SiteFuelInfo siteInfo: sites) {
                Site thisSite = session.get(Site.class, siteInfo.getSiteID());
                String type = siteInfo.getFuel().getType();
                Double volume = siteInfo.getFuel().getQuantity().getVolume();
                String measure = siteInfo.getFuel().getQuantity().getMeasure();
                TripSitePK tripSitePK = new TripSitePK(trip.getTripID(), thisSite.getSiteID());
                TripSite tripSite = new TripSite(
                        tripSitePK,
                        trip,
                        thisSite,
                        type,
                        volume,
                        measure
                );
                session.save(tripSite);
            }
            return trip;
        } catch (Exception e) {
            throw new Exception("source or site not found" + e.getMessage());
        }
    }
}
