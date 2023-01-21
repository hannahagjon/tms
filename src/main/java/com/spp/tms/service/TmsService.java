package com.spp.tms.service;

import com.spp.tms.domain.MainTask;
import com.spp.tms.domain.request.SaveTaskRequest;
import com.spp.tms.domain.request.UpdateTaskRequest;
import com.spp.tms.mapper.RequestMapper;
import com.spp.tms.storage.TaskStorage;
import org.springframework.stereotype.Service;

@Service
public class TmsService {
    private static TaskStorage storage = new TaskStorage();

    public MainTask getTask(String id) {
        return storage.getTask(id);
    }

    public void updateTask(UpdateTaskRequest request) {
        MainTask task = storage.getTask(request.getId());
        MainTask updatedTask = task.update(task, request);
        storage.update(updatedTask);
    }

    public String saveTask(SaveTaskRequest taskRequest) {
        if (taskRequest != null) {
            MainTask task = RequestMapper.map(taskRequest);
            return storage.addTask(task);
        } else {
            return null;
        }
    }

    public void deleteTask(String id) {
        storage.deleteTask(id);
    }

    public void mock() {
//        storage.mockTasks();
    }
}
