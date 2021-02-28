package data;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editTable extends JFrame{

    JTextField txt;
    int row, col;

    JLabel labelName, labelQuantity, labelTable, labelNote;
    JTextField txtName, txtQuantity, txtTable, txtNote;
    JButton btnAdd, btnModify, btnDelete;
    DefaultTableModel dtm;

    //Add functions for manipulate.
    public void initComponents(){
        labelName = new JLabel("Dish Name");
        labelQuantity = new JLabel("Quantity");
        labelTable = new JLabel("Table Number");
        labelNote = new JLabel("Special Note");
        txtName = new JTextField(10);
        txtQuantity = new JTextField(10);
        txtTable = new JTextField(10);
        txtNote = new JTextField(10);
        btnAdd = new JButton("Add");
        btnModify = new JButton("Modify");
        btnDelete = new JButton("Delete");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        panel.add(labelName);
        panel.add(txtName);
        panel.add(labelQuantity);
        panel.add(txtQuantity);
        panel.add(labelTable);
        panel.add(txtTable);
        panel.add(labelNote);
        panel.add(txtNote);
        panel.add(btnAdd);
        panel.add(btnModify);
        panel.add(btnDelete);
        add(panel, BorderLayout.SOUTH);
    }

    // Initialize the table, set columns, allow for inserting rows and select cell.
    editTable() {
        initComponents();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("docs/test_pic.jpg"));
        Object[] header = {"Dish name", "Quantity", "Table number", "Special note", "image"};

        //Replace the value here with order.
        Object[][] data = {{"fish", "2", "2", null, label},
                {"banana", "3", "1", null, label}};

        dtm = new DefaultTableModel(data, header);
        JTable table = new JTable(dtm);
        add(new JScrollPane(table));
        table.setCellSelectionEnabled(true);
        table.getColumn("image").setCellRenderer(new LabelRenderer());
        table.setCellSelectionEnabled(true);
        JScrollPane jsp = new JScrollPane(table);
        add(jsp);

        txt = new JTextField();
        add(txt, BorderLayout.SOUTH);

        ListSelectionModel lsm = table.getSelectionModel();
        lsm.addListSelectionListener(e -> row = table.getSelectedRow());

        table.getColumnModel().getSelectionModel().addListSelectionListener(e -> {
            col = table.getSelectedColumn();
            txt.setText(table.getValueAt(row, col).toString());
        });

        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Allow to insert image to the table, can customize image's size.
    class LabelRenderer implements TableCellRenderer{
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column){
            TableColumn tableColumn = table.getColumn("image");
            tableColumn.setMinWidth(400);
            tableColumn.setMaxWidth(400);
            table.setRowHeight(400);
            return (Component)value;
        }
    }

    public static void main(String...args) {
        new editTable();
    }
}