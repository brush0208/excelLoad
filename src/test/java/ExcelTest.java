import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {

    private  File excel=new File("D:\\excelTest.xls");

    private Workbook workbook;
    @Before
    public void setUp() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(excel.getAbsolutePath());
        workbook=new HSSFWorkbook(fileInputStream);
    }

    @After
    public void clear()
    {

    }
    @Test
    public void testCell() throws Exception {
        Sheet sheetAt = workbook.getSheetAt(0);
        ArrayList<ExcelCell> excelCells = new ArrayList<ExcelCell>();
        excelCells.add(new ExcelCell("name",1, ExcelCell.Type.STRING));
        excelCells.add(new ExcelCell("id",0,ExcelCell.Type.INTE));
        excelCells.add(new ExcelCell("date",2,ExcelCell.Type.DATE));
        ExcelRow<TestExcelBean> testExcelBeanExcelRow = new ExcelRow<TestExcelBean>(excelCells,sheetAt);
        List<TestExcelBean> excelBean = testExcelBeanExcelRow.parse();
    }
}
