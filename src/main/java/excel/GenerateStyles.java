package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;

public class GenerateStyles {
    public void FilaDefaultStyle() {

    }

    public void StyleNoExisteBusquedaPorRUC(XSSFRow row, WebDriver driver) {
        XSSFCell Status = row.getCell(4);

        CellStyle noExisteStyle = row.getSheet().getWorkbook().createCellStyle();
        noExisteStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        noExisteStyle.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        noExisteStyle.setAlignment(HorizontalAlignment.CENTER);
    }

    public void StyleBusquedaPorRUC(XSSFRow row, WebDriver driver) {
        XSSFCell APELLIDONOMBRE = row.getCell(1);
        XSSFCell Status = row.getCell(4);
        XSSFCell NOMBRECONSULTADO = row.getCell(7);
        XSSFCell SIMILITUD = row.getCell(8);

        CellStyle normalStyle = row.getSheet().getWorkbook().createCellStyle();
        normalStyle.setFillPattern(FillPatternType.NO_FILL);

        CellStyle validadoStyle = row.getSheet().getWorkbook().createCellStyle();
        validadoStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        validadoStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());
        validadoStyle.setAlignment(HorizontalAlignment.CENTER);

        APELLIDONOMBRE.setCellStyle(normalStyle);
        NOMBRECONSULTADO.setCellStyle(normalStyle);
        Status.setCellStyle(validadoStyle);
        SIMILITUD.setCellStyle(normalStyle);
    }
}
