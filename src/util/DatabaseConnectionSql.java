package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 这个类是连接SQL server的类
 */
public class DatabaseConnectionSql {
    //定义SQLServer数据库驱动程序
    private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //定义SQLServer数据库连接地址
    private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=personaldata";
    private static final String DBUSER="sa"; //SQLServer数据库连接用户名
    private static final String PASSWORD="lz123321."; //SQLServer数据库连接密码
    private Connection conn=null; //保存连接对象
    public DatabaseConnectionSql() {//构造方法连接数据库
        try {
            Class.forName(DBRIVER);

            this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
        } catch (Exception e) {e.printStackTrace();}
    }
    public Connection getConnection() {//返回数据库连接对象
        return this.conn;
    }
    public void close() {//关闭数据连接
        if(this.conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}