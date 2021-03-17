package com.shadowhawk.aimsmockdispatcher.dao;

import com.shadowhawk.aimsmockdispatcher.entity.Site;
import com.shadowhawk.aimsmockdispatcher.entity.Source;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSite;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSource;
import com.shadowhawk.aimsmockdispatcher.entity.primarykey.TripSitePK;
import com.shadowhawk.aimsmockdispatcher.entity.primarykey.TripSourcePK;
import com.shadowhawk.aimsmockdispatcher.vo.*;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripDaoImpl implements TripDao{

    @Autowired
    EntityManager entityManager;

    @Autowired
    TripSourceDao tripSourceDao;

    @Autowired
    TripSiteDao tripSiteDao;

    @Override
    @Transactional
    public List<TripResponseVO> findTripById(Long tripID) throws Exception {
        Session session = entityManager.unwrap(Session.class);

        //create new response template
        List<TripResponseVO> trips = new ArrayList<>();
        List<Trip> allTrips;

        if(tripID == 0L) {
            Query<Trip> query = session.createQuery("from Trip", Trip.class);
            allTrips = query.getResultList();
        } else {
            Query<Trip> query = session.createQuery("from Trip where tripID = :tripID", Trip.class);
            query.setParameter("tripID", tripID);
            allTrips = query.getResultList();
        }

        for(Trip trip: allTrips) {
            TripResponseVO tripResponseBody = new TripResponseVO(
                    trip.getTripID(),
                    trip.getTripLog(),
                    trip.getTruckID(),
                    trip.getTruckName(),
                    trip.getTravelID(),
                    trip.getTravelType(),
                    new ArrayList<>(),
                    new ArrayList<>()
            );

            List<TripSource> sources = tripSourceDao.findAllByTripId(trip.getTripID());
            List<TripSite> sites = tripSiteDao.findAllByTripId(trip.getTripID());

            for(TripSource source: sources){
                SourceFuelInfoResponse sourceFuelInfo = new SourceFuelInfoResponse(
                        source.getSource().getSourceID(),
                        source.getSource().getName(),
                        source.getSource().getLocation(),
                        new Fuel(
                                source.getType(),
                                new Quantity(
                                        source.getVolume(),
                                        source.getMeasure()
                                )
                        )
                );
                tripResponseBody.addSource(sourceFuelInfo);
            }

            for(TripSite site: sites) {
                SiteFuelInfoResponse siteFuelInfo = new SiteFuelInfoResponse(
                        site.getSite().getSiteID(),
                        site.getSite().getName(),
                        site.getSite().getLocation(),
                        new Fuel(
                                site.getType(),
                                new Quantity(
                                        site.getVolume(),
                                        site.getMeasure()
                                )
                        )
                );
                tripResponseBody.addSite(siteFuelInfo);
            }
            trips.add(tripResponseBody);
        }
        return trips;
    }

    @Override
    @Transactional
    public TripResponseVO saveOrUpdate(InsertTripRequestVO tripRequestBody) throws Exception{
        Session session = entityManager.unwrap(Session.class);

        List<SourceFuelInfoRequest> sources = tripRequestBody.getSource();
        List<SiteFuelInfoRequest> sites = tripRequestBody.getSite();

        Trip trip = new Trip(
                tripRequestBody.getTripID(),
                tripRequestBody.getTripLog(),
                tripRequestBody.getTruckID(),
                tripRequestBody.getTruckName(),
                tripRequestBody.getTravelID(),
                tripRequestBody.getTravelType()
        );
        session.saveOrUpdate(trip);

        for(SourceFuelInfoRequest sourceInfo: sources){
            Source thisSource = session.get(Source.class, sourceInfo.getSourceID());
            if(thisSource == null) {
                session.delete(trip);
                throw new NotFoundException("Source with id "+sourceInfo.getSourceID()+" not found.");
            }
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
            session.saveOrUpdate(tripSource);
        }

        for(SiteFuelInfoRequest siteInfo: sites) {
            Site thisSite = session.get(Site.class, siteInfo.getSiteID());
            if(thisSite == null) {
                session.delete(trip);
                throw new NotFoundException("Site with id "+siteInfo.getSiteID()+" not found.");
            }
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
            session.saveOrUpdate(tripSite);
        }
        return findTripById(trip.getTripID()).get(0);
    }
}
