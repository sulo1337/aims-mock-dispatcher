package com.shadowhawk.aimsmockdispatcher.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long siteID;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="location")
    private Location location;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fuel")
    private Fuel fuel;
}
