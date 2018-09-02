package excelProject.importSheet.mirror;

import excelProject.importSheet.annotation.UnknownFieldName;
import excelProject.importSheet.model.UnknownField;
import excelProject.importSheet.util.ImporterSheetUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Toda classe que representa os dados da planilha no import massivo, devem extender esta classe.
 * Podemos criar annotations para representar validações de campos futuras.
 * Os erros nas validações acima devem ser gravados no mapa de erros declarado nessa classe.
 *
 * @author edneyroldao
 * @since 22/12/2017
 */
public abstract class SpreadsheetMirror {

    private Map<String, String> errors;
    private List<UnknownField> unknownFieldsFromColumnHeader;

    public SpreadsheetMirror() {
        errors = new HashMap<>();
        unknownFieldsFromColumnHeader = new ArrayList<>();
    }

    public final Map<String, String> getErrors() {
        return errors;
    }

    public final List<UnknownField> getUnknownFieldsFromColumnHeader() {
        return unknownFieldsFromColumnHeader;
    }

    @UnknownFieldName
    public void addUnknownField(String columnName, String columnValue) {
        unknownFieldsFromColumnHeader.add(new UnknownField(columnName, columnValue));
    }

    public boolean isSpreadsheetObjEmpty() {
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        int countMethods = 0;
        int countEmpty = 0;
        for(Method m : methods) {
            if(ImporterSheetUtil.isGetter(m)) {
                countMethods++;
                try {
                    String obj = (String) m.invoke(this);
                    if(obj.isEmpty())
                        countEmpty++;

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return countMethods == countEmpty;
    }

    public boolean isNotEmpty() {
        return !isSpreadsheetObjEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for(Method m : methods) {
            if(ImporterSheetUtil.isGetter(m)) {
                try {
                    String getterReturnValue = (String) m.invoke(this);
                    String attrName = ImporterSheetUtil.getterOrSetterNameToClassFieldName(m);
                    sb.append(attrName).append(" = ").append(getterReturnValue).append(", ");

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }

        return sb.toString().substring(0, sb.length() - 2);
    }
}
