package com.spp.tms.mapper;

import com.spp.tms.domain.Task;
import com.spp.tms.domain.request.SaveTaskRequest;

public class RequestMapper {
    public static Task map(SaveTaskRequest taskRequest) {
        return new Task(taskRequest.getName(), taskRequest.getGroup(), taskRequest.getSubtasks());
    }
}
