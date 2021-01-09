package bean;

import java.io.Serializable;
import java.util.*;

/**
 * 这里是实体类
 * @author 刘展
 */
public class Personal implements Serializable {
    private String User;//用户名   主键
    private String password;//密码
    private String xm;//姓名
    private String xb;
    private Float wages;//工资
    private TreeMap<String,Float> otherIncome=new TreeMap<>(); //其他收入
    private Float foodcons;//食品消费
    private Float utilityfee;//水电费
    private Float Medical;//医疗费用
    private Float Entertainment;//娱乐
    private TreeMap<String,Float> otherOutcome=new TreeMap<>();  //其他支出
    private Float Saving;//储蓄
    private Float outcome;//总支出
    private Float income;//总收入




    public Personal() {}

    /**
     * 这里是实体类的构造方法，用来创建新对象的方法
     * @param user
     * @param password
     * @param xm
     * @param xb
     * @param wages
     * @param foodcons
     * @param utilityfee
     * @param medical
     * @param entertainment
     * @param saving
     * @param otherIncome
     * @param otherOutcome
     */
    public Personal(String user, String password, String xm, String xb, Float wages, Float foodcons, Float utilityfee, Float medical, Float entertainment,Float saving,TreeMap<String,Float> otherIncome,TreeMap<String,Float> otherOutcome) {
        User = user;
        this.password = password;
        this.xm = xm;
        this.xb = xb;
        this.wages = wages;
        this.foodcons = foodcons;
        this.utilityfee = utilityfee;
        Medical = medical;
        Entertainment = entertainment;
        this.Saving=saving;
        this.otherIncome=otherIncome;
        this.otherOutcome=otherOutcome;
    }

    /**
     * 这个方法是增加其他收入信息
     * @param bz
     * @param sz
     */
    public void addOtherIncome(String bz,float sz){
        if(!otherIncome.containsKey(bz))
            otherIncome.put(bz,sz);

        else
        otherIncome.put(bz,sz+otherIncome.get(bz));

    }

    /**
     * 这个方法是增加其他支出信息
     * @param bz
     * @param sz
     */
    public void addOtherOutcome(String bz,float sz){
        if(!otherOutcome.containsKey(bz))
            otherOutcome.put(bz,sz);
        else
        otherOutcome.put(bz,sz+otherOutcome.get(bz));
    }

    /**
     * 这个方法是得到其他收入的信息
     * @return
     */
    public String getInRemark(){
        String s="";
        Set<String> remark=otherIncome.keySet();
        Collection<Float> sz=otherIncome.values();
        for(String str:remark){
            s+=str+otherIncome.get(str)+",";
        }
        return s;
    }

    /**
     * 这里是得到其他支出的信息
     * @return
     */

    public String getOutRemark(){
        String s="";
        Set<String> remark=otherOutcome.keySet();
        Collection<Float> sz=otherOutcome.values();
        for(String str:remark){
            s+=str+otherOutcome.get(str)+",";
        }
        return s;
    }

    /**
     * 这里是得到其他收入的总和
     * @return
     */
    public Float getOtherIncome(){
        Collection<Float> otherIncomeSZ=otherIncome.values();
        float otherIncome=0;
        for(Float x :otherIncomeSZ){
            otherIncome+=x;
        }
        return otherIncome;
    }

    /**
     * 这里是得到其他支出的总和
     * @return
     */
    public Float getOtherOutcome(){
        Collection<Float> otherIncomeSZ=otherOutcome.values();
        float sz=0;
        for(float x:otherIncomeSZ)
            sz+=x;
        return sz;
    }


    /**
     * 这里是得到用户名
     * @return
     */

    public String getUser(){return User;
    }

    /**
     * 这里是得到密码
     * @return
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public Float getWages() {
        return wages;
    }

    public void setWages(Float wages) {
        this.wages = wages;
    }



    public Float getFoodcons() {
        return foodcons;
    }

    public void setFoodcons(Float foodcons) {
        this.foodcons = foodcons;
    }

    public Float getUtilityfee() {
        return utilityfee;
    }

    public void setUtilityfee(Float utilityfee) {
        this.utilityfee = utilityfee;
    }

    public Float getMedical() {
        return Medical;
    }

    public void setMedical(Float medical) {
        this.Medical = medical;
    }

    public Float getEntertainment() {
        return Entertainment;
    }

    public void setEntertainment(Float entertainment) {
        this.Entertainment = entertainment;
    }



    public Float getOutcome() {
        return foodcons+utilityfee+Medical+Entertainment+this.getOtherOutcome();
    }

    public Float getIncome(){
        return wages+this.getOtherIncome();
    }



    public Float getSaving() {
        return Saving;
    }

    public Float getYue(){
        return this.getIncome()-this.getOutcome();
    }

    @Override
    public String toString() {
        return "用户名为:"+User+",密码为:"+password+",姓名为:"+xm+",性别为:"+xb+",工资为:"+wages+ "元,其他收入为:"+otherIncome+",食品消费为:"+foodcons+",水电费为:"+utilityfee+ "元,医疗费用为:"+Medical+"元,娱乐费用为:" +Entertainment+"元,其他支出为:"+otherOutcome +",储蓄为:"+Saving+"元,"+",总收入为:"+this.getIncome()+"元,总支出为:" +this.getOutcome() +"元。";
    }
}

