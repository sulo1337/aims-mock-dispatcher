package com.shadowhawk.aimsmockdispatcher.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Site {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long siteID;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private Location location;

    @Override
    public int hashCode() {
        return siteID.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Site) {
            Site site = (Site) obj;
            return this.siteID.equals(site.siteID);
        } else {
            return false;
        }
    }
}
