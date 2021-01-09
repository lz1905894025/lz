package dao.empl;

import util.DatabaseConnectionSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * 这里是查询用户表中的数据
 */
public class selectUser {
    public static Vector<Vector> User() throws SQLException {
        String sql="select * from allperson";
        Vector<Vector> rows=new Vector<>();
        DatabaseConnectionSql DC = new DatabaseConnectionSql();
        Connection conn = DC.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Vector row=new Vector();
            row.add(rs.getString(1));
            row.add(rs.getString(2));
            row.add(rs.getString(3));
            row.add(rs.getString(4));
            row.add(rs.getFloat(5));
            row.add(rs.getFloat(6));
            row.add(rs.getFloat(7));
            rows.add(row);
        }
        return rows;
    }
}
