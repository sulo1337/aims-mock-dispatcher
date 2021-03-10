package com.shadowhawk.aimsmockdispatcher.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sourceID;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private Location location;
    @JoinColumn(name="fuel")
    @OneToOne(cascade = CascadeType.ALL)
    private Fuel fuel;

    @Override
    public int hashCode() {
        return sourceID.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Source) {
            Source source = (Source) obj;
            return this.sourceID.equals(source.sourceID);
        } else {
            return false;
        }
    }
}
