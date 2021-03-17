package com.shadowhawk.aimsmockdispatcher.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckerInfoResponse {
    private Long truckerID;
    private String truckerName;
    private List<TripResponseVO> trip;
}
