package RUC;

import excel.GeneracionEstilos;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusquedaRuc2xxx {

    public void AsignarRUC2xxx(XSSFRow row, WebDriver driver, String rucString) {
        //Insertando valores de RUC, DNI, APELLIDO Y NOMBRE
        XSSFCell APELLIDONOMBRE = row.getCell(1);
        XSSFCell NOMBRECONSULTADO = row.getCell(7);
        GeneracionEstilos generacionEstilos = new GeneracionEstilos();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebDriverWait alertMessage = new WebDriverWait(driver, 5);
        WebElement inputElementPorRUC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtRuc")));
        inputElementPorRUC.clear();
        inputElementPorRUC.sendKeys(rucString);
        WebElement buttonAceptarPorRuc = driver.findElement(By.id("btnAceptar"));
        buttonAceptarPorRuc.click();

        try {
            alertMessage.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            generacionEstilos.StyleDocNoExiste(row);
        } catch (TimeoutException e) {
            WebElement nombreRazonSocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/h4")));
            String elementText = nombreRazonSocial.getText().substring(14);
            APELLIDONOMBRE.setCellValue(elementText);
            NOMBRECONSULTADO.setCellValue(elementText);
            generacionEstilos.StyleValidadoRUC2xxx(row);
        }
    }

}
