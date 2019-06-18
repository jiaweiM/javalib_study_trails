package tutorial.lib.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 19 Apr 2019, 2:25 PM
 */
public class WriterNumbers
{
    @Test
    public void test() throws IOException
    {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("format sheet");
        CellStyle style;
        DataFormat format = wb.createDataFormat();
        Row row;
        Cell cell;
        int rowNum = 0;
        int colNum = 0;

        row = sheet.createRow(rowNum++);
        cell = row.createCell(colNum);
        cell.setCellValue(11111.25);
        style = wb.createCellStyle();
        style.setDataFormat(format.getFormat("0.0"));
        cell.setCellStyle(style);

        row = sheet.createRow(rowNum++);
        cell = row.createCell(colNum);
        cell.setCellValue(11111.25);
        style = wb.createCellStyle();
        style.setDataFormat(format.getFormat("#,##0.0000"));
        cell.setCellStyle(style);

        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        }

        wb.close();
    }

    @Test
    public void test2()
    {
        NumberFormat format = new DecimalFormat("0.0000");
    }
}
