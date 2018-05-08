import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.brush.exload.util.CType;
import org.brush.exload.util.interfaces.Cell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {

    private  File excel=new File("D:\\excelTest.xls");

    private Workbook workbook;
    @Before
    public void setUp() throws IOException, InvalidFormatException {
        FileInputStream fileInputStream = new FileInputStream(excel.getAbsolutePath());
        workbook=new HSSFWorkbook(fileInputStream);
        WorkbookFactory.create(excel);
    }

    @After
    public void clear()
    {

    }
    @Test
    public void testCell() throws Exception {
        Sheet sheetAt = workbook.getSheetAt(0);
        ArrayList<Cell> excelCells = new ArrayList<>();
        excelCells.add(new ExcelCell("name",1, CType.STRING));
        excelCells.add(new ExcelCell("id",0, CType.INTE));
        excelCells.add(new ExcelCell("date",2, CType.DATE));
        ExcelRow<TestExcelBean> testExcelBeanExcelRow = new ExcelRow<TestExcelBean>(excelCells,sheetAt,TestExcelBean.class);
        //List<TestExcelBean> excelBean = testExcelBeanExcelRow.parse();
        testExcelBeanExcelRow.getgClass();
    }
}
