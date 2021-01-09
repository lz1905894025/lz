package dao.empl;

import util.DatabaseConnectionSql;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteDAO {
    public static void sc(String user)  {
        String sql="delete from allperson where [user]='"+user+"'";
        String sql1="delete from income where [user]='"+user+"'";
        String sql2="delete from outcome where [user]='"+user+"'";
        DatabaseConnectionSql DC=new DatabaseConnectionSql();
        Connection conn=DC.getConnection();
        try{
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,"删除成功！");
    }
}
