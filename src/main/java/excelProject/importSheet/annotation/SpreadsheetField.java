package excelProject.importSheet.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Utilizando essa annotation nos atributos da classe que representa a planilha do import massivo,
 * o nome do atributo de classe será ignorado e o valor presente na annotation será considerado
 * para comparação com o nome da coluna da planilha.
 *
 * @author edneyroldao
 * @since 22/12/2017
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SpreadsheetField {
    String name();
}
