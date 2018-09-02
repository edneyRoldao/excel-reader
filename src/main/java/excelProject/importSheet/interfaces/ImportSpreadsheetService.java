package excelProject.importSheet.interfaces;

import excelProject.importSheet.exception.SpreadsheetException;
import excelProject.importSheet.mirror.SpreadsheetMirror;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Classe que abstrai a implementação da importação da planilha no import massivo.
 *
 * @author edneyroldao
 * @since 22/12/2017
 */
public interface ImportSpreadsheetService {

    List<SpreadsheetMirror> importSheet(Sheet sheet, int rowHeader, Class<? extends  SpreadsheetMirror> clazz) throws SpreadsheetException;


}
