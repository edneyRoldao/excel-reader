package excelProject.importSheet.model;

public class UnknownField {

    private String columnName;
    private String columnValue;

    public UnknownField(String columnName, String columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnValue() {
        return columnValue;
    }

}
