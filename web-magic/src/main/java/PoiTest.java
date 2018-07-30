import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author chenhao.ych
 * @date 2018-07-15
 */
public class PoiTest {

    public static void main(String[] args) {
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



        try {
            File file = new File("/Users/chenhaoye/data.xlsx");
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //写入Xlsx
//    public static void writeXlsx(String fileName,Map<Integer,List<String[]>> map) {
//        try {
//            XSSFWorkbook wb = new XSSFWorkbook();
//            for(int sheetnum=0;sheetnum<map.size();sheetnum++){
//                XSSFSheet sheet = wb.createSheet(""+sheetnum);
//                List<String[]> list = map.get(sheetnum);
//                for(int i=0;i<list.size();i++){
//                    XSSFRow row = sheet.createRow(i);
//                    String[] str = list.get(i);
//                    for(int j=0;j<str.length;j++){
//                        XSSFCell cell = row.createCell(j);
//                        cell.setCellValue(str[j]);
//                    }
//                }
//            }
//            FileOutputStream outputStream = new FileOutputStream(fileName);
//            wb.write(outputStream);
//            outputStream.close();
//        } catch (FileNotFoundException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
//    }

}
