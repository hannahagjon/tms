package com.spp.tms.domain.request;

import lombok.Getter;

import java.util.List;
@Getter
public class SaveTaskRequest {
    private String group;
    private String name;
    private List<SubtaskRequest> subtasks;
}
