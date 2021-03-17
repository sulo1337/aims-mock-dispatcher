package com.shadowhawk.aimsmockdispatcher.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertTripRequestVO {
    private Long tripID;
    private Long tripLog;
    private String truckID;
    private String truckName;
    private String travelID;
    private String travelType;
    private List<SourceFuelInfo> source;
    private List<SiteFuelInfo> site;
}
