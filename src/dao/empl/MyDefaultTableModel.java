package dao.empl;


import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * 此类用于表格数据按数字排序
 */
public class MyDefaultTableModel extends DefaultTableModel {
    public MyDefaultTableModel() {
    }

    public MyDefaultTableModel(Vector<?> columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public MyDefaultTableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
        super(data, columnNames);
    }

    //使用Vector装载表格数据模型，覆写getColumnClass方法，实现按数值排序
    public Class getColumnClass(int column) {
        Class returnValue;
        if ((column >= 0) && (column < getColumnCount())) {
            returnValue = getValueAt(0, column).getClass();
        } else { returnValue = Object.class; }
        return returnValue;
    }
}

