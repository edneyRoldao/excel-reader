package excelProject.importSheet.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Quando uma coluna da planilha do import massivo for obrigatório, basta
 * anotar o campo que representa os valores da planilha com esta annotation.
 *
 * Se o campo não estiver preenchido, será adicionado um erro na lista de erros da classe abaixo:
 * @see  excelProject.importSheet.mirror.SpreadsheetMirror
 *
 * @author edneyroldao
 * @since 22/12/2017
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface UnknownFieldName {
}
