import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author chenhao.ych
 * @date 2018-07-15
 */
public class PoiUtils {


    public static void write(File file, String name, String phone, String address) throws Exception {
        Workbook workbook = new XSSFWorkbook(new FileInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);
        CellStyle cellStyle = workbook.createCellStyle();
        // 设置这些样式
        cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (sheet.getRow(i) == null) {
                Row row = sheet.createRow(i);
                row.createCell(0).setCellStyle(cellStyle);
                row.createCell(0).setCellValue(name);

                row.createCell(1).setCellStyle(cellStyle);
                row.createCell(1).setCellValue(phone);

                row.createCell(2).setCellStyle(cellStyle);
                row.createCell(2).setCellValue(address);
            }
        }
        FileOutputStream fileoutputStream = new FileOutputStream(file);
        workbook.write(fileoutputStream);
        fileoutputStream.close();
    }


    public static void write(List<FuzhouRepoPageProcessor.Man> list) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");
        Row row = sheet.createRow(0);
        CellStyle cellStyle = workbook.createCellStyle();
        // 设置这些样式
        cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        row.createCell(0).setCellStyle(cellStyle);
        row.createCell(0).setCellValue("企业名");

        row.createCell(1).setCellStyle(cellStyle);
        row.createCell(1).setCellValue("电话");

        row.createCell(2).setCellStyle(cellStyle);
        row.createCell(2).setCellValue("地址");
        workbook.setSheetName(0, "数据");

        for (int i = 1; i < list.size(); i++) {
            Row row1 = sheet.createRow(i);
            FuzhouRepoPageProcessor.Man man = list.get(i);
            row1.createCell(0).setCellStyle(cellStyle);
            row1.createCell(0).setCellValue(man.getName());

            row1.createCell(1).setCellStyle(cellStyle);
            row1.createCell(1).setCellValue(man.getPhone());

            row1.createCell(2).setCellStyle(cellStyle);
            row1.createCell(2).setCellValue(man.getAddress());
        }


        try {
            File file = new File("/Users/chenhaoye/data1.xlsx");
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
