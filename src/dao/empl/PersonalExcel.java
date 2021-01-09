package dao.empl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xslf.usermodel.XSLFNotesMaster;
import util.DatabaseConnectionSql;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * 这里是将用户表的信息导入到Excel表中
 */
public class PersonalExcel {
    String sql="select * from allperson";
    public void getPersonalExcel() throws SQLException, IOException {
        DatabaseConnectionSql DC=new DatabaseConnectionSql();
        Connection conn=DC.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        File f=new File("E:\\课程设计\\用户表.xls");
        Workbook wb=new HSSFWorkbook();
        Sheet sheet =  wb.createSheet();
        Row row1=sheet.createRow(0);
        Cell cell1= row1.createCell(0);
        Cell cell2= row1.createCell(1);
        Cell cell3= row1.createCell(2);
        Cell cell4= row1.createCell(3);
        Cell cell5= row1.createCell(4);
        Cell cell6= row1.createCell(5);
        Cell cell7= row1.createCell(6);
        cell1.setCellValue("user");
        cell2.setCellValue("password");
        cell3.setCellValue("name");
        cell4.setCellValue("sex");
        cell5.setCellValue("income");
        cell6.setCellValue("outcome");
        cell7.setCellValue("saving");
        int h=1;
        while(rs.next()){
            Row row=sheet.createRow(h);
            h++;
            for (int i = 0; i < 7; i++) {
                Cell cell=row.createCell(i);

            if(i<4)
                cell.setCellValue(rs.getString(i+1));
            else
                cell.setCellValue(rs.getDouble(i+1));

            }
        }
        FileOutputStream fos=new FileOutputStream(f);
        wb.write(fos);
        fos.close();
        JOptionPane.showMessageDialog(null,"success");
    }
}
