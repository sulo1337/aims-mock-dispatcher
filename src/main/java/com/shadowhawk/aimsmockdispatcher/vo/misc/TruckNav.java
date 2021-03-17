package com.shadowhawk.aimsmockdispatcher.vo.misc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shadowhawk.aimsmockdispatcher.vo.misc.Gps;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TruckNav {
    private Long truckID;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timeStamp;
    private Gps gps;
}
