package com.shadowhawk.aimsmockdispatcher.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shadowhawk.aimsmockdispatcher.vo.misc.Gps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Data
@Entity
@Slf4j
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String street;
    private String city;
    private int zip;
    private String state;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double lat;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double lon;
    @Transient
    private Gps gps;

    @PostPersist
    @PostLoad
    private void onLoad() {
        this.gps = new Gps(this.lat, this.lon);
    }
}
