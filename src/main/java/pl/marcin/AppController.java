package pl.marcin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class AppController {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ConvertedRepository convertedRepository;

    private File selectedFile;
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
    public String testimport(Model model) throws Exception {
//        System.out.println("w testpage: " + selectedFile.getAbsolutePath());
//        File myFile = new File("C:\\Users\\10619730\\Desktop\\New folder\\raportTool3\\src\\test.xlsx");
        FileInputStream fis = new FileInputStream(selectedFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();

        List<Ticket> ticket2s = new ArrayList<>();
        DateConverter dateConverter;

        Row row = rowIterator.next();
        DataFormatter fmt = new DataFormatter();
        while (rowIterator.hasNext()) {
            row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            String valueToInsert = "";
            while (cellIterator.hasNext()) {


                Ticket ticket2 = new Ticket();
                valueToInsert = cellIterator.next().toString();
                ticket2.setNumber(valueToInsert);

                //pobieramy datę z pliku
                valueToInsert = cellIterator.next().toString();

                //tworzymy konwerter daty
                dateConverter = new DateConverter(valueToInsert);

                //używamy konwertera daty
                java.sql.Date sqlDate = dateConverter.toSqlDate();

                //przypisujemy przekonwertowaną datę
                ticket2.setOpen_time(sqlDate);

                ticket2.setOpened_by(fmt.formatCellValue(cellIterator.next()));
                ticket2.setAssignment(cellIterator.next().toString());
                ticket2.setStatus(cellIterator.next().toString());

                //pobieramy datę z pliku
                valueToInsert = cellIterator.next().toString();

                //tworzymy konwerter daty
                dateConverter = new DateConverter(valueToInsert);

                //używamy konwertera daty
                sqlDate = dateConverter.toSqlDate();

                //przypisujemy przekonwertowaną datę
                ticket2.setClose_time(sqlDate);
                ticket2.setResolution_code(cellIterator.next().toString());
                ticket2.setLocation(cellIterator.next().toString());
                //
                ticket2.setAssignee_name(fmt.formatCellValue(cellIterator.next()));
                ticket2.setContact_name(fmt.formatCellValue(cellIterator.next()));
                ticket2.setCompany(cellIterator.next().toString());
                ticket2.setBrief_description(cellIterator.next().toString());
                ticket2.setProblem_status(cellIterator.next().toString());
                ticket2.setRequest_type(cellIterator.next().toString());
                ticket2.setProduct_type(cellIterator.next().toString());
                ticket2.setResolved_by(cellIterator.next().toString());

                //pobieramy datę z pliku
                valueToInsert = cellIterator.next().toString();

                //tworzymy konwerter daty
                dateConverter = new DateConverter(valueToInsert);

                //używamy konwertera daty
                sqlDate = dateConverter.toSqlDate();

                ticket2.setResolved_time(sqlDate);
                ticket2.setContact_service(fmt.formatCellValue(cellIterator.next()));
                ticket2.setTk_contact_fullname(cellIterator.next().toString());
                ticket2.setTk_contact_email(cellIterator.next().toString());
                ticket2.setTk_sap_company_full_name(cellIterator.next().toString());
                ticket2.setTk_assignee_name_fullname(cellIterator.next().toString());
                ticket2.setTk_contact_service_fullname(cellIterator.next().toString());
                ticket2.setTk_callback_contact_ldap_ba(cellIterator.next().toString());
                ticket2.setBa(cellIterator.next().toString());
                ticket2.setTk_country_fullname(cellIterator.next().toString());
                ticket2.setDim_regions_id(cellIterator.next().toString());
                ticket2.setTk_company_id(fmt.formatCellValue(cellIterator.next()));

                ticket2s.add(ticket2);

                convertedRepository.save(TicketConverter.convertTicket(ticket2));

            }


        }
        model.addAttribute("tickets", ticket2s);


        return "ticketlist2";
    }

    @GetMapping("/importlist")
    public String importFile(Model model){

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
        }

        return "redirect:/test";
    }


}
