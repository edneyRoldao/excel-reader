package excelProject.importSheet.model;

public class SpreadsheetMap {

    private int row;
    private int column;
    private String value;

    public SpreadsheetMap(int row, int column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SpreadsheetMap{" +
                "row=" + row +
                ", column=" + column +
                ", value='" + value + '\'' +
                '}';
    }
}
