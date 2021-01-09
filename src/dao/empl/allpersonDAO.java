package dao.empl;

import util.DatabaseConnectionSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 这里是用户名与密码相对应的类
 */
public class allpersonDAO {
    /**
     * 这里是得到所有用户名的方法
     * @return
     * @throws SQLException
     */
    public static ArrayList<String> getUser() throws SQLException {
        String sql="select [user] from allperson";
        DatabaseConnectionSql DC = new DatabaseConnectionSql();
        Connection conn = DC.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<String> AllUser=new ArrayList<>();
        while(rs.next()){
            AllUser.add(rs.getString(1));
        }
        return AllUser;
    }

    /**
     * 这里是得到所有密码的方法
     * @param user
     * @return
     * @throws SQLException
     */
    public static String dl(String user) throws SQLException {
        String sql="select password from allperson where [user]='"+user+"'";
        DatabaseConnectionSql DC = new DatabaseConnectionSql();
        Connection conn = DC.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String password=null;
        while(rs.next()){
            password=rs.getString(1);
        }
        return password;
    }
}
