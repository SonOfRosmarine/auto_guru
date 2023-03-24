package reader;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader {

    private ClassLoader classLoader = ZipReader.class.getClassLoader();


    @Test
    @DisplayName("Чтение pdf файла из архива zip")
    void parsingPdf() throws Exception {
        try (InputStream testZip = classLoader.getResourceAsStream("zip/test.zip");
             ZipInputStream zm = new ZipInputStream(testZip)) {
            ZipEntry sorce;
            while ((sorce = zm.getNextEntry()) != null) {
                if (sorce.getName().equals("test-pdf.pdf")) {
                    PDF pdf = new PDF(zm);
                    Assertions.assertTrue(sorce.getName().contains("test-pdf.pdf"));
                    Assertions.assertEquals("Charles A. Bliley", pdf.author);
                }
            }
        }

    }

    @Test
    @DisplayName("Чтение csv файла из архива zip")
    void parsingCsv() throws Exception {
        try (InputStream testZip = classLoader.getResourceAsStream("zip/test.zip");
             ZipInputStream zm = new ZipInputStream(testZip)) {
            ZipEntry sorce;
            while ((sorce = zm.getNextEntry()) != null) {
                if (sorce.getName().equals("test.csv")) {
                    CSVReader csv = new CSVReader (new InputStreamReader(zm));
                    List<String[]> csvRow = csv.readAll();
                    Assertions.assertTrue(sorce.getName().contains("test.csv"));
                    Assertions.assertArrayEquals(new String[]{"James","Butt","Benton, John B Jr","6649 N Blue Gum St","New Orleans","Orleans","LA","70116",
                    "504-621-8927","504-845-1427","jbutt@gmail.com","http://www.bentonjohnbjr.com"},csvRow.get(1));
                }
            }
        }

    }
    @Test
    @DisplayName("Чтение xls файла из архива zip")
    void parsingXls() throws Exception {
        try (InputStream testZip = classLoader.getResourceAsStream("zip/test.zip");
             ZipInputStream zm = new ZipInputStream(testZip)) {
            ZipEntry sorce;
            while ((sorce = zm.getNextEntry()) != null) {
                if (sorce.getName().equals("sample3.xlsx")) {
                    XLS xls = new XLS(zm);
                    Assertions.assertTrue(sorce.getName().contains("sample3.xlsx"));
                    Assertions.assertTrue(
                            xls.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue()
                                    .startsWith("March")
                    );
                }
            }
        }

    }

}
