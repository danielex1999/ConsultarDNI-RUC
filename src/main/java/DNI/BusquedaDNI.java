package DNI;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusquedaDNI {


    public void AsignarNombreCompleto(XSSFCell DNI, XSSFCell NOMBRECOMPLETO, XSSFRow row, WebDriver driver) {

        String valorDNI = "";

        if (DNI != null && DNI.getCellType() != CellType.BLANK) {
            valorDNI = DNI.getStringCellValue();

            if (valorDNI == null || valorDNI.trim().isEmpty()) {
                valorDNI = "---";
            } else {
                if (valorDNI.length() != 8 && valorDNI.length() > 1) {
                    try {
                        int numericValue = Integer.parseInt(valorDNI);
                        valorDNI = String.format("%08d", numericValue);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } else {
            DNI = row.createCell(3);
            valorDNI = "---";
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
        XSSFCell cellFullName = row.createCell(7);
        if (fullNameElement != null && fullNameElement.isDisplayed()) {
            fullName = fullNameElement.getAttribute("value");
            cellFullName.setCellValue(fullName);
        } else {
            CellStyle orangeCellStyle = cellFullName.getSheet().getWorkbook().createCellStyle();
            orangeCellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            orangeCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellFullName.setCellStyle(orangeCellStyle);
            cellFullName.setCellValue(NOMBRECOMPLETO.getStringCellValue());
        }
    }
}