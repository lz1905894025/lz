package dao.empl;




        import util.getUser;

        import java.awt.BorderLayout;
        import java.awt.FlowLayout;
        import java.awt.Font;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.SQLException;
        import java.util.ArrayList;

        import javax.swing.*;
        import javax.swing.border.EmptyBorder;

/**
 * 这个是新增数据的界面
 */
public class addPerson extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField usertxt;
    private JTextField mmtxt;
    private JTextField xmtxt;
    private JTextField xbtxt;
    private JTextField wagestxt;
    private JTextField foodconstxt;
    private JTextField utilityfeetxt;
    private JTextField Medicaltxt;
    private JTextField Entertainmenttxt;
    private JTextField inbztxt;
    private JTextField insztxt;
    private JTextField outbztxt;
    private JTextField outsztxt;
    private JLabel userlbl1;
    private JLabel trip;
    private JTextField cxtxt;

    private static ArrayList<String> allUser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            addPerson dialog = new addPerson();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public addPerson()  {

        try{allUser=new getUser().getUser();}
        catch (Exception e){
            e.printStackTrace();
        }

        setTitle("\u65B0\u7528\u6237\u6CE8\u518C");
        setBounds(100, 100, 640, 623);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("\u65B0\u7528\u6237\u6CE8\u518C");
        Font fonA=new Font("楷体",Font.BOLD,45);
        label.setFont(fonA);
        label.setBounds(178, 30, 298, 101);
        contentPanel.add(label);

        JLabel userlbl = new JLabel("\u7528\u6237\u540D:");
        userlbl.setBounds(68, 148, 64, 31);
        contentPanel.add(userlbl);

        usertxt = new JTextField();
        usertxt.setBounds(146, 151, 103, 24);
        contentPanel.add(usertxt);
        usertxt.setColumns(10);

        JLabel mmlbl = new JLabel("\u5BC6\u7801:");
        mmlbl.setBounds(303, 154, 72, 18);
        contentPanel.add(mmlbl);

        mmtxt = new JTextField();
        mmtxt.setBounds(363, 154, 103, 24);
        contentPanel.add(mmtxt);
        mmtxt.setColumns(10);

        userlbl1 = new JLabel("");
        userlbl1.setBounds(146, 177, 103, 18);
        contentPanel.add(userlbl1);

        JLabel xmlbl = new JLabel("\u59D3\u540D:");
        xmlbl.setBounds(68, 201, 72, 18);
        contentPanel.add(xmlbl);

        xmtxt = new JTextField();
        xmtxt.setBounds(146, 198, 103, 24);
        contentPanel.add(xmtxt);
        xmtxt.setColumns(10);

        JLabel xblbl = new JLabel("\u6027\u522B:");
        xblbl.setBounds(303, 201, 72, 18);
        contentPanel.add(xblbl);

        xbtxt = new JTextField();
        xbtxt.setBounds(363, 198, 103, 24);
        contentPanel.add(xbtxt);
        xbtxt.setColumns(10);

        JLabel label_2 = new JLabel("\u5DE5\u8D44:");
        label_2.setBounds(68, 250, 72, 18);
        contentPanel.add(label_2);

        wagestxt = new JTextField();
        wagestxt.setBounds(146, 247, 103, 24);
        contentPanel.add(wagestxt);
        wagestxt.setColumns(10);

        JLabel label_3 = new JLabel("\u98DF\u54C1\u6D88\u8D39\uFF1A");
        label_3.setBounds(303, 250, 87, 18);
        contentPanel.add(label_3);

        foodconstxt = new JTextField();
        foodconstxt.setBounds(373, 247, 93, 24);
        contentPanel.add(foodconstxt);
        foodconstxt.setColumns(10);

        JLabel label_4 = new JLabel("\u6C34\u7535\u8D39\uFF1A");
        label_4.setBounds(68, 299, 72, 18);
        contentPanel.add(label_4);

        utilityfeetxt = new JTextField();
        utilityfeetxt.setBounds(146, 296, 103, 24);
        contentPanel.add(utilityfeetxt);
        utilityfeetxt.setColumns(10);

        JLabel label_5 = new JLabel("\u533B\u7597\u8D39\u7528\uFF1A");
        label_5.setBounds(303, 299, 87, 18);
        contentPanel.add(label_5);

        Medicaltxt = new JTextField();
        Medicaltxt.setBounds(383, 296, 83, 24);
        contentPanel.add(Medicaltxt);
        Medicaltxt.setColumns(10);

        JLabel label_6 = new JLabel("\u5A31\u4E50\u6D88\u8D39\uFF1A");
        label_6.setBounds(68, 352, 87, 18);
        contentPanel.add(label_6);

        Entertainmenttxt = new JTextField();
        Entertainmenttxt.setBounds(146, 349, 103, 24);
        contentPanel.add(Entertainmenttxt);
        Entertainmenttxt.setColumns(10);

        JLabel label_7 = new JLabel("\u5176\u4ED6\u6536\u5165");
        label_7.setBounds(68, 386, 72, 18);
        contentPanel.add(label_7);

        JLabel label_8 = new JLabel("\u5176\u4ED6\u652F\u51FA");
        label_8.setBounds(303, 386, 72, 18);
        contentPanel.add(label_8);

        JLabel label_9 = new JLabel("\u5907\u6CE8\uFF1A");
        label_9.setBounds(68, 417, 72, 18);
        contentPanel.add(label_9);

        inbztxt = new JTextField();
        inbztxt.setBounds(146, 414, 129, 24);
        contentPanel.add(inbztxt);
        inbztxt.setColumns(10);

        JLabel label_10 = new JLabel("\u6570\u503C\uFF1A");
        label_10.setBounds(68, 458, 72, 18);
        contentPanel.add(label_10);

        insztxt = new JTextField();
        insztxt.setBounds(146, 451, 129, 24);
        contentPanel.add(insztxt);
        insztxt.setColumns(10);

        JLabel label_11 = new JLabel("\u5907\u6CE8\uFF1A");
        label_11.setBounds(303, 417, 72, 18);
        contentPanel.add(label_11);

        JLabel label_12 = new JLabel("\u6570\u503C\uFF1A");
        label_12.setBounds(303, 458, 72, 18);
        contentPanel.add(label_12);

        outbztxt = new JTextField();
        outbztxt.setBounds(363, 414, 129, 24);
        contentPanel.add(outbztxt);
        outbztxt.setColumns(10);

        outsztxt = new JTextField();
        outsztxt.setBounds(363, 455, 129, 24);
        contentPanel.add(outsztxt);
        outsztxt.setColumns(10);

        JButton button = new JButton("\u6CE8\u518C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(checkUser()&&check()){
                    try {
                        String user=usertxt.getText();
                        String pw=mmtxt.getText();
                        String xm=xmtxt.getText();
                        String xb=xbtxt.getText();
                        float wages=Float.parseFloat(wagestxt.getText());
                        float fd=Float.parseFloat(foodconstxt.getText());
                        float fee=Float.parseFloat(utilityfeetxt.getText());
                        float Med=Float.parseFloat(Medicaltxt.getText());
                        float Enter=Float.parseFloat(Entertainmenttxt.getText());
                        float oisz=Float.parseFloat(insztxt.getText());
                        float oosz=Float.parseFloat(outsztxt.getText());
                        float saving=Float.parseFloat(cxtxt.getText());
                        String oi=inbztxt.getText()+insztxt.getText();
                        String oo=outbztxt.getText()+outsztxt.getText();
                        float income=wages+oisz;
                        float outcome=fd+fee+Med+Enter+oosz;
                        addDao addper=new addDao(user,pw,xm,xb,income,outcome,saving,wages,oi,oo,fd,fee,Med,Enter,oisz,oosz);
                        addPerson.super.dispose();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }
            }
        });

        button.setBounds(225, 508, 150, 55);
        contentPanel.add(button);

        JLabel label_1 = new JLabel("\u6CE8\u610F\uFF1A\u8D39\u7528\u7C7B\u5FC5\u987B\u662F\u6570\u5B57\uFF01\uFF01");
        label_1.setBounds(68, 493, 195, 18);
        contentPanel.add(label_1);

        trip = new JLabel("");
        trip.setBounds(404, 526, 142, 18);
        contentPanel.add(trip);

        JLabel label_13 = new JLabel("\u50A8\u84C4\uFF1A");
        label_13.setBounds(303, 352, 72, 18);
        contentPanel.add(label_13);

        cxtxt = new JTextField();
        cxtxt.setBounds(380, 349, 86, 24);
        contentPanel.add(cxtxt);
        cxtxt.setColumns(10);
    }
    public boolean checkUser() {
        if (!allUser.contains(usertxt.getText())) {
            return true;
        }else if(usertxt.getText().length()==0){
            userlbl1.setText("用户名不准为空！");
            return false;
        }
        else {
            userlbl1.setText("用户名已存在！");
            return false;
        }
    }
    public boolean check(){
        if (mmtxt.getText().length()==0||xbtxt.getText().length()==0||xmtxt.getText().length()==0||
                wagestxt.getText().length()==0||foodconstxt.getText().length()==0||
                utilityfeetxt.getText().length()==0||Medicaltxt.getText().length()==0||
                Entertainmenttxt.getText().length()==0||inbztxt.getText().length()==0||
                outbztxt.getText().length()==0||insztxt.getText().length()==0||
                outsztxt.getText().length()==0){
            trip.setText("注意请完善好信息！");
            return false;
        }
        else
            return true;
    }

}

