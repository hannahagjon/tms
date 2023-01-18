package com.spp.tms.controller;

import com.spp.tms.domain.Task;
import com.spp.tms.domain.request.SaveTaskRequest;
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

    @GetMapping(value = "/task")
    public ResponseEntity<Task> getTask(@PathVariable("taskId") String id) {
        try {
            return ResponseEntity.ok(service.getTask(id));
        } catch (Exception e) {
            LOGGER.error("Failed to get task with id: {}", id, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateTask(Task task) {
        try {
            service.updateTask();
            LOGGER.info("in");
            return ResponseEntity.ok("Ping");
        } catch (Exception e) {
            LOGGER.error("Failed to save task with name: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveTask(@RequestBody SaveTaskRequest taskRequest) {
        try {
            String id = service.saveTask(taskRequest);
            return ResponseEntity.ok(id);
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
