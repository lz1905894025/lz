package dao.empl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import util.DatabaseConnectionSql;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 此类用于导入支出信息到Excel表中的类
 */
public class OutcomeExcel {
    String sql="select * from outcome";
    public void getOutcomeExcel() throws SQLException, IOException {
        DatabaseConnectionSql DC = new DatabaseConnectionSql();
        Connection conn = DC.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        File f = new File("E:\\课程设计\\支出表.xls");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row1=sheet.createRow(0);
        Cell cell1= row1.createCell(0);
        Cell cell2= row1.createCell(1);
        Cell cell3= row1.createCell(2);
        Cell cell4= row1.createCell(3);
        Cell cell5= row1.createCell(4);
        Cell cell6= row1.createCell(5);
        Cell cell7= row1.createCell(6);
        Cell cell8= row1.createCell(7);
        Cell cell9= row1.createCell(8);
        Cell cell10= row1.createCell(9);
        cell1.setCellValue("user");
        cell2.setCellValue("name");
        cell3.setCellValue("sex");
        cell4.setCellValue("remark");
        cell5.setCellValue("outcome");
        cell6.setCellValue("foodcons");
        cell7.setCellValue("utilityfee");
        cell8.setCellValue("Medical");
        cell9.setCellValue("Entertainment");
        cell10.setCellValue("otherOutcome");
        int h=1;
        while(rs.next()){
            Row row=sheet.createRow(h);
            h++;
            for (int i = 0; i < 9; i++) {
                Cell cell=row.createCell(i);
                if(i<4)
                    cell.setCellValue(rs.getString(i+1));
                else
                    cell.setCellValue(rs.getDouble(i+1));
            }
        }
        FileOutputStream fos=new FileOutputStream(f);//创建输出流对象
        wb.write(fos);//将内容写入到指定的excel文档
        fos.close();
        JOptionPane.showMessageDialog(null,"success");
    }
}
