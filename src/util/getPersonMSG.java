package util;

import bean.Personal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

/**
 * 这里是通过用户名来得到一个用户的所有信息
 */
public class getPersonMSG {
    public Personal getPerson(String user) throws SQLException {
        DatabaseConnectionSql DC=new DatabaseConnectionSql();
        Connection conn=DC.getConnection();
        Statement stmt=conn.createStatement();
        String sql="select allperson.[user],password,allperson.name,allperson.sex,income.remark,wages,outcome.remark,foodcons,utilityfee,Medical,Entertainment,saving";
        String sql1=" from allperson,income,outcome";
        String sql2=" where allperson.[user]=income.[user] and allperson.[user]=outcome.[user] and allperson.[user]='"+user+"'";
        ResultSet rs=stmt.executeQuery(sql+sql1+sql2);
        Personal per = null;
        TreeMap<String,Float> otherIncome=new TreeMap<>();
        TreeMap<String,Float> otherOutcome=new TreeMap<>();
        while(rs.next()) {
            String s1 = rs.getString(5);
            String[] remark1 = s1.split(",");
            String s2 = rs.getString(7);
            String[] remark2 = s2.split(",");
            for (String s : remark1) {
                for (int i = 0; i < s.length(); i++) {
                    int index = 0;
                    char c[] = s.toCharArray();
                    for (int j = 0; j < c.length; j++) {
                        if (c[j] >= '0' && c[j] <= '9') {
                            index = j;
                            break;
                        }
                    }
                    String bz = s.substring(0, index);
                    String szstr = s.substring(index);
                    float sz = Float.parseFloat(szstr);
                    if(!otherIncome.containsKey(bz))

                    otherIncome.put(bz,sz);
                    else
                    otherIncome.put(bz,sz+otherIncome.get(bz));
                }
            }
            for (String s : remark2) {
                for (int i = 0; i < s.length(); i++) {
                    int index = 0;
                    char c[] = s.toCharArray();
                    for (int j = 0; j < c.length; j++) {
                        if (c[j] >= '0' && c[j] <= '9') {
                            index = j;
                            break;
                        }
                    }
                    String bz = s.substring(0, index);
                    String szstr = s.substring(index);
                    float sz = Float.parseFloat(szstr);
                    if(!otherOutcome.containsKey(bz))
                        otherOutcome.put(bz,sz);
                    else
                        otherOutcome.put(bz,sz+otherOutcome.get(bz));
                }
                }

            per = new Personal(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(6), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11),rs.getFloat(12),otherIncome,otherOutcome);
        }
        return per;
    }
}
