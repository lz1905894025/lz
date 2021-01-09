package util;

import bean.Personal;

import java.sql.*;
import java.util.ArrayList;

/**
 * 这里是得到所有数据库中的数据
 */
public class getAllMSG {
    public static ArrayList<Personal> getAll()  {
        ArrayList<Personal> allmsg=new ArrayList<>();
        try{
            getUser u=new getUser();
            ArrayList<String> userMSG=u.getUser();
            for (String user:userMSG){
                getPersonMSG per=new getPersonMSG();
                allmsg.add(per.getPerson(user));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allmsg;
}
}
