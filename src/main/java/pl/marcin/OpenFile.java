package pl.marcin;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
public class OpenFile {


    File file;
    FileInputStream fip;


    public OpenFile(String filename) throws Exception{
        file = new File(filename);
        fip = new FileInputStream(file);
        // Getting the workbook instance for XLSX file
        XSSFWorkbook workbook = new XSSFWorkbook(fip);
    }
}
