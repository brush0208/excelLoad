package org.brush.exload.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.brush.exload.util.interfaces.Cell;
import org.brush.exload.util.interfaces.RowBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRowBuilder <T> implements RowBuilder<T> {
    protected List<Cell> Cells = new ArrayList<>();
    protected Sheet sheet;
    protected Class<T> clzz;

    public BaseRowBuilder(List<Cell> cells, Sheet sheet,Class clzz) {
        Cells = cells;
        this.sheet = sheet;
        this.clzz=clzz;
    }


    public T getCellBean(Cell cell, CType type) {
        return null;
    }
    public List<T> parse() throws Exception {
        return null;
    }
    private T getCellBean(Row row) throws Exception {


        T instance = (T)clzz.newInstance();

        for(Cell cell:Cells)
        {
            Field field = clzz.getDeclaredField(cell.getName());
            field.setAccessible(true);
            org.apache.poi.ss.usermodel.Cell cell1 = row.getCell(cell.getColumn());
            Object cellValue = cell.getCType().getCellValue(cell1);
            field.set(instance,cellValue);
        }

        return instance;
    }
}
