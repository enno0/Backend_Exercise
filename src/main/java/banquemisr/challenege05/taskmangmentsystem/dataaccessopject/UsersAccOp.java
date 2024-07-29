package banquemisr.challenege05.taskmangmentsystem.dataaccessopject;

import org.springframework.data.jpa.repository.JpaRepository;

import banquemisr.challenege05.taskmangmentsystem.models.Users;

public interface UsersAccOp extends JpaRepository<Users, Long> {

}
