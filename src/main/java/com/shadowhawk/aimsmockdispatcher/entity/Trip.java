package com.shadowhawk.aimsmockdispatcher.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Trip {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripID;
    private Long tripLog;
    private String truckID;
    private String truckName;
    private String travelID;
    private String travelType;
    @ManyToMany(cascade = {CascadeType.REFRESH})
    private List<Source> source;
    @ManyToMany(cascade = {
            CascadeType.REFRESH
    })
    private List<Site> site;
}
