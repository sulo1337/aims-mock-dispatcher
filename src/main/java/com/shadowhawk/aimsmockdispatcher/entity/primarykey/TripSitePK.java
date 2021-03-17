package com.shadowhawk.aimsmockdispatcher.entity.primarykey;

import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TripSitePK implements Serializable {

    @Column(name="tripID")
    private Long tripID;

    @Column(name="siteID")
    private Long siteID;

    public TripSitePK(Long tripID, Long siteID) {
        super();
        this.tripID = tripID;
        this.siteID = siteID;
    }

    public TripSitePK() {
        super();
    }

    public Long getTripID() {
        return tripID;
    }

    public void setTripID(Long tripID) {
        this.tripID = tripID;
    }

    public Long getSiteID() {
        return siteID;
    }

    public void setSiteID(Long siteID) {
        this.siteID = siteID;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(o == null || getClass() != o.getClass()) return  false;
        TripSitePK other = (TripSitePK) o;
        return Objects.equals(tripID, other.tripID) && Objects.equals(siteID, other.siteID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripID, siteID);
    }
}
