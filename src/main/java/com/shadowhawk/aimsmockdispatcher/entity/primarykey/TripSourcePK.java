package com.shadowhawk.aimsmockdispatcher.entity.primarykey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TripSourcePK implements Serializable {

    public TripSourcePK() {
        super();
    }

    public TripSourcePK(Long tripID, Long sourceID) {
        super();
        this.tripID = tripID;
        this.sourceID = sourceID;
    }

    public Long getTripID() {
        return tripID;
    }

    public void setTripID(Long tripID) {
        this.tripID = tripID;
    }

    public Long getSourceID() {
        return sourceID;
    }

    public void setSourceID(Long sourceID) {
        this.sourceID = sourceID;
    }

    @Column(name="tripID")
    private Long tripID;

    @Column(name="sourceID")
    private Long sourceID;

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(o == null || getClass() != o.getClass()) return  false;
        TripSourcePK other = (TripSourcePK) o;
        return Objects.equals(tripID, other.tripID) && Objects.equals(sourceID, other.sourceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripID, sourceID);
    }

}
