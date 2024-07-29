//package banquemisr.challenege05.taskmangmentsystem.events;
//
//import java.util.List;
//
//import banquemisr.challenege05.taskmangmentsystem.dataaccessopject.UsersAccOp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//import banquemisr.challenege05.taskmangmentsystem.models.Users;
//
//@Component
//public class TaskAddedEventListener {
//    @Autowired
//    private UsersAccOp uAO;
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @EventListener
//    public void onTaskAdded(TaskAddedEvent event) {
//        List<Users> allUsers = uAO.findAll();
//        for (Users user : allUsers) {
//            try {
//                sendEmail(user.getEmail(), "New Task Added",
//                        "A new task has been added: " + event.getTask().getTitle());
//            } catch (Exception e) {
//                // Log the exception and continue
//                System.err.println("Failed to send email to " + user.getEmail() + ": " + e.getMessage());
//            }
//        }
//    }
//
//    private void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        mailSender.send(message);
//    }
//}
