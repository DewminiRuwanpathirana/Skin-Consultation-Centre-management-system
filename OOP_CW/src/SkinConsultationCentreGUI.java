import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SkinConsultationCentreGUI extends JFrame implements ActionListener  {
    JFrame frame = new JFrame(); //creating JFrame for main GUI interface
    JLabel jlbl1 = new JLabel("Westminster Skin Consultation Centre"); //creating JLable for set the title in main GUI interface
    JButton jbtn1 = new JButton("View All Doctors"); //creating JButton for 'view all doctors' in main GUI interface
    JButton jbtn2 = new JButton("Add Consultation"); //creating JButton for 'Add Consultation' in main GUI interface
    JButton jbtn3 = new JButton("Exit"); //creating JButton for 'Exit' in main GUI interface

    public SkinConsultationCentreGUI(){
        AddConsultationGUI.loadPatient();//call the loadPatient() method to load all the patient details to ArrayList

        //creating the GUI interface by adding labels and buttons
        jlbl1.setBounds(50,50,400,50);
        jlbl1.setFont(new Font("MV Boli",Font.BOLD,20));
        jlbl1.setVerticalAlignment(JLabel.TOP);
        jlbl1.setHorizontalAlignment(JLabel.CENTER);

        jbtn1.setBounds(130,160,200,40);
        jbtn1.setFocusable(false);
        jbtn1.addActionListener(this);
        jbtn1.setHorizontalAlignment(JButton.CENTER);

        jbtn2.setBounds(130,250,200,40);
        jbtn2.setFocusable(false);
        jbtn2.addActionListener(this);
        jbtn2.setHorizontalAlignment(JButton.CENTER);

        jbtn3.setBounds(130,340,200,40);
        jbtn3.setFocusable(false);
        jbtn3.addActionListener(this);
        jbtn3.setHorizontalAlignment(JButton.CENTER);

        //set Background image
        frame.setLayout(new BorderLayout());
        frame.setContentPane(new JLabel(new ImageIcon("I:\\CW OOP\\OOP_CW\\oop_img6.png")));

        //Set labels and buttons to the Frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setTitle("Westminster Skin Consultation Centre");
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(jlbl1);
        frame.add(jbtn1);
        frame.add(jbtn2);
        frame.add(jbtn3);
    }

    //main method to run the Main GUI
    public static void main(String[] args) {
        new SkinConsultationCentreGUI();
    }

    //Set actions to the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        //'view all doctors' Button
        if (e.getSource()==jbtn1){
            DoctorTable doctorTable = new DoctorTable((ArrayList<Doctor>) WestminsterSkinConsultationManager.doctorsList);
            doctorTable.setSize(850,400);
            doctorTable.setVisible(true);
        }

        //'Add Consultation' Button
        if (e.getSource()==jbtn2){
              AddConsultationGUI addConsultationGUI = new AddConsultationGUI();
        }

        //'Exit' Button
        if (e.getSource()==jbtn3){
            frame.dispose();
        }
    }
}