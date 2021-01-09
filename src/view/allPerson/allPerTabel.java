package view.allPerson;



import bean.Personal;
import dao.empl.MyDefaultTableModel;
import dao.empl.deleteDAO;
import util.getAllMSG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * 这里是显示所有数据信息的
 */
class allPerTable extends JDialog {
    private JTable table;
    private JTextField cztxt;
    private JScrollPane scrollPane;
    private MyDefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            allPerTable dialog = new allPerTable();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * Create the dialog.
     */
    public allPerTable() throws SQLException {
        setTitle("\u5168\u90E8\u4FE1\u606F");
        setBounds(100, 100, 1094, 593);
        getContentPane().setLayout(null);
        {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(0, 113, 1026, 323);
            getContentPane().add(scrollPane);
            {
                table = new JTable();
                scrollPane.setViewportView(table);
            }
        }

        Vector<String> titles=new Vector<>();
        Collections.addAll(titles,"用户名","密码","姓名","性别","工资","其他收入备注","其他收入总和","食品消费","水电费","医疗费用","娱乐消费","其他支出备注","其他支出总和","收入","支出","余额即储蓄");
        model=new MyDefaultTableModel(titles, 0);

        JTable table=new JTable();
        table.setModel(model);
        Vector<Vector> rows=initTable();
        for(Vector row:rows){
            model.addRow(row);
        }




        table.setAutoCreateRowSorter(true);
        scrollPane.setViewportView(table);


        JLabel label = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\u8FDB\u884C\u67E5\u627E:");
        label.setBounds(14, 13, 155, 34);
        getContentPane().add(label);

        cztxt = new JTextField();
        cztxt.setBounds(183, 18, 86, 24);
        getContentPane().add(cztxt);
        cztxt.setColumns(10);


        TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
        table.setRowSorter(sorter);//设置表格的排序器


        JButton czbtn = new JButton("\u67E5\u627E");
        czbtn.setBounds(282, 17, 100, 27);
        czbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String key=cztxt.getText().trim();//获取输入关键字文本框的值
                if(key.length()!=0) {
                    sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
                }else {
                    sorter.setRowFilter(null);//不过滤，显示所有数据
                }
            }
        });
        getContentPane().add(czbtn);

        JButton pxbtn = new JButton("\u6309\u6570\u503C\u8FDB\u884C\u6392\u5E8F");
        pxbtn.setBounds(396, 17, 155, 27);
        getContentPane().add(pxbtn);



        JButton scbtn = new JButton("\u5220\u9664");
        scbtn.setBounds(565, 17, 100, 27);
        scbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
                if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "",    JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
                    String user=(String)model.getValueAt(table.getSelectedRow(),0);
                    try {
                        System.out.println(user);
                        new deleteDAO().sc(user);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
                    //从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
                } else {
                    JOptionPane.showMessageDialog(null, "请选择要删除的行");
                }
            }
            }
        });
        getContentPane().add(scbtn);

        JButton gxbtn = new JButton("\u66F4\u65B0");
        gxbtn.setBounds(679, 17, 113, 27);
        getContentPane().add(gxbtn);




    }

    public static Vector<Vector> initTable() throws SQLException {
        getAllMSG allmsg=new getAllMSG();
        ArrayList<Personal> row1=new ArrayList<>();
        row1= allmsg.getAll();
        Vector<Vector> rows=new Vector<>();
        for(Personal per:row1){
            Vector<Object> row=new Vector<>();
            row.add(per.getUser());
            row.add(per.getPassword());
            row.add(per.getXm());
            row.add(per.getXb());
            row.add(per.getWages());
            row.add(per.getInRemark());
            row.add(per.getOtherIncome());
            row.add(per.getFoodcons());
            row.add(per.getUtilityfee());
            row.add(per.getMedical());
            row.add(per.getEntertainment());
            row.add(per.getOutRemark());
            row.add(per.getOtherOutcome());
            row.add(per.getIncome());
            row.add(per.getOutcome());
            row.add(per.getSaving());
            rows.add(row);
        }
        return rows;
    }
}
