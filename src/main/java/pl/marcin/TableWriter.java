package pl.marcin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableWriter {

    private List<Integer> years;
    private List<String> months;
    private int selectedYear;
    private String selectedMonth;
    private List<String> types;
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private List<String> ba;

    public TableWriter() {

        this.wb = new XSSFWorkbook();
        this.types = Arrays.asList("Other", "Domain mgmt", "IP mgmt", "SSL Certificate", "DNS");
        this.years = new ArrayList<>();
        this.months = Arrays.asList("january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december");
        for(int i = 2016; i <= LocalDate.now().getYear(); i++) {
            years.add(i);
        }
        this.ba = Arrays.asList("CO", "IS", "MX", "SE", "ET", "CT");



    }


    public void createOpenedPerMonth(ConvertedRepository convertedRepository) {

        int selectedMonthIndex = this.months.indexOf(this.selectedMonth);

        //tworzenie arkusza
        sheet = wb.createSheet("opened per month");
        //liczba wierszy i kolumn
        final int NUM_OF_ROWS = 6;
        final int NUM_OF_COLUMNS = 13;

        Row row;
        Cell cell;

        //tworzenie pierwszego rzędu
        row = sheet.createRow(0);

        //uzupełnianie pierwszego rzędu
        cell = row.createCell(0);
        int i = 0;
        for (int colIndex = 1; colIndex < NUM_OF_COLUMNS; colIndex++) {
            cell = row.createCell((short) colIndex);
            if ((colIndex + selectedMonthIndex) < this.months.toArray().length) {
                cell.setCellValue(this.months.get(colIndex + selectedMonthIndex));
            } else {
                cell.setCellValue(this.months.get(i));
                i++;
            }

        }

        //kolejne rzędy
        for (int rowIndex = 1; rowIndex < NUM_OF_ROWS; rowIndex++) {
            //tworzenie rzędu
            row = sheet.createRow((short) rowIndex);
            cell = row.createCell(0);
            cell.setCellValue(this.types.get(rowIndex - 1));
            i = 0;
            for (int colIndex = 1; colIndex < NUM_OF_COLUMNS; colIndex++) {
                cell = row.createCell((short) colIndex);
                if ((colIndex + selectedMonthIndex) < this.months.toArray().length) {
                    cell.setCellValue(convertedRepository.countByRequestTypeAndOpenDateStartsWith(this.types.get(rowIndex - 1), selectedYear - 1, colIndex + selectedMonthIndex + 1));
                } else {
                    cell.setCellValue(convertedRepository.countByRequestTypeAndOpenDateStartsWith(this.types.get(rowIndex - 1), selectedYear, i + 1));
                    i++;
                }

            }
        }

    }

    public void createRequestPerBa(ConvertedRepository convertedRepository) {

        int selectedMonthIndex = this.months.indexOf(this.selectedMonth);

        //tworzenie arkusza
        sheet = wb.createSheet("Requests per BA");

        //liczba wierszy i kolumn
        final int NUM_OF_ROWS =4;
        final int NUM_OF_COLUMNS = 7;

        Row row;
        Cell cell;

        //tworzenie pierwszego rzędu
        row = sheet.createRow(0);

        //uzupełnianie pierwszego rzędu
        cell = row.createCell(0);
        int i = 0;
        for (int colIndex = 1; colIndex < NUM_OF_COLUMNS; colIndex++) {
            cell = row.createCell((short) colIndex);
            cell.setCellValue(this.ba.get(colIndex-1));
        }

        //kolejne rzędy
        for (int rowIndex = 1; rowIndex < NUM_OF_ROWS; rowIndex++) {
            //tworzenie rzędu
            row = sheet.createRow((short) rowIndex);
            cell = row.createCell(0);

            //jeżeli wybrany styczeń - luty
            if(selectedMonthIndex-(NUM_OF_ROWS-rowIndex-1) < 0) {
                cell.setCellValue(this.months.get(this.months.size() -(NUM_OF_ROWS - rowIndex - selectedMonthIndex - 1)));
            } else {
                cell.setCellValue(this.months.get(selectedMonthIndex - (NUM_OF_ROWS - rowIndex - 1)));
            }
            i=0;
            for(int colIndex = 1; colIndex < NUM_OF_COLUMNS; colIndex++){
                cell = row.createCell(colIndex);

                //jeżeli wybrany styczeń - luty
                if(selectedMonthIndex-(NUM_OF_ROWS-rowIndex-2) <= 0){
                    System.out.println("wybrany ba: " + this.ba.get(colIndex - 1));
                    System.out.println("wybrany rok: " + (selectedYear-1));
                    System.out.println("wybrany miesiąc: " + (this.months.size() - (NUM_OF_ROWS - rowIndex - selectedMonthIndex)));
                    System.out.println("wpisana wartość: " + convertedRepository.countRequestPerBa(this.ba.get(colIndex - 1), selectedYear - 1, this.months.size() - (NUM_OF_ROWS - rowIndex - selectedMonthIndex)) );
                    System.out.println("this.months.size = " + this.months.size());
                    System.out.println("NUM_OF_ROWS: " + NUM_OF_ROWS);
                    System.out.println("rowIndex: " + rowIndex);
                    System.out.println("selectedMonthIndex: " + selectedMonthIndex);
                    System.out.println("NUM_OF_ROWS - rowIndex - selectedMonthIndex - 2 : " + (NUM_OF_ROWS - rowIndex - selectedMonthIndex - 2));
                    System.out.println("this.months.size() - (NUM_OF_ROWS - rowIndex - selectedMonthIndex - 2): " + (this.months.size() - (NUM_OF_ROWS - rowIndex - selectedMonthIndex - 2)));
                                                                                                                            //          12-(4-1-1
                    cell.setCellValue(convertedRepository.countRequestPerBa(this.ba.get(colIndex - 1), selectedYear - 1, this.months.size() - (NUM_OF_ROWS - rowIndex - selectedMonthIndex - 2)));
                    i++;
                } else {
                    cell.setCellValue(convertedRepository.countRequestPerBa(this.ba.get(colIndex - 1), selectedYear, selectedMonthIndex - (NUM_OF_ROWS - rowIndex - 2)));
                }
            }

        }


    }

    public void saveToFile() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\10619730\\Desktop\\New folder\\test.xlsx")) {
            wb.write(fileOut);
        }
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
