package com.shadowhawk.aimsmockdispatcher.entity.manytomany;

import com.shadowhawk.aimsmockdispatcher.entity.Site;
import com.shadowhawk.aimsmockdispatcher.entity.Source;
import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import com.shadowhawk.aimsmockdispatcher.entity.primarykey.TripSourcePK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripSource {

    @EmbeddedId
    private TripSourcePK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tripID")
    @JoinColumn(name = "tripID")
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sourceID")
    @JoinColumn(name = "sourceID")
    private Source source;

    private String type;
    private Double volume;
    private String measure;

    public TripSource(Trip trip, Source source, String type, Double volume, String measure) {
        this.trip = trip;
        this.source = source;
        this.type = type;
        this.volume = volume;
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(o == null || getClass() != o.getClass()) return  false;
        TripSource other = (TripSource) o;
        return Objects.equals(trip, other.trip) && Objects.equals(source, other.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trip, source);
    }
}
