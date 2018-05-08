/**
 * @author 汉清
 * 2018-05-04
 *
 */
import org.brush.exload.util.CType;
import org.brush.exload.util.interfaces.Cell;

public class ExcelCell implements Cell{
    private String name;
    private int column;
    private CType CType;

    public ExcelCell(String name, int column, CType type) {
        this.name = name;
        this.column = column;
        this.CType = type;
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

    public CType getCType() {
        return CType;
    }

    public void setCType(CType CType) {
        this.CType = CType;
    }

    /**
     * 默认类型为<code>String</code><class>String</class>
     * @param name
     * @param column
     */
   /* public ExcelCell(String name, int column) {
        this(name,column, CType.STRING);
    }*/



}
