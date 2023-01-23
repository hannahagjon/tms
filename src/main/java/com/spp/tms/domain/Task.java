package com.spp.tms.domain;

import lombok.Builder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;


public class Task {
    protected String name;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected Duration duration;
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

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean getFinished() {
        return finished;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public boolean isFinished(){
        return finished;
    }

    public long getDuration() {
        if(startTime != null && endTime != null) {
            return Duration.between(startTime, endTime).toHours();
        }
        return Duration.between(startTime, LocalDateTime.now()).toHours();
    }

}
