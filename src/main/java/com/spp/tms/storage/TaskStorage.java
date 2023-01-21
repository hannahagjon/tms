package com.spp.tms.storage;

import com.spp.tms.domain.MainTask;

import java.util.HashMap;

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

//    public void mockTasks() {
//        List<Subtask> subtasks = Arrays.asList(Subtask.subTaskBuilder()
//                        .startTime(LocalDateTime.now().minusDays(2))
//                        .id("1-1")
//                        .group("5D")
//                        .name("SubTest")
//                        .finished(true)
//                        .endTime(LocalDateTime.now().minusDays(1)).build(),
//                Subtask.subTaskBuilder()
//                        .startTime(LocalDateTime.now().minusDays(1))
//                        .id("1-2")
//                        .group("5D")
//                        .name("SubTest2")
//                        .finished(false)
//                        .build());
//
//
//        MainTask task1 = new MainTask("Förvaltning", LocalDateTime.now(), null, "2D", false, null, "1");
//        MainTask task2 = new MainTask("Testning", LocalDateTime.now().minusDays(4), null, "5D", false, subtasks, "2");
//        MainTask task3 = new MainTask("Utveckling", LocalDateTime.now().minusDays(8), LocalDateTime.now(), "6D", false, null, "3");
//
//        tasksById.put("1", task1);
//        tasksById.put("2", task2);
//        tasksById.put("3", task3);
//
//    }
}
