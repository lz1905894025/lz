package dao.empl;

import util.DatabaseConnectionSql;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * 把数据库里的allperson表的数据导入到文本文件中去
 */
public class PersonalTXT {

    String sql="select * from allperson";
    public Vector<String> getRows() throws SQLException {
        DatabaseConnectionSql DC=new DatabaseConnectionSql();
        Connection conn=DC.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        Vector<String> rows=new Vector<>();
        rows.add("user"+"       "+"password"+"      "+"name"+"     "+"sex"+"     "+"income"+"     "+"outcome"+"     "+"saving");
        while(rs.next()){
            String user=rs.getString(1);
            String password=rs.getString(2);
            String name=rs.getString(3);
            String sex=rs.getString(4);
            Double income=rs.getDouble(5);
            Double outcome=rs.getDouble(6);
            Double saving=rs.getDouble(7);
            String row;
            row=user+"     "+password+"     "+name+"     "+sex+"     "+income+"     "+outcome+"     "+saving;
            rows.add(row);
        }
        return rows;
    }
    public void getPersonTxt() throws SQLException {
        Vector<String> rows = this.getRows();
        File f = new File("E:\\课程设计\\用户表.txt");
        try(FileWriter fw=new FileWriter(f,true);){
        for(String row:rows){
            fw.write(row+"\r\n");
        }
        JOptionPane.showMessageDialog(null,"success");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
