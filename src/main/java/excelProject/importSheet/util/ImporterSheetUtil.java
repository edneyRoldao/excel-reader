package excelProject.importSheet.util;

import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Method;

/**
 * @author edneyroldao
 * @since 22/12/2017
 */
public class ImporterSheetUtil {

    /**
     * @param method deve ser um método setter ou getter.
     * @return retorna o nome do atributo de classe correspondente ao método
     *         get ou set passado como parâmetro.
     */
    public static String getterOrSetterNameToClassFieldName(Method method) {
        String name = method.getName();
        name = name.substring(3);
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
        return name;
    }

    /**
     * Esté método auxília a comparação dos valores dos Headers da planilha
     * com os atributos de classe que irão armazenar os dados correspondentes ao header em questão.
     *
     * @param text texto que terá seus caractéres especiais e espaços removidos e transformados
     *             em caixa baixa.
     * @return texto formatado sem caractéres especiais, espaços e em caixa baixa.
     */
    public static String treatTextToCompare(String text) {
        text = StringUtils.deleteWhitespace(text);
        text = text.toLowerCase()
                .replace((char)231, 'c')
                .replace((char)227, 'a')
                .replace((char)225, 'a')
                .replace((char)226, 'a')
                .replace((char)233, 'e')
                .replace((char)237, 'i')
                .replace((char)243, 'o')
                .replace((char)245, 'o')
                .replace((char)250, 'u');

        text = text.replaceAll("[^A-Za-z0-9]", "");

        return text;
    }

    public static boolean isGetter(Method m) {
        return m.getReturnType() != void.class  &&
               m.getParameterCount() == 0       &&
               m.getName().startsWith("get");
    }

    /**
     *
     * @param method qualquer metodo da classe java.reflect
     * @return se o método passado como argumento é um getter ou setter.
     */
    public static boolean isSetterMethod(Method method) {
        return method.getReturnType() == void.class &&
                method.getParameterCount() == 1      &&
                method.getName().startsWith("set");
    }

    public static boolean isNotSetterMethod(Method method) {
        return !isSetterMethod(method);
    }

}
