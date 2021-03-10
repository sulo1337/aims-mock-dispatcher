package com.shadowhawk.aimsmockdispatcher.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripID;
    private Long tripLog;
    private Long truckerID;
    private String truckerName;
    private String truckID;
    private String truckName;
    private String travelID;
    private String travelType;
    @OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    private List<Source> source;
    @OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    private List<Site> site;
}
