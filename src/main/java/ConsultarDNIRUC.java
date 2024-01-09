/**
 * Consultar DNI - RUC
 * Excel para asignar los datos del DNI, RUC y validación
 *
 * @author Juan Daniel Cavero Tovar
 * @version 0.0.1, 2023/08/12
 */

import DNI.BusquedaDNI;
import excel.PorcentajeSimilitud;
import RUC.BusquedaRucDniGlobal;
import excel.GeneracionCampos;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ConsultarDNIRUC {

    public static void main(String[] args) throws IOException, InterruptedException {
        //Declaración de variables
        String rutaChromeDriver = "C:\\Users\\danie\\Documents\\chromedriver.exe";
        String rutaExcel = "C:\\Users\\danie\\OneDrive\\Escritorio\\CONSULTA RUC 1912.xlsx";
        int filaInicio = 2, filaFinal = 140;
        //XSSFCell RUC, DNI, STATUS, NOMBRECOMPLETO, NOMBRECONSULTADO, SIMILITUD, APELLIDONOMBRE;
        BusquedaDNI busquedaDNI = new BusquedaDNI();
        PorcentajeSimilitud porcentajeSimilitud = new PorcentajeSimilitud();
        GeneracionCampos generacionCampos = new GeneracionCampos();
        BusquedaRucDniGlobal busquedaRUC = new BusquedaRucDniGlobal();

        FileInputStream fis = new FileInputStream(rutaExcel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        generacionCampos.CreacionCeldaFila(sheet);
        System.setProperty("webdriver.chrome.driver", rutaChromeDriver);
        WebDriver driver = new ChromeDriver();


        for (int i = filaInicio; i <= filaFinal; i++) {
            XSSFRow row = sheet.getRow(i - 1);
            row.createCell(4, CellType.STRING);
            busquedaDNI.AsignarNombreCompleto(row, driver);
            porcentajeSimilitud.PorcentajeSimilitud(row);
            busquedaRUC.AsignarRUC(row, driver);
            System.out.println("Se registro correctamente la fila " + i);
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

