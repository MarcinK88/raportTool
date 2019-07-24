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

    public TableWriter() {

        this.wb = new XSSFWorkbook();
        this.types = Arrays.asList("Other", "Domain mgmt", "IP mgmt", "SSL Certificate", "DNS");
        this.years = new ArrayList<>();
        this.months = Arrays.asList("january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december");
        for(int i = 2016; i <= LocalDate.now().getYear();i++) {
            years.add(i);
        }


    }


    public void createOpenedPerMonth(ConvertedRepository convertedRepository) {

          int selectedMonthIndex = this.months.indexOf(this.selectedMonth);

        //tworzenie excela
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

        for (int rowIndex = 1; rowIndex < NUM_OF_ROWS; rowIndex++) {
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
        sheet = wb.createSheet("Requests per BA");
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
