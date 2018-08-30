package excelProject.importSheet.exception;

/**
 * @author edneyroldao
 * @since 22/12/2017
 */
public class SpreadsheetMirrorFormatException extends SpreadsheetException {
    private static final long serialVersionUID = 1L;

    private static final String MESSAGE = "Formato do Objeto x Formato da planilha é inconsistente!";

    public SpreadsheetMirrorFormatException(String message) {
        super(MESSAGE + " : " + message);
    }

}
