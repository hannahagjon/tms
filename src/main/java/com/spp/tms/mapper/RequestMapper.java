package com.spp.tms.mapper;

import com.spp.tms.domain.MainTask;
import com.spp.tms.domain.Subtask;
import com.spp.tms.domain.request.SaveTaskRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RequestMapper {
    public static MainTask map(SaveTaskRequest taskRequest) {

        return  new MainTask(taskRequest.getName(), taskRequest.getGroup(), createSubtasks(taskRequest.getSubtasks()));
    }

    private static List<Subtask> createSubtasks(List<Subtask> subtasks) {
        return subtasks != null ? subtasks.stream()
                .filter(Objects::nonNull)
                .map(RequestMapper::mapSubtasks)
                .collect(Collectors.toList())
                : new ArrayList<>();
    }

    private static Subtask mapSubtasks(Subtask subtask) {
        return new Subtask(subtask.getName(),  subtask.getGroup());
    }
}
