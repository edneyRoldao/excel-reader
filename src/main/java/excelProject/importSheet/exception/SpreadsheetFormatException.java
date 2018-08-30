package excelProject.importSheet.exception;

/**
 * @author edneyroldao
 * @since 22/12/2017
 */
public class SpreadsheetFormatException extends SpreadsheetException {
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "O fomato da planilha é inválido!";
	
	public SpreadsheetFormatException(String message) {
		super(MESSAGE + " : " + message);
	}

}
