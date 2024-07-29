package banquemisr.challenege05.taskmangmentsystem.service;

import banquemisr.challenege05.taskmangmentsystem.dataaccessopject.TasksAccOp;
import banquemisr.challenege05.taskmangmentsystem.events.TaskAddedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import banquemisr.challenege05.taskmangmentsystem.models.Tasks;

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
