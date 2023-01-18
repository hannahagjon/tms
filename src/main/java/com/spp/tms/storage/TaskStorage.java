package com.spp.tms.storage;

import com.spp.tms.domain.Subtask;
import com.spp.tms.domain.Task;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TaskStorage {
    private static HashMap<String, Task> tasksById;

    public HashMap<String, Task> getTasksById() {
        return tasksById;
    }

//    public void setTasksById(HashMap<String, Task> tasksById) {
//        this.tasksById = tasksById;
//    }

    public Task getTask(String id) {
        return tasksById.getOrDefault(id, null);
    }

    public String addTask(Task task) {
        String id = task.getId();
        tasksById.put(id, task);
        return id;
    }

    public void deleteTask(String taskId) {
        tasksById.remove(taskId);
    }

    public void mockTasks() {
        List<Subtask> subtasks = Arrays.asList(Subtask.builder()
                        .startTime(LocalDateTime.now().minusDays(2))
                        .id("1-1")
                        .group("5D")
                        .name("SubTest")
                        .finished(true)
                        .endTime(LocalDateTime.now().minusDays(1)).build(),
                Subtask.builder()
                        .startTime(LocalDateTime.now().minusDays(1))
                        .id("1-2")
                        .group("5D")
                        .name("SubTest2")
                        .finished(false)
                        .build());
        Task task1 = new Task("Förvaltning", LocalDateTime.now(), null, "2D", false, null, "1");
        Task task2 = new Task("Testning", LocalDateTime.now().minusDays(4), null, "5D", false, subtasks, "2");
        Task task3 = new Task("Utveckling", LocalDateTime.now().minusDays(8), LocalDateTime.now(), "6D", false, null, "3");

        tasksById.put("1", task1);
        tasksById.put("2", task2);
        tasksById.put("3", task3);

    }
}
