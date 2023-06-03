import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DoctorTableModel extends AbstractTableModel {

    private String[] columnNames = { "Name", "Surname", "Date Of Birth ", "Mobile Number", "Medical Licence Number", "Specialisation" };//set the table headers to the list
    private ArrayList<Doctor> doclist; //creating an ArrayList to add doctors details
    public DoctorTableModel(ArrayList<Doctor> newList) {
        doclist = newList;
    }


    //method to count number of columns
    public int getColumnCount() {
        return columnNames.length;
    }
    //method to count number of rows
    public int getRowCount() {
        return doclist.size();
    }

    //set the column data
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = doclist.get(row).getName();
        }
        else if (col == 1) {
            temp = doclist.get(row).getSurname();
        }
        else if (col == 2) {
            temp = doclist.get(row).getDateOfBirth();
        }
        else if (col == 3) {
            temp = doclist.get(row).getMobileNumber();
        }
        else if (col == 4) {
            temp = doclist.get(row).getMedicalLicenceNumber();
        }
        else if (col == 5) {
            temp = doclist.get(row).getSpecialisation();
        }
        return temp;
    }

    //set the column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Component setVisible(boolean b) {
        return null;
    }
}






































///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import java.util.ArrayList;
//import javax.swing.table.AbstractTableModel;
//
//public class DoctorTableModel extends AbstractTableModel{
//
//
//    private String[] columnNames = {"Name","Surname","DOB"};
//    private ArrayList<Doctor> list;
//
//    public DoctorTableModel(ArrayList<Person> list) {
//    }
//
//    public void DoctorTableModel(ArrayList<Doctor> doctorList){
//        list = doctorList;
//    }
//
//    @Override
//    public int getRowCount() {
//        return list.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return columnNames.length;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Object temp = null;
//        if (columnIndex == 0) {
//            temp = list.get(rowIndex).getName();
//        }
//        else if (columnIndex == 1) {
//            temp = list.get(rowIndex).getSurname();
//        }
//        else if (columnIndex == 2) {
//            temp = list.get(rowIndex).getDateOfBirth();
//        }
//        return temp;
//
//    }
//
//    // needed to show column names in JTable
//    public String getColumnName(int col) {
//        return columnNames[col];
//    }
//
////   public Class getColumnClass(int col) {
////      if (col == 2) {
////         return Double.class;
////      }
////      else {
////         return String.class;
////      }
////   }
//
//}
//
