package pl.marcin;

import java.util.ArrayList;
import java.util.List;

public class TicketConverter {

//    private List<Ticket> ticketsToConvert;
//    private Ticket ticketToConvert;

    public static List<Converted> convertList(List<Ticket> ticketsToConvert) {


        List<Converted> convertedList = new ArrayList<>();

        for (int i = 0; i < ticketsToConvert.size(); i++) {
            Converted converted = new Converted();

            converted.setRequestId(ticketsToConvert.get(i).getNumber());
            converted.setRequestType(ticketsToConvert.get(i).getRequest_type());
            converted.setCertificateName(ticketsToConvert.get(i).getBrief_description());
            converted.setRequestOwner(ticketsToConvert.get(i).getTk_assignee_name_fullname());
            System.out.println("problem status = " + ticketsToConvert.get(i).getProblem_status());
            if(ticketsToConvert.get(i).getProblem_status().equalsIgnoreCase("closed") ||
                    ticketsToConvert.get(i).getProblem_status().equalsIgnoreCase("resolved")) {
                System.out.println("wykryto wartość in closed lub resolved, powinno zapisać Closed");
                converted.setRequestStatus("Closed");
            } else {
                System.out.println("wykryto inną wartośc, powinno zapisać In progress");
                converted.setRequestStatus("In progress");
            }
            converted.setYear(ticketsToConvert.get(i).getOpen_time().toLocalDate().getYear());
            converted.setOpenDate(ticketsToConvert.get(i).getOpen_time());
            converted.setOpenCw(ticketsToConvert.get(i).getOpen_time().toLocalDate().getDayOfYear()/7);
            converted.setOpenMonth(ticketsToConvert.get(i).getOpen_time().toLocalDate().getMonth().name());
            converted.setCloseDate(ticketsToConvert.get(i).getClose_time());
            converted.setCloseCw(ticketsToConvert.get(i).getClose_time().toLocalDate().getDayOfYear()/7);
            converted.setCloseMonth(ticketsToConvert.get(i).getClose_time().toLocalDate().getMonth().name());
            converted.setResolutionTimeInDays((int) (converted.getCloseDate().getTime() - converted.getOpenDate().getTime()));
            converted.setRegion(ticketsToConvert.get(i).getDim_regions_id());
            converted.setBa(ticketsToConvert.get(i).getBa());
            converted.setRequester(ticketsToConvert.get(i).getTk_contact_fullname());
            converted.setComments(ticketsToConvert.get(i).getTk_contact_email());

            convertedList.add(converted);
        }


        return convertedList;
    }

    public static Converted convertTicket(Ticket ticketToConvert) {

        Converted converted = new Converted();

        converted.setRequestId(ticketToConvert.getNumber());
        converted.setRequestType(ticketToConvert.getRequest_type());
        converted.setCertificateName(ticketToConvert.getBrief_description());
        converted.setRequestOwner(ticketToConvert.getTk_assignee_name_fullname());
        if(ticketToConvert.getProblem_status().equalsIgnoreCase("closed") ||
                ticketToConvert.getProblem_status().equalsIgnoreCase("resolved")) {
            converted.setRequestStatus("Closed");
        } else {
            converted.setRequestStatus("In progress");
        }
        converted.setYear(ticketToConvert.getOpen_time().toLocalDate().getYear());
        converted.setOpenDate(ticketToConvert.getOpen_time());
        converted.setOpenCw(ticketToConvert.getOpen_time().toLocalDate().getDayOfYear()/7 + 1);
        converted.setOpenMonth(ticketToConvert.getOpen_time().toLocalDate().getMonth().name());
        if(ticketToConvert.getResolved_time() != null) {
            converted.setCloseDate(ticketToConvert.getResolved_time());
            converted.setCloseCw(ticketToConvert.getResolved_time().toLocalDate().getDayOfYear() / 7 + 1);
            converted.setCloseMonth(ticketToConvert.getResolved_time().toLocalDate().getMonth().name());

            converted.setResolutionTimeInDays(converted.getCloseDate().toLocalDate().getDayOfYear() -
                    converted.getOpenDate().toLocalDate().getDayOfYear());
            if(converted.getResolutionTimeInDays() == 0) {
                converted.setResolutionTimeInDays(1);
            }
        }
        converted.setRegion(ticketToConvert.getDim_regions_id());
        converted.setBa(ticketToConvert.getBa());
        converted.setRequester(ticketToConvert.getTk_contact_fullname());
        converted.setComments(ticketToConvert.getTk_contact_email());

        return converted;


    }

}
