package excelProject.importSheet.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import excelProject.importSheet.mirror.SpreadsheetMirror;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import excelProject.importSheet.exception.SpreadsheetException;
import excelProject.importSheet.interfaces.ImportSpreadsheetService;
import excelProject.importSheet.mirror.NewProductSheet;
import excelProject.importSheet.service.SpreadsheetImporter;

public class Test {

	public static void main(String[] args) throws InvalidFormatException, IOException, SpreadsheetException {
		File file = new File("/Users/edneyroldao/Documents/diversos/testeNovaImplementacao.xlsx");
		Workbook workbook = WorkbookFactory.create(file);		
		Sheet sheet = workbook.getSheetAt(0);
		ImportSpreadsheetService service = new SpreadsheetImporter();
		
		List<SpreadsheetMirror> ls = service.importSheet(sheet, 0, NewProductSheet.class);

		ls.forEach(ssm -> System.out.println(( ssm.toString())));
		System.out.println("total linhas: " + ls.size());
	}

}
