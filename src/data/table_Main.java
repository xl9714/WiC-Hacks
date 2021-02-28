package data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.*;

public class table_Main {

    public void add_column(){

    }

    public void insert_row(String dish_name, int quantity, int table_number, String note){

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Orders");
        JTable table = new JTable();
        //Need to change value
        DefaultTableModel tableModel = new DefaultTableModel(0, 0);
        JButton okButton = new JButton("OK");

//        tableModel.addColumn("Dish name");
//        tableModel.addColumn("Quantity");
//        tableModel.addColumn("Table number");
//        tableModel.addColumn("Special note");
//        tableModel.insertRow(0, new Object[]{"fish"});
//        tableModel.insertRow(0, new Object[]{1});
//        tableModel.insertRow(0, new Object[]{1});
//        tableModel.insertRow(0, new Object[]{null});

        Object[] colomn = {"Dish name", "Quantity", "Table number", "Special note"};
        tableModel.setColumnIdentifiers(colomn);

        table.setModel(tableModel);

        Object[] row = new Object[4];
        tableModel.addRow(row);

        okButton.addActionListener(new ActionListener(){
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentRow = table.getSelectedRow();
                int currentColumn = table.getSelectedColumn();
                JOptionPane.showMessageDialog(null, "Finished: " +
                        table.getValueAt(currentRow, currentColumn));
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.add(table, 0, 0);
        frame.add(okButton, 0 ,1);
        frame.setVisible(true);
    }
}
