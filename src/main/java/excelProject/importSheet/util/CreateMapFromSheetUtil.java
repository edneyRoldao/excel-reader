package excelProject.importSheet.util;

import excelProject.importSheet.model.SpreadsheetMap;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author edneyroldao
 * @since 22/12/2017
 */
public class CreateMapFromSheetUtil {

    private static DataFormatter formatter = new HSSFDataFormatter();

    /**
     *
     * @param sheet a planilha
     * @return verdadeiro se existe colunas do header em branco entre a primeira e última coluna
     *         da planilha.
     */
    public static boolean isThereColumnsEmptyBetweenColumnsFulfilled(Sheet sheet) {
        int lastColumnNumber = sheet.getRow(0).getLastCellNum();

        while(formatter.formatCellValue(sheet.getRow(0).getCell(lastColumnNumber)).isEmpty())
            lastColumnNumber--;

        for(int i = 0; i < lastColumnNumber; i++) {
            if(formatter.formatCellValue(sheet.getRow(0).getCell(i)).equals(""))
                return true;
        }

        return false;
    }

    /**
     *
     * @param sheet a planilha
     * @return verifica se o header da planilha está vazio.
     */
    public static boolean isRowHeaderEmpty(Sheet sheet, int header) {
        Row row = sheet.getRow(header);

        if(row == null || row.getPhysicalNumberOfCells() == 0)
            return true;

        for(int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            if(cell != null && !formatter.formatCellValue(cell).isEmpty())
                return false;
        }

        return true;
    }

    /**
     * Para que os objetos que irão representar os dados sejam construídos corretamente,
     * é necessário que a lista com os dados sejam iguais, mesmo que o cada na planilha
     * esteja em branco.
     *
     * @param dataMap a planilha
     * @return verdadeiro se as lista com os dados de cada coluna possui o mesmo tamanho.
     */
    public static boolean hasRowsSameNumberOfData(Map<String, List<SpreadsheetMap>> dataMap) {
        int i = 0;
        int listSizeCache = 0;
        Set<String> keys = dataMap.keySet();

        for(String key : keys) {
            int listSize = dataMap.get(key).size();

            if(i == 0)
                listSizeCache = listSize;

            if(listSizeCache != listSize)
                return false;

            i++;
        }

        return true;
    }


}
