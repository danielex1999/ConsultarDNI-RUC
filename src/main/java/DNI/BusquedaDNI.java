package DNI;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusquedaDNI {


    public String AsignarNombreCompleto(XSSFCell DNI, XSSFRow row, WebDriver driver) {

        String valorDNI = "";

        if (DNI != null && DNI.getCellType() != CellType.BLANK) {
            valorDNI = DNI.getStringCellValue();

            if (valorDNI == null || valorDNI.trim().isEmpty()) {
                valorDNI = "---";
            } else {
                if (valorDNI.length() != 8 && valorDNI.length() > 1) {
                    valorDNI = String.format("%08d", Integer.parseInt(valorDNI));
                }
            }
        } else {
            DNI = row.createCell(3);
            DNI.setCellValue("---");
        }

        DNI.setCellValue(valorDNI);
        driver.get("https://eldni.com/pe/buscar-datos-por-dni");
        WebElement inputElement = driver.findElement(By.id("dni"));
        inputElement.clear();
        inputElement.sendKeys(valorDNI);
        WebElement buttonElement = driver.findElement(By.id("btn-buscar-datos-por-dni"));
        buttonElement.click();

        String fullName = "";

        WebElement fullNameElement = null;
        try {
            fullNameElement = driver.findElement(By.id("completos"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // El elemento no está presente
        }

        if (fullNameElement != null && fullNameElement.isDisplayed()) {
            fullName = fullNameElement.getAttribute("value");
            XSSFCell cellFullName = row.createCell(7);
            cellFullName.setCellValue(fullName);
            return fullName;
        } else {
            XSSFCell cellFullName = row.createCell(7);
            cellFullName.setCellValue("No se encontró el número de DNI");
            return null;
        }
    }
}



