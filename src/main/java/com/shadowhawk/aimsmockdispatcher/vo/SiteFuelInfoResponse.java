package com.shadowhawk.aimsmockdispatcher.vo;

import com.shadowhawk.aimsmockdispatcher.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteFuelInfoResponse {
    private Long siteID;
    private String name;
    private Location location;
    private Fuel fuel;
}
