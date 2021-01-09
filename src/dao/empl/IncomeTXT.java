package dao.empl;

import util.DatabaseConnectionSql;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * 这里是将数据导入到txt文件的类
 */
public class IncomeTXT {
    String sql="select * from income";
    public Vector<String> getRows() throws SQLException {
        DatabaseConnectionSql DC=new DatabaseConnectionSql();
        Connection conn=DC.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        Vector<String> rows=new Vector<>();
        rows.add("user              name        sex     remark   income      wages        otherIncome");
        while(rs.next()){
            rows.add(rs.getString(1)+"     "+rs.getString(2)+"      "+rs.getString(3)+"       "+rs.getString (4)+"       "+rs.getDouble(5)+"     "+rs.getDouble(6)+"       "+rs.getDouble(7));
        }
        return rows;
    }
    public void getIncome() throws SQLException{
        File f=new File("E:\\课程设计\\收入表.txt");
        try(FileWriter fw=new FileWriter(f);){
            for (String row:this.getRows()){
                fw.write(row+"\t\n");
            }}
        catch(IOException e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"success");
    }
}
