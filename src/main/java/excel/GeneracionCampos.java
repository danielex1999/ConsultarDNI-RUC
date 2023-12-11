package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class GeneracionCampos {
    public void CreacionCeldaFila(XSSFSheet sheet) {
        XSSFRow row1 = sheet.getRow(0);
        XSSFCell nuevaCelda1 = row1.createCell(7);
        XSSFCell nuevaCelda2 = row1.createCell(8);

        nuevaCelda1.setCellValue("Nombre Consultado (BusquedaDNI)");
        nuevaCelda2.setCellValue("Similitud (%)");

        sheet.setColumnWidth(2, 18 * 256);
        sheet.setColumnWidth(3, 14 * 256);
        sheet.setColumnWidth(4, 18 * 256);
        sheet.setColumnWidth(5, 12 * 256);
        sheet.setColumnWidth(6, 50 * 256);
        sheet.setColumnWidth(7, 50 * 256);
        sheet.setColumnWidth(8, 15 * 256);
    }
}
