package com.spp.tms.domain;

import com.spp.tms.domain.request.SubtaskRequest;
import com.spp.tms.domain.request.UpdateTaskRequest;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MainTask extends Task {
    private List<Subtask> subtasks;

    @Builder(builderMethodName = "mainTaskBuilder")
    public MainTask(String name, String group, List<Subtask> subtasks) {
        super(name, group);
        this.subtasks = subtasks != null ? subtasks : new ArrayList<>();
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public void setFinished(boolean finished) {
        if (finished) {
            if (allSubtasksAreFinished()) {
                this.finished = true;
                this.endTime = LocalDateTime.now();
            } else {
                throw new RuntimeException("Not all subtasks finished");
            }
        }
    }

    private boolean allSubtasksAreFinished() {
        if (subtasks != null && !subtasks.isEmpty()) {
            return subtasks.stream().allMatch(Subtask::isFinished);
        } else {
            return true;
        }
    }

    public MainTask update(MainTask original, UpdateTaskRequest update) {
        original.addSubtask(update.getSubtask());
        original.setFinished(update.isFinished());
        return original;
    }

    @Override
    public boolean isFinished() {
        return allSubtasksAreFinished() && finished;
    }

    private void addSubtask(SubtaskRequest subtask) {
        if (subtask != null && subtasks != null) {
            subtasks.add(new Subtask(subtask.getName(), subtask.getGroup()));
        }
    }

}
