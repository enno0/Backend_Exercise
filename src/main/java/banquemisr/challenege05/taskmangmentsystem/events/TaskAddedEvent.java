package banquemisr.challenege05.taskmangmentsystem.events;

import org.springframework.context.ApplicationEvent;

import banquemisr.challenege05.taskmangmentsystem.models.Tasks;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TaskAddedEvent extends ApplicationEvent {

    private final Tasks task;

    public TaskAddedEvent(Object source, Tasks task) {
        super(source);
        this.task = task;
    }

}