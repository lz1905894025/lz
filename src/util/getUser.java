package util;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 这里是得到所有的用户名信息
 */
public class getUser {
    public ArrayList<String> getUser() throws SQLException {
        ArrayList<String> user=new ArrayList<>();
        String sql="select [user] from allperson";
        DatabaseConnectionSql DC=new DatabaseConnectionSql();
        Connection conn=DC.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            user.add(rs.getString(1));
        }
        return user;
    }
}
