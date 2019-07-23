package pl.marcin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xddf.usermodel.PresetColor;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class ChartController {

    @Autowired
    private ConvertedRepository convertedRepository;

    @GetMapping("/charts")
    public String charts() {

        return "charts";
    }

    @GetMapping("/charttest")
    public String charttestGet(Model model) {

        List<Integer> years = Arrays.asList(2016,2017,2018,2019);
        List<String> months = Arrays.asList("january","february","march","april","may","june","july","august","september","october","november","december");
        model.addAttribute("years",years);
        model.addAttribute("months",months);
        SelectedDate selectedDate = new SelectedDate();
        model.addAttribute(selectedDate);
        return "charttest";
    }

    @PostMapping("/charttest")
    public String charttestPost( @ModelAttribute SelectedDate selectedDate) throws IOException {



        List<String> months = Arrays.asList("january","february","march","april","may","june","july","august","september","october","november","december");
        List<String> types = Arrays.asList("Other","Domain mgmt", "IP mgmt", "SSL Certificate", "DNS");
        int selectedMonth = months.indexOf(selectedDate.month); //june
        int selectedYear = selectedDate.year;
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            //tworzenie excela
            XSSFSheet sheet = wb.createSheet("opened per month");
            //liczba wierszy i kolumn
            final int NUM_OF_ROWS = 6;
            final int NUM_OF_COLUMNS = 13;
            //ostatni uwzględniany miesiąc

            // Create a row and put some cells in it. Rows are 0 based.
            Row row;
            Cell cell;

            //tworzenie pierwszego rzędu
            row = sheet.createRow(0);
            //uzupełnianie pierwszego rzędu
            cell = row.createCell(0);
            int i = 0;
            for (int colIndex = 1; colIndex < NUM_OF_COLUMNS; colIndex++) {
                cell = row.createCell((short) colIndex);
                if((colIndex+selectedMonth)< months.toArray().length) {
                    cell.setCellValue(months.get(colIndex + selectedMonth));
                } else {
                    cell.setCellValue(months.get(i));
                    i++;
                }

            }

            for (int rowIndex = 1; rowIndex < NUM_OF_ROWS; rowIndex++) {
                row = sheet.createRow((short) rowIndex);
                cell = row.createCell(0);
                cell.setCellValue(types.get(rowIndex-1));
                i = 0;
                for (int colIndex = 1; colIndex < NUM_OF_COLUMNS; colIndex++) {
                    cell = row.createCell((short) colIndex);
                    if((colIndex+selectedMonth)< months.toArray().length) {
                        cell.setCellValue(convertedRepository.countByRequestTypeAndOpenDateStartsWith(types.get(rowIndex-1),selectedYear-1, colIndex + selectedMonth + 1));
                    } else {
                        cell.setCellValue(convertedRepository.countByRequestTypeAndOpenDateStartsWith(types.get(rowIndex-1),selectedYear, i + 1));
                        i++;
                    }

                }
            }

//            XSSFDrawing drawing = sheet.createDrawingPatriarch();
//            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);
//
//            XSSFChart chart = drawing.createChart(anchor);
//            chart.setTitleText("BarChart");
//            chart.setTitleOverlay(false);
//            XDDFChartLegend legend = chart.getOrAddLegend();
//            legend.setPosition(LegendPosition.TOP_RIGHT);
//
//            // Use a category axis for the bottom axis.
//            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
//            bottomAxis.setTitle("x");
//            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
//            leftAxis.setTitle("f(x)");
//            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
//
//            XDDFDataSource<Double> xs = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 1, NUM_OF_COLUMNS - 1));
//            XDDFNumericalDataSource<Double> ys1 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 1, NUM_OF_COLUMNS - 1));
//            XDDFNumericalDataSource<Double> ys2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 1, NUM_OF_COLUMNS - 1));
//            XDDFNumericalDataSource<Double> ys3 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(3, 3, 1, NUM_OF_COLUMNS - 1));
//            XDDFNumericalDataSource<Double> ys4 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(4, 4, 1, NUM_OF_COLUMNS - 1));
//            XDDFNumericalDataSource<Double> ys5 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(5, 5, 1, NUM_OF_COLUMNS - 1));
//
//            XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
//            XDDFChartData.Series series1 = data.addSeries(xs, ys1);
//            series1.setTitle("2x", null);
//            XDDFChartData.Series series2 = data.addSeries(xs, ys2);
//            series2.setTitle("3x", null);
//            XDDFChartData.Series series3 = data.addSeries(xs, ys3);
//            series2.setTitle("4x", null);
//            XDDFChartData.Series series4 = data.addSeries(xs, ys4);
//            series2.setTitle("5x", null);
//            XDDFChartData.Series series5 = data.addSeries(xs, ys5);
//            series2.setTitle("6x", null);
//
//            chart.plot(data);

//            // in order to transform a bar chart into a column chart, you just need to change the bar direction
//            XDDFBarChartData bar = (XDDFBarChartData) data;
//            bar.setBarDirection(BarDirection.COL);
//            // looking for "Stacked Bar Chart"? uncomment the following line
//            // bar.setBarGrouping(BarGrouping.STACKED);
//
//            solidFillSeries(data, 0, PresetColor.CHARTREUSE);
//            solidFillSeries(data, 1, PresetColor.TURQUOISE);
//            solidFillSeries(data, 2, PresetColor.BLACK);
//            solidFillSeries(data, 3, PresetColor.BLUE);
//            solidFillSeries(data, 4, PresetColor.GRAY);

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\10619730\\Desktop\\New folder\\test.xlsx")) {
                wb.write(fileOut);
            }

            return "charttest";
        }

    }
    private static void solidFillSeries (XDDFChartData data,int index, PresetColor color){
        XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
        XDDFChartData.Series series = data.getSeries().get(index);
        XDDFShapeProperties properties = series.getShapeProperties();
        if (properties == null) {
            properties = new XDDFShapeProperties();
        }
        properties.setFillProperties(fill);
        series.setShapeProperties(properties);
    }
}
