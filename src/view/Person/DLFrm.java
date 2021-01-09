package view.Person;


import bean.Personal;
import dao.empl.deleteDAO;
import dao.empl.selectOtherIn;
import dao.empl.selectOtherOut;
import util.DatabaseConnectionSql;
import util.getPersonMSG;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * 这里是登录成功后显示的界面
 */
public class DLFrm extends JDialog {
    private JTable table;
    private JTextField zjsrtxt;
    private JTextField zjsrsztxt;
    private JTextField zjzctxt;
    private JTextField zjzcsztxt;
    private JTextField sctxt;
    private JTextField cxtxt;
    private Personal per;


    /**
     * Create the dialog.
     */
    public DLFrm(String user) throws SQLException {
        getPersonMSG permsg=new getPersonMSG();
        per=permsg.getPerson(user);

        setTitle("\u4E2A\u4EBA\u4FE1\u606F");
        setBounds(100, 100, 723, 400);
        getContentPane().setLayout(null);





        JLabel label = new JLabel("\u8FFD\u52A0\u6536\u5165\u4FE1\u606F\uFF1A");
        label.setBounds(50, 27, 106, 27);
        getContentPane().add(label);

        zjsrtxt = new JTextField();
        zjsrtxt.setBounds(170, 28, 125, 26);
        getContentPane().add(zjsrtxt);
        zjsrtxt.setColumns(10);

        JLabel label_1 = new JLabel("\u6570\u503C\uFF1A");
        label_1.setBounds(327, 31, 72, 18);
        getContentPane().add(label_1);

        zjsrsztxt = new JTextField();
        zjsrsztxt.setBounds(386, 31, 86, 24);
        getContentPane().add(zjsrsztxt);
        zjsrsztxt.setColumns(10);

        JButton zjbtn1 = new JButton("\u589E\u52A0");
        zjbtn1.setBounds(515, 31, 113, 27);
        zjbtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if(zjsrtxt.getText().length()!=0&&zjsrsztxt.getText().length()!=0)
                    checkIn(zjsrtxt.getText(),Float.parseFloat(zjsrsztxt.getText()));
                    else
                        JOptionPane.showMessageDialog(null,"增加失败，数据不准为空！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        getContentPane().add(zjbtn1);

        JLabel label_2 = new JLabel("\u8FFD\u52A0\u652F\u51FA\u4FE1\u606F\uFF1A");
        label_2.setBounds(50, 67, 106, 27);
        getContentPane().add(label_2);

        zjzctxt = new JTextField();
        zjzctxt.setBounds(170, 64, 125, 27);
        getContentPane().add(zjzctxt);
        zjzctxt.setColumns(10);

        JLabel label_3 = new JLabel("\u6570\u503C\uFF1A");
        label_3.setBounds(327, 67, 72, 18);
        getContentPane().add(label_3);

        zjzcsztxt = new JTextField();
        zjzcsztxt.setBounds(386, 64, 86, 27);
        getContentPane().add(zjzcsztxt);
        zjzcsztxt.setColumns(10);

        JButton zjbtn2 = new JButton("\u589E\u52A0");
        zjbtn2.setBounds(515, 67, 113, 27);
        zjbtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if(zjzctxt.getText().length()!=0&&zjzcsztxt.getText().length()!=0)
                        checkIn(zjzctxt.getText(),Float.parseFloat(zjzcsztxt.getText()));
                    else
                        JOptionPane.showMessageDialog(null,"增加失败，数据不准为空！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        getContentPane().add(zjbtn2);

        JLabel label_4 = new JLabel("\u5220\u9664\u6536\u652F\u4FE1\u606F\uFF1A");
        label_4.setBounds(50, 110, 106, 27);
        getContentPane().add(label_4);


        JButton scbtn = new JButton("\u5220\u9664");
        scbtn.setBounds(170, 111, 125, 26);
        scbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "",    JOptionPane.YES_NO_OPTION) == 0){
                        new deleteDAO().sc(per.getUser());

                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        getContentPane().add(scbtn);

        JLabel label_4_1 = new JLabel("\u67E5\u8BE2\u6536\u652F\u4FE1\u606F\uFF1A");
        label_4_1.setBounds(50, 152, 106, 27);
        getContentPane().add(label_4_1);

        cxtxt = new JTextField();
        cxtxt.setBounds(170, 155, 125, 24);
        getContentPane().add(cxtxt);
        cxtxt.setColumns(10);

        ImageIcon img=new ImageIcon("E:\\课程设计\\背景图片\\bpic22048.jpg");
        JLabel lable=new JLabel(img);
        this.getLayeredPane().setLayout(null);
        lable.setBounds(0, 0, 723, 400);
        this.getLayeredPane().add(lable,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        JButton cxbtn = new JButton("\u67E5\u8BE2");
        cxbtn.setBounds(322, 152, 113, 27);
        cxbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(cxtxt.getText().length()==0)
                    JOptionPane.showMessageDialog(null,"请输入数据！");
                else if(cxtxt.getText().compareTo("工资")==0)
                    JOptionPane.showMessageDialog(null,"您的工资为:"+per.getWages()+"元");
                else if(cxtxt.getText().compareTo("其他收入")==0) {
                    try {
                        JOptionPane.showMessageDialog(null,"您的其他收入为:"+new selectOtherIn().getInremark(per.getUser()));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else if(cxtxt.getText().compareTo("其他支出")==0) {
                    try {
                        JOptionPane.showMessageDialog(null,"您的其他收入为:"+new selectOtherOut().getOutremark(per.getUser()));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else if(cxtxt.getText().compareTo("食品费用")==0)
                    JOptionPane.showMessageDialog(null,"您的食品费用为:"+per.getFoodcons()+"元");
                else if(cxtxt.getText().compareTo("水电费")==0)
                    JOptionPane.showMessageDialog(null,"您的水电费为:"+per.getUtilityfee()+"元");
                else if(cxtxt.getText().compareTo("医疗费用")==0)
                    JOptionPane.showMessageDialog(null,"您的医疗费用为:"+per.getMedical()+"元");
                else if(cxtxt.getText().compareTo("娱乐费用")==0)
                    JOptionPane.showMessageDialog(null,"您的娱乐费用为:"+per.getEntertainment()+"元");
                else
                    JOptionPane.showMessageDialog(null,"请输入已有的数据名字！");
            }
        });
        getContentPane().add(cxbtn);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("\u663E\u793A\u4FE1\u606F");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("\u6536\u5165\u60C5\u51B5");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"您的个人收入为:"+per.getIncome()+"元");
            }
        });
        menu.add(menuItem);

        JMenuItem menuItem_1 = new JMenuItem("\u652F\u51FA\u60C5\u51B5");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"您的个人支出为:"+per.getOutcome()+"元");
            }
        });
        menu.add(menuItem_1);

        JMenuItem menuItem_2 = new JMenuItem("\u4F59\u989D");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"您的余额为:"+per.getYue()+"元");
            }
        });
        menu.add(menuItem_2);
    }



    public void checkOut(String bz,Float sz) throws SQLException {
        String str="";
        if("食品费用".compareTo(bz)==0)
            str="foodcons";
        else if("水电费".compareTo(bz)==0)
            str="utilityfrr";
        else if("医疗费用".compareTo(bz)==0)
            str="Medical";
        else if("娱乐费用".compareTo(bz)==0)
            str="Entertainment";
        else
            str="otherOutcome";
        if("otherOutcome".compareTo(str)!=0) {
            String sql = "update outcome set "+str+"="+str+sz+" where [user]='"+per.getUser()+"'";
            String sql1="update allperson set outcome=(select outcome from outcome where [user]='"+per.getUser()+"') where [user]='"+per.getUser()+"'";
            DatabaseConnectionSql DC=new DatabaseConnectionSql();
            Connection conn=DC.getConnection();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null,"增加成功！");
        }else{
            per.addOtherOutcome(bz,sz);
            String sql="update outcome set otherOutcome=otherOutcome+"+sz+" where [user]='"+per.getUser()+"'";
            String sql1="update outcome set remark='"+per.getOutRemark()+"' where [user]='"+per.getUser()+"'";
            DatabaseConnectionSql DC=new DatabaseConnectionSql();
            Connection conn=DC.getConnection();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null,"增加成功！");
        }
    }

    public void checkIn(String bz,Float sz) throws SQLException {
        if("工资".compareTo(bz)==0){
            String sql="update income set wages=wages+"+sz+" where [user]='"+per.getUser()+"'";
            String sql1="update allperson set income=(select income from income where [user]='"+per.getUser()+"') where [user]='"+per.getUser()+"'";
            DatabaseConnectionSql DC=new DatabaseConnectionSql();
            Connection conn=DC.getConnection();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null,"增加成功！");
        }
        else{
            per.addOtherIncome(bz,sz);
            String sql="update income set otherIncome=otherIncome+"+sz+" where [user]='"+per.getUser()+"'";
            String sql1="update income set remark='"+per.getInRemark()+"' where [user]='"+per.getUser()+"'";
            DatabaseConnectionSql DC=new DatabaseConnectionSql();
            Connection conn=DC.getConnection();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null,"增加成功！");
        }
    }
}
