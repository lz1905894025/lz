package view.allPerson;


import dao.empl.MyDefaultTableModel;
import dao.empl.selectUser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * 这里是显示所有用户信息的
 */
class allPerUserTable extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTable table;
    private Vector<String> titles;
    private MyDefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            allPerUserTable dialog = new allPerUserTable();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public allPerUserTable() throws SQLException {
        titles=new Vector<>();
        Collections.addAll(titles,"用户名","密码","姓名","性别","总收入","总支出","余额");


        setTitle("\u7528\u6237\u4FE1\u606F\u8868");
        setBounds(100, 100, 761, 504);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
        label.setBounds(14, 64, 131, 38);
        contentPanel.add(label);

        textField = new JTextField();
        textField.setBounds(105, 71, 131, 24);
        contentPanel.add(textField);
        textField.setColumns(10);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 146, 669, 257);
        contentPanel.add(scrollPane);

        long start = System.currentTimeMillis();


        table = new JTable();
        model=getTableModel();
        table.setModel(model);
        scrollPane.setViewportView(table);

        long end = System.currentTimeMillis();
        System.out.println(end-start);

        TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
        table.setRowSorter(sorter);//设置表格的排序器

        JButton button = new JButton("\u67E5\u8BE2");
        button.setBounds(272, 70, 113, 27);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String key=textField.getText().trim();//获取输入关键字文本框的值
                if(key.length()!=0) {
                    sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
                }else {
                    sorter.setRowFilter(null);//不过滤，显示所有数据
                }
            }
        });
        contentPanel.add(button);




    }

    public MyDefaultTableModel getTableModel() throws SQLException {
        MyDefaultTableModel model=new MyDefaultTableModel(titles,0);
        Vector<Vector> rows=selectUser.User();
        for (Vector row:rows)
            model.addRow(row);
        return model;

    }
}
