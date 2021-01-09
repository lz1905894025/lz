package view.Person;
import bean.Personal;
import dao.empl.addPerson;
import util.getAllMSG;
import dao.empl.allpersonDAO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 这里是登录界面
 */
public class perFrm extends  JDialog{
    private JPanel contentPane;
    private JTextField usertxt;
    private JPasswordField pwtxt;
    private JLabel userlbl1;
    private JLabel pwlbl1;
    private allpersonDAO apDAO=new allpersonDAO();
    private static ArrayList<Personal> allmsg=new ArrayList<>();
    public static void main(String[] args) throws SQLException {
        getAllMSG msg=new getAllMSG();
        allmsg=msg.getAll();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    perFrm frame = new perFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public int checkUser() throws SQLException {
        ArrayList<String> allUser=new ArrayList<>();
        allUser =apDAO.getUser();
        if(usertxt.getText().length()==0){
            return 2;
        }
        else if(!allUser.contains(usertxt.getText())){
            return 3;
        }
        else if(allUser.contains(usertxt.getText())){
            return 1;}
        else
            return 0;
    }


    public int checkPassword() throws SQLException {
        if (checkUser()==1) {
            String mm = apDAO.dl(usertxt.getText());
            String pw = new String(pwtxt.getPassword());
            if(pw.length()==0)
                pw=null;
            if (pw == null) {
                return 2;
            } else if (mm.compareTo(pw)!=0) {
                pwlbl1.setText("密码错误！");
                return 3;
            } else if (mm.compareTo(pw) == 0) {
                pwlbl1.setText("");
                return 1;
            }
            else
                return 1;
        }
        else
            return 1;
    }
    public boolean DL(){
        try {
            if(checkUser()==1&&checkPassword()==1){
                return true;
            }
            else
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }



    public perFrm() throws SQLException {
        setTitle("\u4E2A\u4EBA\u4FE1\u606F\u767B\u5F55\u754C\u9762");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 603, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel dllbl = new JLabel("\u767B\u5F55\u754C\u9762");
        Font fonA=new Font("楷体",Font.BOLD,35);
        dllbl.setFont(fonA);
        dllbl.setBounds(221, 62, 153, 69);
        contentPane.add(dllbl);

        JLabel userlbl = new JLabel("\u7528\u6237\u540D");
        userlbl.setBounds(135, 159, 72, 18);
        contentPane.add(userlbl);

        usertxt = new JTextField();
        usertxt.setBounds(221, 156, 125, 24);
        contentPane.add(usertxt);
        usertxt.setColumns(10);

        JLabel pwlbl = new JLabel("\u5BC6\u7801");
        pwlbl.setBounds(135, 213, 72, 18);
        contentPane.add(pwlbl);

        pwtxt = new JPasswordField();
        pwtxt.setBounds(221, 210, 125, 24);
        contentPane.add(pwtxt);

        userlbl1 = new JLabel("");
        userlbl1.setBounds(379, 159, 144, 18);
        contentPane.add(userlbl1);

        pwlbl1 = new JLabel("");
        pwlbl1.setBounds(379, 213, 144, 18);
        contentPane.add(pwlbl1);

        usertxt.addFocusListener(new FocusAdapter(){
            public void focusLost(FocusEvent e){
                try {
                    if(checkUser()==2){
                        userlbl1.setText("用户名不为空！");
                        userlbl1.setVisible(true);
                    }
                    else if(checkUser()==3){
                        userlbl1.setText("用户名错误！");
                        userlbl1.setVisible(true);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            public void focusGained(FocusEvent e){
                userlbl1.setVisible(false);
            }
        });

        pwtxt.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                try {
                    if(checkPassword()==2){
                        pwlbl1.setText("密码不为空！");
                        pwlbl1.setVisible(true);
                    }
                    else if(checkPassword()==3){
                        pwlbl1.setText("密码错误！");
                        pwlbl1.setVisible(true);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }public void focusGained(FocusEvent e){
                pwlbl1.setVisible(false);
            }
                               });



        JButton dlbtn = new JButton("\u767B\u5F55");   //  点击登录按钮所进行的事件
        dlbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(DL()){
                    DLFrm frame= null;
                    try {
                        frame = new DLFrm(usertxt.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    frame.setVisible(true);
                }
            }
        });

        dlbtn.setBounds(135, 278, 113, 27);
        contentPane.add(dlbtn);

        JButton zcbtn = new JButton("\u6CE8\u518C\u65B0\u7528\u6237");
        zcbtn.setBounds(286, 278, 113, 27);
        contentPane.add(zcbtn);
        zcbtn.addActionListener(new ActionListener() {   // 这里是点击注册所出现的事件
            public void actionPerformed(ActionEvent arg0) {
                addPerson addper= null;
                try {
                    addper = new addPerson();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                addper.setVisible(true);

            }
        });

        JLabel label = new JLabel("\u65B0\u7528\u6237\uFF1F\u8BF7\u70B9\u51FB\u8FD9\u91CC\u6CE8\u518C");
        label.setBounds(286, 322, 237, 18);
        contentPane.add(label);

        ImageIcon img=new ImageIcon("E:\\课程设计\\背景图片\\zzpic20744.jpg");
        JLabel lable=new JLabel(img);
        this.getLayeredPane().setLayout(null);
        lable.setBounds(0, 0, 626, 453);
        this.getLayeredPane().add(lable,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);
    }
}
