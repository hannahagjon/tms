package com.spp.tms.service;

import com.spp.tms.domain.Task;
import com.spp.tms.domain.request.SaveTaskRequest;
import com.spp.tms.mapper.RequestMapper;
import com.spp.tms.storage.TaskStorage;
import org.springframework.stereotype.Service;

@Service
public class TmsService {
    private static TaskStorage storage = new TaskStorage();

    public Task getTask(String id){
        return storage.getTask(id);
    }

    public void updateTask() {

    }

    public String saveTask(SaveTaskRequest taskRequest) {
        Task task = RequestMapper.map(taskRequest);
        return storage.addTask(task);
    }

    public void deleteTask(String id) {
        storage.deleteTask(id);
    }

    public void mock() {
        storage.mockTasks();
    }
}
