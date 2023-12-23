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
        StringBuilder ApellidoNombre= new StringBuilder();

        WebElement fullNameElement = null, ApellidoPaternoElement = null, ApellidoMaternoElement = null, NombresElement = null;
        try {
            fullNameElement = driver.findElement(By.id("completos"));
            ApellidoPaternoElement = driver.findElement(By.id("apellidop"));
            ApellidoMaternoElement = driver.findElement(By.id("apellidom"));
            NombresElement = driver.findElement(By.id("nombres"));

        } catch (org.openqa.selenium.NoSuchElementException e) {
            // El elemento no está presente
        }
        XSSFCell cellFullName = row.createCell(7);
        XSSFCell cellLastName = row.createCell(1);

        if (fullNameElement != null && fullNameElement.isDisplayed()) {
            fullName = fullNameElement.getAttribute("value");
            assert ApellidoPaternoElement != null;
            assert ApellidoMaternoElement != null;
            assert NombresElement != null;
            ApellidoNombre.append(ApellidoPaternoElement.getAttribute("value")).append(" ").append(ApellidoMaternoElement.getAttribute("value")).append(" ").append(NombresElement.getAttribute("value"));
            cellLastName.setCellValue(ApellidoNombre.toString());
            cellFullName.setCellValue(fullName);
        } else {
            CellStyle orangeCellStyle = cellFullName.getSheet().getWorkbook().createCellStyle();
            orangeCellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            orangeCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellFullName.setCellStyle(orangeCellStyle);
            cellLastName.setCellStyle(orangeCellStyle);
            cellFullName.setCellValue(NOMBRECOMPLETO.getStringCellValue());
            cellLastName.setCellValue(NOMBRECOMPLETO.getStringCellValue());
        }
    }
}