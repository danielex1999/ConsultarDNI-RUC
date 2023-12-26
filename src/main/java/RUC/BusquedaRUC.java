package RUC;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusquedaRUC {

    public void AsignarRUC(XSSFCell DNI, XSSFCell APELLIDONOMBRE, XSSFCell RUC,XSSFRow row, WebDriver driver){
        String valorRUC="";
        driver.get("https://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/FrameCriterioBusquedaWeb.jsp");
        //Por Ruc
        double rucValue = RUC.getNumericCellValue();
        String rucString = String.format("%.0f", rucValue);

        if(rucString.length() == 11 && rucString.charAt(0) == '2'){
            WebElement inputElementPorRUC = driver.findElement(By.id("txtRuc"));
            inputElementPorRUC.clear();
            inputElementPorRUC.sendKeys(rucString);
            WebElement buttonAceptarPorRuc = driver.findElement(By.id("btnAceptar"));
            buttonAceptarPorRuc.click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/h4")));
            String elementText = element.getText();
            System.out.println("Text of the element: " + elementText);
        }
    }
}
