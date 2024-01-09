package RUC;

import excel.GeneracionEstilos;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusquedaRucDniGlobal {

    public void AsignarRUC(XSSFRow row, WebDriver driver) {
        //Insertando valores de RUC, DNI, APELLIDO Y NOMBRE
        XSSFCell RUC = row.getCell(2);

        BusquedaRuc2xxx busquedaRuc2xxx=new BusquedaRuc2xxx();
        BusquedaRuc1xxx busquedaRuc1xxx=new BusquedaRuc1xxx();


        driver.get("https://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/FrameCriterioBusquedaWeb.jsp");


        if (RUC != null) {
            double rucValue = RUC.getNumericCellValue();
            String rucString = String.format("%.0f", rucValue);
            //Búsqueda por RUC - 2XXXXXXXXXX
            if (rucString.length() == 11 && rucString.charAt(0) == '2') {
                busquedaRuc2xxx.AsignarRUC2xxx(row,driver,rucString);
            }
            if (rucString.length() == 11 && rucString.charAt(0) == '1') {
                busquedaRuc1xxx.AsignarRUC1xxx(row,driver,rucString);
            }
        } else {
            // Manejo si la celda RUC es null
            System.out.println("test");
        }
    }
}
