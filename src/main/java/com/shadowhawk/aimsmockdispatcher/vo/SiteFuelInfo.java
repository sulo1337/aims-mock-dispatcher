package com.shadowhawk.aimsmockdispatcher.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteFuelInfo {
    private Long siteID;
    private Fuel fuel;
}
