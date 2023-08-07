package com.demobackend.demobackendtravelplan.ReqResClasses;

import lombok.Data;

import java.util.List;

@Data
public class RequestInfo {
    private int planId;
    private String planTitle;
    private String description;
    private List<Integer> userIds;
}
