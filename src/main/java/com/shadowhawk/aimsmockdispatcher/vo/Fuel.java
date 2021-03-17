package com.shadowhawk.aimsmockdispatcher.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fuel {

    private String type;
    private Quantity quantity;
}
