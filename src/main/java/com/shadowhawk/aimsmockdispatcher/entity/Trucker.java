package com.shadowhawk.aimsmockdispatcher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trucker {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long truckerID;
    private String truckerName;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Trip> trip;
}
