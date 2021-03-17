package com.shadowhawk.aimsmockdispatcher.entity.manytomany;

import com.shadowhawk.aimsmockdispatcher.entity.Site;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.entity.primarykey.TripSitePK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TripSite implements Serializable {

    @EmbeddedId
    private TripSitePK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tripID")
    @JoinColumn(name = "tripID")
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("siteID")
    @JoinColumn(name = "siteID")
    private Site site;

    private String type;
    private Double volume;
    private String measure;

    public TripSite(Trip trip, Site site, String type, Double volume, String measure) {
        this.trip = trip;
        this.site = site;
        this.type = type;
        this.volume = volume;
        this.measure = measure;
    }

    public TripSite() {
        super();
    }

    public TripSite(TripSitePK id, Trip trip, Site site, String type, Double volume, String measure) {
        super();
        this.id = id;
        this.trip = trip;
        this.site = site;
        this.type = type;
        this.volume = volume;
        this.measure = measure;
    }

    public TripSitePK getId() {
        return id;
    }

    public void setId(TripSitePK id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(o == null || getClass() != o.getClass()) return  false;
        TripSite other = (TripSite) o;
        return Objects.equals(trip, other.trip) && Objects.equals(site, other.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trip, site);
    }
}
