package view.allPerson;

import dao.empl.*;
import org.apache.poi.ss.formula.functions.T;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;


/**
 * 这里是点击“所有数据”按钮所出现的界面
 */
public class allperFrm extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    allperFrm frame = new allperFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public allperFrm() {
        setTitle("\u5168\u90E8\u4FE1\u606F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 762, 480);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("\u5C55\u793A\u4FE1\u606F");
        menuBar.add(menu);
/**
 * 这个按钮是显示所有数据的
 */
        JMenuItem menuItem = new JMenuItem("\u5168\u90E8\u4FE1\u606F");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new allPerTable().setVisible(true);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        menu.add(menuItem);
/**
 * 这个按钮是显示用户表信息的
 */
        JMenuItem menuItem_1 = new JMenuItem("\u7528\u6237\u4FE1\u606F");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new allPerUserTable().setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        menu.add(menuItem_1);
/**
 * 这个按钮是显示收入表信息的
 */
        JMenuItem menuItem_2 = new JMenuItem("\u6536\u5165\u4FE1\u606F");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new allPerIncomeTable().setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        menu.add(menuItem_2);
/**
 * 这个按钮是显示支出表信息的
 */
        JMenuItem menuItem_3 = new JMenuItem("\u652F\u51FA\u4FE1\u606F");
        menuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new allPerOutcomeTable().setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        menu.add(menuItem_3);

        JMenu menu_1 = new JMenu("\u65B0\u589E\u7528\u6237");
        menuBar.add(menu_1);
/**
 * 这里是新增用户的按钮
 */
        JMenuItem menuItem_4 = new JMenuItem("\u6CE8\u518C\u65B0\u7528\u6237");
        menuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    addPerson addper=new addPerson();
                    addper.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        menu_1.add(menuItem_4);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenu mnNewMenu = new JMenu("\u5BFC\u51FAExcel\u8868");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("\u5BFC\u51FA\u7528\u6237\u8868");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                PersonalExcel per=new PersonalExcel();
                try {
                    per.getPersonalExcel();
                    JOptionPane.showMessageDialog(null,"导出成功！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5BFC\u51FA\u6536\u5165\u8868");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IncomeExcel per=new IncomeExcel();
                try {
                    per.getIncomeExcel();
                    JOptionPane.showMessageDialog(null,"导出成功！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5BFC\u51FA\u652F\u51FA\u8868");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OutcomeExcel per=new OutcomeExcel();
                try {
                    per.getOutcomeExcel();
                    JOptionPane.showMessageDialog(null,"导出成功！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem_2);

        JMenu mntxt = new JMenu("\u5BFC\u51FAtxt\u6587\u4EF6");
        menuBar.add(mntxt);

        JMenuItem mntmtxt = new JMenuItem("\u5BFC\u51FA\u7528\u6237\u8868txt\u6587\u4EF6");
        mntmtxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                PersonalTXT pertxt=new PersonalTXT();
                try {
                    pertxt.getPersonTxt();
                    JOptionPane.showMessageDialog(null,"导入成功！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        mntxt.add(mntmtxt);

        JMenuItem mntmtxt_1 = new JMenuItem("\u5BFC\u51FA\u6536\u5165\u8868txt\u6587\u4EF6");
        mntmtxt_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IncomeTXT Intxt=new IncomeTXT();
                try {
                    Intxt.getIncome();
                    JOptionPane.showMessageDialog(null,"导入成功！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        mntxt.add(mntmtxt_1);

        JMenuItem mntmtxt_2 = new JMenuItem("\u5BFC\u51FA\u652F\u51FA\u8868txt\u6587\u4EF6");
        mntmtxt_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OutcomeTXT Outtxt=new OutcomeTXT();
                try {
                    Outtxt.getOutcome();
                    JOptionPane.showMessageDialog(null,"导入成功！");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        mntxt.add(mntmtxt_2);

        JButton button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
        button.setBounds(226, 224, 247, 80);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        contentPane.add(button);



        ImageIcon img=new ImageIcon("E:\\课程设计\\背景图片\\bpic22156.jpg");
        JLabel lable=new JLabel(img);
        this.getLayeredPane().setLayout(null);
        lable.setBounds(0, 0, 762, 480);
        this.getLayeredPane().add(lable,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);
    }
}
