import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DoctorTable extends JFrame {
    private JTable myTable;//creating a JTable object
    private DoctorTableModel tableModel;
    private ArrayList<Doctor> list;//creating an ArrayList for store doctors details

    //creating a constructor with JFrame
    public DoctorTable(ArrayList<Doctor> list) {
        this.list = list;
        tableModel = new DoctorTableModel(list);
        myTable = new JTable(tableModel);

        setBounds(10, 10, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(820, 350));

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);
        this.setSize(600,600);
    }

}