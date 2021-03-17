package com.shadowhawk.aimsmockdispatcher.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceFuelInfo {
    private Long sourceID;
    private Fuel fuel;
}
