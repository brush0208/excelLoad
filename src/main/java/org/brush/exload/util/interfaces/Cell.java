package org.brush.exload.util.interfaces;

import org.brush.exload.util.CType;

public interface Cell {
    String getName();
    int getColumn();
    CType getCType();
    void setName(String name);
    void setColumn(int column);
    void setCType(CType type);
}
