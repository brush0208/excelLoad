import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelRow<T>  {

    private List<ExcelCell> Cells;
    private Sheet sheet;

    public ExcelRow(List<ExcelCell> cells,Sheet sheet) {
        Cells = cells;
        this.sheet=sheet;
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

        Class<?> clzz=TestExcelBean.class;
        T instance = (T)clzz.newInstance();

        for(ExcelCell cell:Cells)
        {
            Field field = clzz.getDeclaredField(cell.getName());
            field.setAccessible(true);
            Cell cell1 = row.getCell(cell.getColumn());
            Object cellValue = cell.getType().getCellValue(cell1);
            field.set(instance,cellValue);
        }

        return instance;
    }
}
