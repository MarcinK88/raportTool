package pl.marcin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String postLogin(@ModelAttribute User user, HttpServletRequest request) {


        User user1 = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if(user1 != null) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user1.getLogin());

            return "id: " + user1.getId() + ", login: " + user1.getLogin() + ", password: " + user1.getPassword() + ", logged user: " + session.getAttribute("loggedUser");
        } else {
            return "niepoprawny login lub hasło";
        }


    }

}
