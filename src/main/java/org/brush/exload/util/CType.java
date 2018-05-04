package org.brush.exload.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.util.Date;

/**
 * @author 汉清
 * @date 2018-05-04
 * 单元格对应常用类型，并提供从excelCell中取出对应类型的值方法<code>getCellValue</code>
 */
public enum CType {
    STRING(String.class){public  CellType getCellType(){return CellType.STRING;}
        public Object getCellValue(Cell cell){cell.setCellType(this.getCellType());return cell.getStringCellValue();}},
    DATE(Date.class){public CellType getCellType(){return CellType.NUMERIC;}
        public Object getCellValue(Cell cell){return cell.getDateCellValue();}},
    INTE(Integer.class){public CellType getCellType(){return CellType.NUMERIC;}
        public Object getCellValue(Cell cell){return Double.valueOf(cell.getNumericCellValue()).intValue();}},
    DOUBLE(Double.class){public CellType getCellType(){return CellType.NUMERIC;}
        public Object getCellValue(Cell cell){return cell.getNumericCellValue();}};
    CType(Class<?> clzz) {
        this.clzz = clzz;
    }
    Class<?> clzz;
    public Class<?> getClzz(){return clzz;}

    public abstract CellType getCellType();
    public abstract Object getCellValue(Cell cell);
}
