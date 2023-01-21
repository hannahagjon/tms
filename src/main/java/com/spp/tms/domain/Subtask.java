package com.spp.tms.domain;

public class Subtask extends Task {

//    USED FOR MOCK
//    @Builder(builderMethodName = "subTaskBuilder")
//    public Subtask(String name, LocalDateTime startTime, LocalDateTime endTime, String group, boolean finished, String id) {
//        super(name, startTime, endTime, group, finished, id);
//    }


    public Subtask(String name, String group) {
        super(name, group);
    }
}
