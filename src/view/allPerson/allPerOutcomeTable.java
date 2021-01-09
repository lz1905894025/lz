package view.allPerson;



import dao.empl.MyDefaultTableModel;
import dao.empl.selectOutcome;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

/**
 * 这里是显示支出表信息的
 */
public class allPerOutcomeTable extends JDialog {

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
            allPerIncomeTable dialog = new allPerIncomeTable();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public allPerOutcomeTable() throws SQLException {

        titles=new Vector<>();
        Collections.addAll(titles,"用户名","姓名","性别","其他支出信息","总支出","食品消费","水电费","医疗费用","娱乐费用","其他支出");

        setTitle("\u6536\u5165\u8868");
        setBounds(100, 100, 745, 539);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel label = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
            label.setBounds(43, 75, 128, 38);
            contentPanel.add(label);
        }
        {
            textField = new JTextField();
            textField.setBounds(153, 82, 128, 24);
            contentPanel.add(textField);
            textField.setColumns(10);
        }

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(43, 142, 586, 292);
            contentPanel.add(scrollPane);

            table = new JTable();
            model=getTableModel();
            table.setModel(model);
            scrollPane.setViewportView(table);


        TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
        table.setRowSorter(sorter);//设置表格的排序器

        JButton button = new JButton("\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String key=textField.getText().trim();//获取输入关键字文本框的值
                if(key.length()!=0) {
                    sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
                }else {
                    sorter.setRowFilter(null);//不过滤，显示所有数据
                }
            }});
        button.setBounds(313, 81, 113, 27);
        contentPanel.add(button);



    }

    public MyDefaultTableModel getTableModel() throws SQLException {
        MyDefaultTableModel model=new MyDefaultTableModel(titles,0);
        Vector<Vector> rows= selectOutcome.Outcome();
        for (Vector row:rows)
            model.addRow(row);
        return model;
    }
}
