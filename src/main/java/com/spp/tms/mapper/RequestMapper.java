package com.spp.tms.mapper;

import com.spp.tms.domain.MainTask;
import com.spp.tms.domain.request.SaveTaskRequest;

public class RequestMapper {
    public static MainTask map(SaveTaskRequest taskRequest) {
        return new MainTask(taskRequest.getName(), taskRequest.getGroup(), taskRequest.getSubtasks());
    }
}
