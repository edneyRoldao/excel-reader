package excelProject.importSheet.service;

import excelProject.importSheet.annotation.SpreadsheetField;
import excelProject.importSheet.annotation.SpreadsheetFieldRequired;
import excelProject.importSheet.exception.SpreadsheetException;
import excelProject.importSheet.exception.SpreadsheetFormatException;
import excelProject.importSheet.exception.SpreadsheetMirrorFormatException;
import excelProject.importSheet.interfaces.ImportSpreadsheetService;
import excelProject.importSheet.mirror.SpreadsheetMirror;

import static excelProject.importSheet.util.ImporterSheetUtil.*;
import static excelProject.importSheet.util.CreateMapFromSheetUtil.*;

import excelProject.importSheet.model.SpreadsheetMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author edneyroldao
 * @since 22/12/2017
 */
public class SpreadsheetImporter implements ImportSpreadsheetService {

    private DataFormatter formatter;

    public SpreadsheetImporter() {
        formatter = new DataFormatter();
    }

    @Override
    public List<SpreadsheetMirror> importSheet(Sheet sheet, Class<? extends SpreadsheetMirror> clazz) throws SpreadsheetException {
        Field field;
        List<SpreadsheetMirror> list = new ArrayList<>();
        Map<String, List<SpreadsheetMap>> map = createMapFromSheet(sheet);

        Set<String> keys = map.keySet();
        int rows = map.get(map.keySet().iterator().next()).size();

        for(int i = 0; i < rows; i++) {
            SpreadsheetMirror spreadMirrorObj;

            try {
                spreadMirrorObj = clazz.newInstance();

            } catch (InstantiationException | IllegalAccessException e) {
                String err = "Houve um erro. Não foi possível instanciar a classe: " + clazz.getName();
                throw new SpreadsheetMirrorFormatException(err);
            }

            for(String key : keys) {
                Method method = findSetMethodByMapKey(clazz, key);
                SpreadsheetMap ssm = map.get(key).get(i);
                String dataFromSheet = ssm.getValue();

                String fieldName = getterOrSetterNameToClassFieldName(method);

                try {
                    field = clazz.getDeclaredField(fieldName);

                } catch (NoSuchFieldException e) {
                    String err = "não foi encontrado o atributo de classe para o método: " + method.getName();
                    throw new SpreadsheetMirrorFormatException(err);
                }

                if(field.isAnnotationPresent(SpreadsheetFieldRequired.class) && dataFromSheet.isEmpty()) {
                    spreadMirrorObj.getErrors().put(key, "campo obrigatório está vazio");
                }

                try {
                    method.invoke(spreadMirrorObj, dataFromSheet);

                } catch (IllegalAccessException | InvocationTargetException e) {
                    String err = "Houve um erro ao tentar setar um valor na objeto que reflete a planilha a partir de um Map";
                    throw new SpreadsheetFormatException(err);
                }
            }

            if(spreadMirrorObj.isNotEmpty())
                list.add(spreadMirrorObj);
        }

        return list;
    }

    private Map<String, List<SpreadsheetMap>> createMapFromSheet(Sheet sheet) throws SpreadsheetFormatException {
        if(isFirstRowEmpty(sheet))
            throw new SpreadsheetFormatException("O cabeçalho está vazio.");

        if(isThereColumnsEmptyBetweenColumnsFulfilled(sheet))
            throw new SpreadsheetFormatException("Existem colunas do cabeçalho em branco entre colunas preenchidas.");

        int lastColumnNumber = sheet.getRow(0).getLastCellNum() + 1;
        while(formatter.formatCellValue(sheet.getRow(0).getCell(lastColumnNumber)).isEmpty()) {
            lastColumnNumber--;
        }

        Map<String, List<SpreadsheetMap>> map = new HashMap<>();
        int lastRowNumber = sheet.getLastRowNum() + 1;

        if(lastColumnNumber > 1000) {
            String err = "A última linha encontrada com valor ultrapassa"   +
                         " o limite de 1000. Número da linha na planilha: " + lastColumnNumber;
            throw new SpreadsheetFormatException(err);
        }

        for(int i = 0; i <= lastColumnNumber; i++) {
            List<SpreadsheetMap> ls = new ArrayList<>();

            for(int j = 0; j <= lastRowNumber; j++) {
                if(sheet.getRow(j) == null || sheet.getRow(j).getCell(i) == null) {
                    ls.add(new SpreadsheetMap(j, i, ""));
                }else {
                    String cellValue = formatter.formatCellValue(sheet.getRow(j).getCell(i));
                    ls.add(new SpreadsheetMap(j, i, cellValue));
                }
            }

            map.put(ls.get(0).getValue(), ls.subList(1, ls.size() - 1));
        }

        if(!hasRowsSameNumberOfData(map)) {
            String msg = "O tamanho das listas no map estão difirentes entre si, porém devem ser iguais.";
            throw new SpreadsheetFormatException(msg);
        }

        return map;
    }

    private Method findSetMethodByMapKey(Class<?> clazz, String key) throws SpreadsheetMirrorFormatException {
        for(Method m : clazz.getDeclaredMethods()) {
            if(isNotSetterMethod(m))
                continue;

            String paramClassName = m.getParameterTypes()[0].getName();

            if(!paramClassName.equals("java.lang.String")) {
                String err = "Atributo de classe inválido. Os atributos que armazenam" +
                             " os dados dos campos da planilha devem ser do tipo" +
                             " java.lang.String. Tipo encontrado: " + paramClassName;
                throw new SpreadsheetMirrorFormatException(err);
            }

            Field field;
            String fieldName = getterOrSetterNameToClassFieldName(m);

            try {
                field = clazz.getDeclaredField(fieldName);

            } catch (NoSuchFieldException e) {
                String err = "não foi encontrado o atributo de classe para o método: " + m.getName();
                throw new SpreadsheetMirrorFormatException(err);
            }

            if(field.isAnnotationPresent(SpreadsheetField.class)) {
                String value = field.getAnnotation(SpreadsheetField.class).name();

                if(treatTextToCompare(key).equals(treatTextToCompare(value)))
                    return m;
                else
                    continue;
            }

            if(treatTextToCompare(key).equals(treatTextToCompare( m.getName().substring(3) )))
                return m;
        }

        String err = "Não foi encontrado nenhum método set compatível para a columa: " + key +
                     ". Verifique se existe algum atributo de classe no objeto que guarda os" +
                     " dados da planilha que não seja do tipo java.lang.String.";
        throw new SpreadsheetMirrorFormatException(err);
    }

}
