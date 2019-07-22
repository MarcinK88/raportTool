package pl.marcin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ConvertedRepository convertedRepository;

    @GetMapping("/alltickets")
    public String alltickets(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);

        return "ticketlist";
    }

    @GetMapping("/opentickets")
    public String opentickets(Model model) {
        List<Converted> tickets = convertedRepository.findByRequestStatus("in progress");
        model.addAttribute("converted", tickets);

        return "converted";
    }

    @GetMapping("/converted")
    public String converted(Model model) {
        List<Converted> converted = convertedRepository.findAll();
        model.addAttribute("converted", converted);
        return "converted";
    }

    @GetMapping("/editTicket/{id}")
    public String editTicket(@PathVariable long id, Model model) {
        System.out.println(id);

        Converted toEdit = convertedRepository.findById(id).get();

        model.addAttribute("ticket", toEdit);

        List<String> ticketOwners = new ArrayList<>();
        ticketOwners.add("Matthias Hagen");
        ticketOwners.add("Marcin Kucharczyk");
        ticketOwners.add("Katarzyna Rytter");
        ticketOwners.add("Frank Witzer");
        model.addAttribute("ticketOwners",ticketOwners);

        List<String> ba = new ArrayList<>();
        ba.add("CO");
        ba.add("CT");
        ba.add("ET");
        ba.add("IS");
        ba.add("MX");
        ba.add("SE");
        model.addAttribute("ba",ba);

        List<String> region = new ArrayList<>();
        region.add("EMEA");
        region.add("APAC");
        region.add("LATAM");
        region.add("NA");
        model.addAttribute("region",region);

        List<String> requestType = new ArrayList<>();
        requestType.add("SSL Certificate");
        requestType.add("DNS");
        requestType.add("IP mgmt");
        requestType.add("Domain mgmt");
        requestType.add("Other");
        model.addAttribute("requestType",requestType);

        List<String> status = new ArrayList<>();
        status.add("In progress");
        status.add("Closed");
        model.addAttribute("status",status);

        return "editticket";
    }

    @PostMapping("/editTicket/{id}")
    public String editTicket(@ModelAttribute Converted ticket) {

        if(ticket.getCloseDate()!=null) {
            ticket.setCloseCw(ticket.getCloseDate().toLocalDate().getDayOfYear() / 7 + 1);
            ticket.setCloseMonth(ticket.getCloseDate().toLocalDate().getMonth().name());
            ticket.setResolutionTimeInDays(ticket.getCloseDate().toLocalDate().getDayOfYear() -
                    ticket.getOpenDate().toLocalDate().getDayOfYear());
            if(ticket.getResolutionTimeInDays() == 0) {
                ticket.setResolutionTimeInDays(1);
            }
        }

        ticket.setCloseDate(null);
        convertedRepository.save(ticket);
        return "redirect:/converted";
    }

    @GetMapping("/noregion")
    public String noregion(Model model) {
        List<Converted> tickets = convertedRepository.findByRegion("NULL");
        model.addAttribute("converted", tickets);

        return "converted";
    }

    @GetMapping("/noba")
    public String noba(Model model) {
        List<Converted> tickets = convertedRepository.findByBa("n.a");
        model.addAttribute("converted", tickets);

        return "converted";
    }

    @GetMapping("/norequester")
    public String norequester(Model model) {
        List<Converted> tickets = convertedRepository.findByRequester("UNKNOWN_EMAIL");
        List<Converted> tickets2 = convertedRepository.findByRequester("EMAIL_ADDRESS_NOT_UNIQUE");
        tickets.addAll(tickets2);

        model.addAttribute("converted", tickets);

        return "converted";
    }

    @GetMapping("/nocomments")
    public String nocomments(Model model) {
        List<Converted> tickets = convertedRepository.findByComments("NULL");

        model.addAttribute("converted", tickets);

        return "converted";
    }

}
