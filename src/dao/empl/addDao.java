package dao.empl;

import util.DatabaseConnectionSql;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 这里是增加数据到数据库的类
 */
public class addDao {
    /**
     * 这个方法是增加数据到数据库
     * @param user
     * @param pw
     * @param xm
     * @param xb
     * @param income
     * @param outcome
     * @param saving
     * @param wages
     * @param oi
     * @param oo
     * @param fd
     * @param fee
     * @param Med
     * @param Enter
     * @param oisz
     * @param oosz
     * @throws SQLException
     */
    public addDao(String user,String pw,String xm,String xb,float income,float outcome,float saving,float wages,String oi,String oo,float fd,float fee,float Med,float Enter,float oisz,float oosz) throws SQLException {
        DatabaseConnectionSql DC = new DatabaseConnectionSql();
        Connection conn = DC.getConnection();
        Statement stmt = conn.createStatement();
        String sql1="insert into allperson values('"+user+"','"+pw+"','"+xm+"','"+xb+"',"+income+","+outcome+","+saving+")";
        String sql2="insert into income values('"+user+"','"+xm+"','"+xb+"','"+oi+"',"+income+","+wages+","+oisz+")";
        String sql3="insert into outcome values('"+user+"','"+xm+"','"+xb+"','"+oo+"',"+outcome+","+fd+","+fee+","+Med+","+Enter+","+oosz+")";
        stmt.executeUpdate(sql1);
        stmt.executeUpdate(sql2);
        stmt.executeUpdate(sql3);
        JOptionPane.showMessageDialog(null,"注册成功！");
    }
}
