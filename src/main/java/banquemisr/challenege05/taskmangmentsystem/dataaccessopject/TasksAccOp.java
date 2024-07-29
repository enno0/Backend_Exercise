package banquemisr.challenege05.taskmangmentsystem.dataaccessopject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import banquemisr.challenege05.taskmangmentsystem.models.Tasks;

public interface TasksAccOp extends JpaRepository<Tasks, Long>, JpaSpecificationExecutor<Tasks> {

}
