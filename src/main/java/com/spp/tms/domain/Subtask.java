package com.spp.tms.domain;

import lombok.Builder;

import java.time.LocalDateTime;

public class Subtask extends Task {

    @Builder(builderMethodName = "subTaskBuilder")
    public Subtask(String name, LocalDateTime startTime, LocalDateTime endTime, String group, boolean finished, String id) {
        super(name, startTime, endTime, group, finished, id);
    }

    public boolean isFinished(){
        return finished;
    }


}
