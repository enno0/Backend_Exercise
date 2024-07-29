package banquemisr.challenege05.taskmangmentsystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthControllerWeb {

    @GetMapping("/")
    public String home(Model model) {
        return "Home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "Welcome :)");
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            request.getSession().invalidate(); // Invalidate the session
            response.setStatus(HttpServletResponse.SC_OK); // Commit the response
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        // Render the logout success page
        return "logout";
    }
}
