// package com.backend_xeercise.taskmanagementsystem.restcontroller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.backend_xeercise.taskmanagementsystem.service.EmailService;

// @RestController
// public class EmailController {

// @Autowired
// private EmailService emailService;

// @GetMapping("/send-email")
// public String sendEmail(@RequestParam String to, @RequestParam String
// subject, @RequestParam String text) {
// emailService.sendSimpleEmail(to, subject, text);
// return "Email sent successfully";
// }
// }