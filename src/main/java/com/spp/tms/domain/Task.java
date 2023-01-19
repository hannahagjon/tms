package com.spp.tms.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;


public class Task {
    protected String name;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
//    protected Duration duration;
    protected String group;
    protected boolean finished;
    protected String id;

    public Task(String name, String group) {
        this.name = name;
        this.group = group;
        this.startTime = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.finished = false;
    }
    @Builder
    public Task(String name, LocalDateTime startTime, LocalDateTime endTime, String group, boolean finished, String id) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.group = group;
        this.finished = finished;
//        this.subtasks = subtasks;
        this.id = id;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

//    public boolean isFinished() {
//        return allSubtasksAreFinished() && finished;
//
//    }
//
    public void setFinished() {
        this.finished = true;
    }

    public boolean getFinished() {
        return finished;
    }

//    public List<Subtask> getSubtasks() {
//        return subtasks;
//    }
//
//    public void setSubtasks(List<Subtask> subtasks) {
//        this.subtasks = subtasks;
//    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public Duration getDuration(){
//        return Duration.between(startTime, endTime);
//    }


}
