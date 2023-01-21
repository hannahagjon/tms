package com.spp.tms.domain.request;

import com.spp.tms.domain.Subtask;
import lombok.Getter;

@Getter
public class UpdateTaskRequest {
    private String id;
    private boolean finished;
    private Subtask subtask;
}
