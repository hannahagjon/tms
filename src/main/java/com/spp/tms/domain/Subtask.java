package com.spp.tms.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Subtask{
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String group;
    private boolean finished;
    private String id;

    public boolean isFinished(){
        return finished;
    }


}
