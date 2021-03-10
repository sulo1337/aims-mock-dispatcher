package com.shadowhawk.aimsmockdispatcher.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shadowhawk.aimsmockdispatcher.vo.Quantity;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String type;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double volume;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String measure;
    @Transient
    private Quantity quantity;

    @PostPersist
    @PostLoad
    private void onLoad() {
        this.quantity = new Quantity(this.volume, this.measure);
    }

}
