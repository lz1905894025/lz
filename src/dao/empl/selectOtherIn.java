package dao.empl;

import util.DatabaseConnectionSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectOtherIn {
    public static String getInremark(String user) throws SQLException {
        String sql="select remark from income where [user]='"+user+"'";
        String str=null;
        DatabaseConnectionSql DC = new DatabaseConnectionSql();
        Connection conn = DC.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
            str=rs.getString(1);
        return str;
    }

}
