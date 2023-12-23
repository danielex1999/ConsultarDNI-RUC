package DNI;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class PercentSimilitud {
    public void PorcentajeSimilitud(XSSFCell NOMBRECOMPLETO, XSSFCell NOMBRECONSULTADO,XSSFCell APELLIDONOMBRE, XSSFRow row ) {
        JaroWinklerSimilarity jaroWinklerSimilarity = new JaroWinklerSimilarity();

        double similitud1ByName = jaroWinklerSimilarity.apply(NOMBRECOMPLETO.getStringCellValue().toLowerCase(),NOMBRECONSULTADO.getStringCellValue().toLowerCase());
        double similitudByLastName = jaroWinklerSimilarity.apply(NOMBRECOMPLETO.getStringCellValue().toLowerCase(),APELLIDONOMBRE.getStringCellValue().toLowerCase());
        double similitud=0.0;
        if (similitud1ByName < similitudByLastName){
            similitud=similitudByLastName;
        }else{
            similitud=similitud1ByName;
        }
        String formattedSimilitud = String.format("%.2f", similitud*100);
        XSSFCell CrearSimilitud = row.createCell(8);
        CrearSimilitud.setCellValue(formattedSimilitud +"%");

        if (similitud < 0.65) {
            CellStyle greyCellStyle = NOMBRECONSULTADO.getSheet().getWorkbook().createCellStyle();
            greyCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
            greyCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            NOMBRECONSULTADO.setCellStyle(greyCellStyle);
            APELLIDONOMBRE.setCellStyle(greyCellStyle);
        }else if (similitud >= 0.65 && similitud <= 0.7) {
            CellStyle greyCellStyle = NOMBRECONSULTADO.getSheet().getWorkbook().createCellStyle();
            greyCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            greyCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            NOMBRECONSULTADO.setCellStyle(greyCellStyle);
            APELLIDONOMBRE.setCellStyle(greyCellStyle);
        }
    }

}
