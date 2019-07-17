package pl.marcin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
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
    public String alltickets(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);

        return "ticketlist";
    }

    @GetMapping("/opentickets")
    public String opentickets(Model model) {
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

    @GetMapping("/test")
    @ResponseBody
    public String testimport() throws Exception {
        File myFile = new File("C:\\Users\\10619730\\Desktop\\New folder\\raportTool3\\src\\test.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();

        List<Ticket2> ticket2s = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {


                Ticket2 ticket2 = new Ticket2();
                ticket2.setNumber(cellIterator.next().toString());
                ticket2.setOpen_time(Date.valueOf(cellIterator.next().toString()));
                ticket2.setOpened_by(cellIterator.next().toString());
                ticket2.setAssignment(cellIterator.next().toString());
                ticket2.setStatus(cellIterator.next().toString());
                ticket2.setClose_time(Date.valueOf(cellIterator.next().toString()));
                ticket2.setResolution_code(cellIterator.next().toString());
                ticket2.setLocation(cellIterator.next().toString());
                ticket2.setAssignee_name(cellIterator.next().toString());
                ticket2.setContact_name(cellIterator.next().toString());
                ticket2.setCompany(cellIterator.next().toString());
                ticket2.setBrief_description(cellIterator.next().toString());
                ticket2.setProblem_status(cellIterator.next().toString());
                ticket2.setRequest_type(cellIterator.next().toString());
                ticket2.setProduct_type(cellIterator.next().toString());
                ticket2.setResolved_by(cellIterator.next().toString());
                ticket2.setResolved_time(Date.valueOf(cellIterator.next().toString()));
                ticket2.setContact_service(cellIterator.next().toString());
                ticket2.setTk_contact_fullname(cellIterator.next().toString());
                ticket2.setTk_contact_email(cellIterator.next().toString());
                ticket2.setTk_sap_company_full_name(cellIterator.next().toString());
                ticket2.setTk_assignee_name_fullname(cellIterator.next().toString());
                ticket2.setTk_contact_service_fullname(cellIterator.next().toString());
                ticket2.setTk_callback_contact_ldap_ba(cellIterator.next().toString());
                ticket2.setBa(cellIterator.next().toString());
                ticket2.setTk_country_fullname(cellIterator.next().toString());
                ticket2.setDim_regions_id(cellIterator.next().toString());
                ticket2.setTk_company_id(cellIterator.next().toString());

                ticket2s.add(ticket2);
            }


        }
        return ticket2s.get(2).getNumber();
    }
}
