package pl.marcin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ConvertedRepository convertedRepository;

    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/alltickets")
    public String alltickets(Model model){
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);

        return "ticketlist";
    }

    @GetMapping("/opentickets")
    public String opentickets(Model model){
        List<Ticket> tickets = ticketRepository.findByStatusLike("open");
        model.addAttribute("tickets", tickets);

        return "ticketlist";
    }

    @GetMapping("/converted")
    public String converted(Model model) {
        List<Converted> converted = convertedRepository.findAll();
        model.addAttribute("converted", converted);
        return "converted";
    }

}
