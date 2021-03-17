package com.shadowhawk.aimsmockdispatcher.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripResponseVO {
    private Long tripID;
    private Long tripLog;
    private String truckID;
    private String truckName;
    private String travelID;
    private String travelType;
    private List<SourceFuelInfoResponse> source;
    private List<SiteFuelInfoResponse> site;

    public void addSource(SourceFuelInfoResponse sourceFuelInfoResponse){
        this.source.add(sourceFuelInfoResponse);
    }

    public void addSite(SiteFuelInfoResponse siteFuelInfoResponse){
        this.site.add(siteFuelInfoResponse);
    }
}
