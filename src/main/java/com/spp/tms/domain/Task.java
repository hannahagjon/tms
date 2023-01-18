package com.spp.tms.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public class Task {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String group;
    private boolean finished;
    private List<Subtask> subtasks;
    private String id;

    public Task(String name, String group, List<Subtask> subtasks) {
        this.name = name;
        this.group = group;
        this.subtasks = subtasks;
        this.startTime = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.finished = false;
    }

    public Task(String name, LocalDateTime startTime, LocalDateTime endTime, String group, boolean finished, List<Subtask> subtasks, String id) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.group = group;
        this.finished = finished;
        this.subtasks = subtasks;
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

    public boolean isFinished() {
        return allSubtasksAreFinished() && finished;

    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished() {
         this.finished = allSubtasksAreFinished();
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
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

    public void setId(String id) {
        this.id = id;
    }

    private boolean allSubtasksAreFinished() {
        if (!subtasks.isEmpty()) {
            return subtasks.stream().allMatch(Subtask::isFinished);
        } else {
            return true;
        }
    }
}
