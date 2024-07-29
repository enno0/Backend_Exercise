package banquemisr.challenege05.taskmangmentsystem.datatransferopject;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TasksTransferOpject {

    @NotNull(message = "operation cannot be null")
    private String operation;

}
