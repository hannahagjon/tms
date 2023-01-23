package com.spp.tms.storage;

import com.spp.tms.domain.MainTask;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TaskStorage {
    private static HashMap<String, MainTask> tasksById = new HashMap<>();

    public HashMap<String, MainTask> getTasksById() {
        return tasksById;
    }

    public MainTask getTask(String id) {
        MainTask task = tasksById.getOrDefault(id, null);
        if (task != null) {
            return task;
        } else {
            String message = String.format("Task with id %s not found", id);
            throw new RuntimeException(message);
        }
    }

    public String addTask(MainTask task) {
        String id = task.getId();
        tasksById.put(id, task);
        return id;
    }

    public void deleteTask(String taskId) {
        tasksById.remove(taskId);
    }

    public void update(MainTask task) {
        tasksById.replace(task.getId(), task);
    }

}
