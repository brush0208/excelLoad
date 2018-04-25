import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;

import java.util.Date;

public class ExcelCell {
    private String name;
    private int column;
    private Type type;

    public ExcelCell(String name, int column, Type type) {
        this.name = name;
        this.column = column;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * 默认类型为<code>String</code><class>String</class>
     * @param name
     * @param column
     */
    public ExcelCell(String name, int column) {
        this(name,column,Type.STRING);
    }
    public enum Type{
        STRING(String.class){ int getCellType(){return HSSFCell.CELL_TYPE_STRING;}
                                Object getCellValue(Cell cell){return cell.getStringCellValue();}},
        DATE(Date.class){int getCellType(){return HSSFCell.CELL_TYPE_NUMERIC;}
                        Object getCellValue(Cell cell){return cell.getDateCellValue();}},
        INTE(Integer.class){int getCellType(){return HSSFCell.CELL_TYPE_NUMERIC;}
                            Object getCellValue(Cell cell){return Double.valueOf(cell.getNumericCellValue()).intValue();}};
        Type(Class<?> clzz) {
            this.clzz = clzz;
        }
        Class<?> clzz;
        public Class<?> getClzz(){return clzz;}

        abstract int  getCellType();
        abstract Object getCellValue(Cell cell);
    }


}
