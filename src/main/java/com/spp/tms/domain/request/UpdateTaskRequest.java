package com.spp.tms.domain.request;

import lombok.Getter;

@Getter
public class UpdateTaskRequest {
    private String id;
    private boolean finished;
    private SubtaskRequest subtask;
}
