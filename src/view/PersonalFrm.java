package view;

import view.Person.perFrm;
import view.allPerson.allperFrm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * 这里是总界面
 */
public class PersonalFrm extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PersonalFrm frame = new PersonalFrm();
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
    public PersonalFrm() {
        setTitle("\u4E2A\u4EBA\u6536\u652F\u7BA1\u7406\u7CFB\u7EDF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 569, 327);
        contentPane=(JPanel)this.getContentPane();
        contentPane.setLayout(null);


        ImageIcon img=new ImageIcon("E:\\\\课程设计\\\\背景图片\\\\bpic21080.jpg");

        JLabel lable=new JLabel(img);
        this.getLayeredPane().setLayout(null);
        lable.setBounds(0, 0, 569, 327);
        this.getLayeredPane().add(lable,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);



        JLabel titleLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u4E2A\u4EBA\u6536\u652F\u7BA1\u7406\u7CFB\u7EDF",JLabel.CENTER);
        titleLabel.setForeground(Color.RED);
        Font fonA=new Font("楷体",Font.ITALIC+Font.BOLD,35);
        titleLabel.setFont(fonA);
        titleLabel.setBounds(14, 13, 523, 90);

        contentPane.add(titleLabel);
/**
 * 这里是点击全部信息按钮所出现的事件
 */
        JButton allbtn = new JButton("全部信息");
        allbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                allperFrm frame=new allperFrm();
                frame.setVisible(true);
            }
        });
        allbtn.setBounds(27, 168, 220, 71);
        contentPane.add(allbtn);
/**
 * 这里是点击个人信息按钮所出现的事件
 */
        JButton perbtn = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
        perbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                perFrm frame = null;
                try {
                    frame = new perFrm();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                frame.setVisible(true);
            }
        });
        perbtn.setBounds(291, 168, 220, 71);
        contentPane.add(perbtn);
    }
}
