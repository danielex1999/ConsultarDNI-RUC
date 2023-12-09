/**
 * Consultar DNI - RUC
 * Excel para asignar los datos del DNI, RUC y validación
 *
 * @author Juan Daniel Cavero Tovar
 * @version 0.0.1, 2023/08/12
 */

import DNI.BusquedaDNI;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ConsultarDNIRUC {

    public static void main(String[] args) throws IOException {
        //Declaración de variables
        String rutaChromeDriver = "C:\\Users\\danie\\Documents\\chromedriver.exe";
        String rutaExcel = "C:\\Users\\danie\\Desktop\\Pruebas.xlsx";
        Integer filaInicio = 2, filaFinal = 10;
        XSSFCell RUC, DNI, STATUS, NOMBRE;
        BusquedaDNI busquedaDNI = new BusquedaDNI();

        FileInputStream fis = new FileInputStream(rutaExcel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.setProperty("webdriver.chrome.driver", rutaChromeDriver);
        WebDriver driver = new ChromeDriver();


        for (int i = filaInicio; i <= filaFinal; i++) {
            XSSFRow row = sheet.getRow(i - 1);
            RUC = row.getCell(2);
            DNI = row.getCell(3);
            STATUS = row.getCell(4);
            NOMBRE = row.getCell(6);
            busquedaDNI.AsignarNombreCompleto(DNI,row,driver);

            saveWorkbook(workbook, rutaExcel);
        }

        workbook.close();
        driver.quit();

    }


    private static void saveWorkbook(XSSFWorkbook workbook, String filePath) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
    }
}

