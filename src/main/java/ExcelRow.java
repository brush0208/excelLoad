import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.brush.exload.util.BaseRowBuilder;
import org.brush.exload.util.CType;
import org.brush.exload.util.interfaces.RowBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 汉清
 * @date 2018-05-04
 * @param <T>
 */
public class ExcelRow<T>  extends BaseRowBuilder<T>{

    private List<ExcelCell> Cells;
    private Sheet sheet;

    public ExcelRow(List<org.brush.exload.util.interfaces.Cell> cells, Sheet sheet,Class clzz) {
        super(cells, sheet,clzz);
    }


    @Override
    public T getCellBean(org.brush.exload.util.interfaces.Cell cell, CType type) {
        return null;
    }

    public List<T> parse() throws Exception {
        int firstRowNum = sheet.getFirstRowNum()+1;
        int lastRowNum = sheet.getLastRowNum();
        if(lastRowNum<=1)
            return new ArrayList<T>(0);
        List<T> resultList=new ArrayList<T>(sheet.getLastRowNum());
        Iterator<Row> rowIterator = sheet.rowIterator();
        if(rowIterator.hasNext())//跳过第一行标题行；
            rowIterator.next();
        while (rowIterator.hasNext())
        {

            T cellBean = getCellBean(rowIterator.next());
            resultList.add(cellBean);
        }
        return resultList;
    }
    private T getCellBean(Row row) throws Exception {

        Class < T >  clzz  =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        T instance = (T)clzz.newInstance();

        for(ExcelCell cell:Cells)
        {
            Field field = clzz.getDeclaredField(cell.getName());
            field.setAccessible(true);
            Cell cell1 = row.getCell(cell.getColumn());
            Object cellValue = cell.getCType().getCellValue(cell1);
            field.set(instance,cellValue);
        }

        return instance;
    }
    public void getgClass() throws IllegalAccessException, InstantiationException {
      //  Class < T >  entityClass  =  (Class < T > )  ;
      //  T instance = (T)clzz.newInstance();
        System.out.println(getClass().getGenericSuperclass());
    }
}
