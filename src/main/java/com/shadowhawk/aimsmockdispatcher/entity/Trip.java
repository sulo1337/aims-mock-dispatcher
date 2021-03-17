package com.shadowhawk.aimsmockdispatcher.entity;

import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSite;
import com.shadowhawk.aimsmockdispatcher.entity.manytomany.TripSource;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Trip {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripID;
    private Long tripLog;
    private String truckID;
    private String truckName;
    private String travelID;
    private String travelType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return this.tripID.equals(trip.tripID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripID);
    }
}
