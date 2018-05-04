package org.brush.exload.util.interfaces;

import org.brush.exload.util.CType;

import java.util.List;

/**
 * @author 汉清
 * @param <T> 对应Bean实际类型
 */
public interface RowBuilder<T> {
    //static E <E>getCellBean(Cell cell, CType type);
    T getCellBean(Cell cell, CType type);
    List<T> parse() throws Exception;
}
