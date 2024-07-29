package com.backend_xeercise.taskmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.backend_xeercise.taskmanagementsystem.dataaccessopject.TasksAccOp;
import com.backend_xeercise.taskmanagementsystem.events.TaskAddedEvent;
import com.backend_xeercise.taskmanagementsystem.models.Tasks;

@Service
public class eventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private TasksAccOp tAP;

    public Tasks addTask(Tasks task) {
        Tasks savedTask = tAP.save(task);
        eventPublisher.publishEvent(new TaskAddedEvent(this, savedTask));
        return savedTask;
    }
}
