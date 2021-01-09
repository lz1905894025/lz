package dao.empl;

import util.DatabaseConnectionSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * 这里是查询支出表中的数据
 */
public class selectOutcome {
    public static Vector<Vector> Outcome()  {
        String sql="select * from outcome";
        Vector<Vector> rows=null;
        DatabaseConnectionSql DC = new DatabaseConnectionSql();
        Connection conn = DC.getConnection();
        try(Statement stmt = conn.createStatement();){
            rows=new Vector<>();
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
                row.add(rs.getFloat(8));
                row.add(rs.getFloat(9));
                row.add(rs.getFloat(10));
                rows.add(row);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return rows;
    }
}
