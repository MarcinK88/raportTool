package pl.marcin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppController {


    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/")
    public String homepage(Model model){
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);

        return "homepage";
    }

}
