import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws Exception {
       /* Class<TestExcelBean> beanClass = TestExcelBean.class;
        TestExcelBean testExcelBean = beanClass.newInstance();
        Method method = beanClass.getMethod("setName",String.class);
        method.invoke(testExcelBean,"brush");
        System.out.println(testExcelBean.getName());*/
        ArrayList<ExcelCell> excelCells = new ArrayList<ExcelCell>();
        excelCells.add(new ExcelCell("name",1, ExcelCell.Type.STRING));
        excelCells.add(new ExcelCell("id",0,ExcelCell.Type.INTE));
        excelCells.add(new ExcelCell("date",2,ExcelCell.Type.DATE));
        ExcelRow<TestExcelBean> testExcelBeanExcelRow = new ExcelRow<TestExcelBean>(excelCells,null);
        List<TestExcelBean> excelBean = testExcelBeanExcelRow.parse();
        System.out.println(excelBean);

    }
}
