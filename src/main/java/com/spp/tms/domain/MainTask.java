package com.spp.tms.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MainTask extends Task {
    private List<Subtask> subtasks = new ArrayList<>();

    @Builder(builderMethodName = "mainTaskBuilder")
    public MainTask(String name, String group, List<Subtask> subtasks) {
        super(name, group);
        this.subtasks = subtasks;
    }

    public MainTask(String name, LocalDateTime startDate, LocalDateTime endDate, String groupName, boolean finished, List<Subtask> subtasks, String id) {
        super(name, startDate, endDate, groupName, finished, id);
        this.subtasks = subtasks;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public void setFinished() {
        if(allSubtasksAreFinished()) {
            this.finished = true;
            this.endTime = LocalDateTime.now();
        } else {
            throw new RuntimeException("Not all subtasks finished");
        }
    }

    private boolean allSubtasksAreFinished() {
        if ( subtasks != null && !subtasks.isEmpty()) {
            return subtasks.stream().allMatch(Subtask::isFinished);
        } else {
            return true;
        }
    }

    public boolean isFinished() {
        return allSubtasksAreFinished() && finished;
    }

}
