package com.spp.tms.controller;

import com.spp.tms.domain.MainTask;
import com.spp.tms.domain.request.SaveTaskRequest;
import com.spp.tms.domain.request.UpdateTaskRequest;
import com.spp.tms.service.TmsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("controller")
public class TmsRestController {
    private final Logger LOGGER = LogManager.getLogger(TmsRestController.class);
    private final TmsService service;

    public TmsRestController(@Autowired TmsService service) {
        this.service = service;
    }

    @GetMapping(value = "/task/{taskId}")
    public ResponseEntity<MainTask> getTask(@PathVariable("taskId") String id) {
        try {
            return ResponseEntity.ok(service.getTask(id));
        } catch (Exception e) {
            LOGGER.error("Failed to get task with id: {}", id, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateTask(@RequestBody UpdateTaskRequest request) {
        try {
            service.updateTask(request);
            return ResponseEntity.ok("Task updated");
        } catch (Exception e) {
            String message = String.format("Failed to update task with id: %s, due to: %s", request.getId(), e.getMessage());
            LOGGER.error("Failed to update task with id: {}", request.getId(), e);
            return ResponseEntity.internalServerError().body(message);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveTask(@RequestBody SaveTaskRequest taskRequest) {
        try {
            String id = service.saveTask(taskRequest);
            return id != null ? ResponseEntity.ok(id) : ResponseEntity.internalServerError().build();
        } catch (Exception e) {
            LOGGER.error("Failed to save task with name: {}", taskRequest.getName(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteTask(String id) {
        try {
            service.deleteTask(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            LOGGER.error("Failed to delete task with id: {}", id, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/mock")
    public void mock() {
        service.mock();

    }
}
