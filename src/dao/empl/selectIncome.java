package dao.empl;

import util.DatabaseConnectionSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * 这里是查询收入表中的数据
 */
public class selectIncome {
    public static Vector<Vector> Income() throws SQLException {
        String sql="select * from income";
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
