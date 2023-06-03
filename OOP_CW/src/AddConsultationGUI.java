import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;

//creating a class for get patient information
public class AddConsultationGUI  {
    JFrame frame = new JFrame("Patient Details Form");         //creating a "frame" to patient details window
    JFrame frame2 = new JFrame("Patient Consultation Details");//creating a "frame2" to patient consultation details shown window
    JFrame frame3 = new JFrame("Additional information");      //creating a "frame3" to Additional information window
    JLabel l1 = new JLabel("-------Patient Details Form-------");
    private static ArrayList<Patient> consultations = new ArrayList<Patient>();//creating an ArrayList to store all the patient details
    private static String patientFile = "patient.txt";//creating a File to store all the patient details

    AddConsultationGUI(){
        l1.setBounds(220,10,400,50);
        l1.setFont(new Font(null,Font.BOLD,16));
        // Creating a panel for form
        JPanel patientPanel = new JPanel();
        patientPanel.setLayout(new GridLayout(14,1,10,10));

        // Add form elements
        patientPanel.add(new JLabel("  Name:"));
        JTextField nameField = new JTextField(20);
        patientPanel.add(nameField);

        patientPanel.add(new JLabel("  Surname:"));
        JTextField surnameField = new JTextField(20);
        patientPanel.add(surnameField);

        patientPanel.add(new JLabel("  Date of Birth:"));
        JTextField dobField = new JTextField(20);
        patientPanel.add(dobField);

        patientPanel.add(new JLabel("  Mobile Number:"));
        JTextField mobileField = new JTextField(20);
        patientPanel.add(mobileField);

        patientPanel.add(new JLabel("  ID:"));
        JTextField idField = new JTextField(20);
        patientPanel.add(idField);

        patientPanel.add(new JLabel("  Select a Doctor:"));
        ArrayList<Doctor> myObject = new ArrayList<Doctor>( WestminsterSkinConsultationManager.doctorsList);
        // Create the combo box
        JComboBox<String> comboBox = new JComboBox<>();

        for (Doctor obj : myObject) {
            comboBox.addItem(obj.getName());
        }
        patientPanel.add(comboBox);

        patientPanel.add(new JLabel("  Consultation year:"));
        JTextField yearField = new JTextField(20);
        patientPanel.add(yearField);

        patientPanel.add(new JLabel("  Consultation month:"));
        JTextField monthField = new JTextField(20);
        patientPanel.add(monthField);

        patientPanel.add(new JLabel("  Consultation day:"));
        JTextField dayField = new JTextField(20);
        patientPanel.add(dayField);

        patientPanel.add(new JLabel("  Consultation start time(Hour):"));
        JTextField sHourTimeField = new JTextField(20);
        patientPanel.add(sHourTimeField);

        patientPanel.add(new JLabel("  Consultation start time(Minute):"));
        JTextField sMinTimeField = new JTextField(20);
        patientPanel.add(sMinTimeField);

        patientPanel.add(new JLabel("  Consultation end time(Hour):"));
        JTextField eHourTimeField = new JTextField(20);
        patientPanel.add(eHourTimeField);

        patientPanel.add(new JLabel("  Consultation end time(Minute):"));
        JTextField eMinTimeField = new JTextField(20);
        patientPanel.add(eMinTimeField);

        //set the button to additional information window
        JButton photobtn = new JButton("In addition: Click here to add a photo or note");

        // Add submit button
        JButton submitButton = new JButton("Submit");

        //set the form layout by adding labels and buttons to the frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,650);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(l1);
        frame.add(patientPanel);
        frame.add(photobtn);
        frame.add(submitButton);

        // Add action listener for submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    // Get form values
                    String name = nameField.getText();
                    String surname = surnameField.getText();
                    String dob = dobField.getText();
                    String mobile = mobileField.getText();
                    int patientId = Integer.parseInt(idField.getText());
                    int consultYear = Integer.parseInt(yearField.getText());
                    int consultMonth = Integer.parseInt(monthField.getText());
                    int consultDate = Integer.parseInt(dayField.getText());
                    int consultsHour = Integer.parseInt(sHourTimeField.getText());
                    int consultsMin = Integer.parseInt(sMinTimeField.getText());
                    int consulteHour = Integer.parseInt(eHourTimeField.getText());
                    int consulteMin = Integer.parseInt(eMinTimeField.getText());

                    //create LocalDateTime objects to store startTime and endTime
                    LocalDateTime datetime1 = LocalDateTime.of(consultYear, consultMonth, consultDate, consultsHour, consultsMin);
                    LocalDateTime datetime2 = LocalDateTime.of(consultYear, consultMonth, consultDate, consulteHour, consulteMin);

                    // Create patient object
                    Patient patient = new Patient(name, surname, dob, mobile, patientId, datetime1, datetime2);

                    //display consultation time slot in the console
                    System.out.println();
                    System.out.println("Consultation Start Time : " + datetime1);
                    System.out.println("Consultation End Time   : " + datetime2);

                    // Add patient object to list
                    consultations.add(patient);

                    //get selected item from the combo box
                    Object selectedItem = comboBox.getSelectedItem();
                    String selectedItemString = (String) selectedItem;
                    System.out.println("Selected Doctor: " + selectedItemString);

                    //check the availability of the doctors
                    for (int i = 0; i < WestminsterSkinConsultationManager.doctorsList.size(); i++) {
                        if (WestminsterSkinConsultationManager.doctorsList.get(i).getName().equals(selectedItemString)) {
                            boolean x = datetime2.isBefore(WestminsterSkinConsultationManager.doctorsList.get(i).endLocalDateTime);
                            boolean y = datetime1.isAfter(WestminsterSkinConsultationManager.doctorsList.get(i).startLocalDateTime);
                            if (x == true && y == true) {
                                System.out.println("You have succesfully consulted Dr." + selectedItemString);
                                break;
                            } else {
                                System.out.println("Dr." + selectedItemString + " is not available for this date and time.");
                                for (int a = 0; a < WestminsterSkinConsultationManager.doctorsList.size(); a++) {
                                    boolean b = datetime2.isBefore(WestminsterSkinConsultationManager.doctorsList.get(a).endLocalDateTime);
                                    boolean c = datetime1.isAfter(WestminsterSkinConsultationManager.doctorsList.get(a).startLocalDateTime);
                                    if (b == true && c == true) {
                                        System.out.println("You will allocate for the Dr." + WestminsterSkinConsultationManager.doctorsList.get(a).getName());
                                        break;
                                    } else {
                                        System.out.println("Sorry! There is no any doctor for this date and time.");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    savePatient();//save all the patient details to File

                    //check the consultation fee
                    for (int i = 0; i < consultations.size(); i++) {
                        if (consultations.get(i).getPatientId() == patientId ){
                            System.out.println("consultation fee: pound " + ((consulteHour - consultsHour)*25));
                            break;
                        }
                        else {
                            System.out.println("consultation fee: pound " + ((consulteHour - consultsHour)*15));
                            break;
                        }
                    }

                    // Close patient information frame
                    frame.dispose();

                    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame2.setSize(500, 500);
                    frame2.setVisible(true);
                    frame2.setLayout(new FlowLayout(FlowLayout.CENTER));

                    //show all the submitted details about consultation
                    JTextArea submittedDetails = new JTextArea(
                            "\t - - - - - Submitted form details - - - - -\n\n\n"
                            + "\tName: " + name + "\n\n"
                            + "\tsurname: " + surname + "\n\n"
                            + "\tDate of Birth: " + dob + "\n\n"
                            + "\tMobile Number: " + mobile + "\n\n"
                            + "\tID: " + patientId + "\n\n"
                            + "\tConsultation date: " + consultYear + "/" + consultMonth + "/" + consultDate + "\n\n"
                            + "\tConsultation Start Time: " + consultsHour + ":" + consultsMin + "\n\n"
                            + "\tConsultation End Time: " + consulteHour + ":" + consulteMin + "\n\n"
                    );
                    submittedDetails.setPreferredSize(new Dimension(500, 600));
                    submittedDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                    submittedDetails.setBackground(Color.lightGray);
                    frame2.add(submittedDetails);
                }
            }

            //creating a method for save all the patient details to File
            private void savePatient() {
                String patientFile = "patient.txt";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(patientFile))) {
                        for (Patient patient : consultations) {
                            writer.write(patient.getName() + "\t" + patient.getSurname() + "\t" + patient.getDateOfBirth()+ "\t" + patient.getMobileNumber()+ "\t" + patient.getPatientId() + "\t" + patient.startLocalDateTime + "\t" + patient.endLocalDateTime + "\n");
                        }
                    } catch (IOException e) {
                        System.out.println("Error saving doctors to file");
                    }
            }
        });

        // Add action listener for submit button
        photobtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == photobtn) {
                JPanel patientPanelForNote = new JPanel();
                patientPanelForNote.setLayout(new GridLayout(1,2,10,10));
                patientPanelForNote.add(new JLabel("  Add Note:"));
                JTextField noteField = new JTextField(20);
                noteField.setPreferredSize(new Dimension(20,50));
                patientPanelForNote.add(noteField);

                JPanel patientPanelPhoto = new JPanel();
                patientPanelPhoto.setLayout(new GridLayout(1,2,5,5));
                patientPanelPhoto.add(new JLabel("  Add a photo: "));
                JButton submit = new JButton("submit");

                // Creating a JFileChooser object
                JFileChooser fileChooser = new JFileChooser();

                // Set the file filter to display only image files
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png", "gif"));

                // Show the file chooser dialog and get the input from user's selection
                int result = fileChooser.showOpenDialog(null);

                // If the user selects a file, load the image file and display it in the GUI form
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File selectedFile = fileChooser.getSelectedFile();

                    // Creating an ImageIcon object from the selected file
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    imageIcon.setImage(imageIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));

                    // Create a JLabel object and set the ImageIcon object as the icon
                    JLabel label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setPreferredSize(new Dimension(200, 200));

                    // Add the JLabel object to the GUI form
                    patientPanelPhoto.add(label);

                }
                frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame3.setSize(500, 400);
                frame3.setVisible(true);
                frame3.setLayout(new FlowLayout(FlowLayout.CENTER));
                frame3.add(patientPanelForNote);
                frame3.add(patientPanelPhoto);
                frame3.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame3.dispose();

                        //Encrypt Note
                        SecretKey key = Encryption.generateKey("AES");
                        Cipher chipher = null;
                        try {
                            chipher = Cipher.getInstance("AES");
                        } catch (NoSuchAlgorithmException ex) {
                            throw new RuntimeException(ex);
                        } catch (NoSuchPaddingException ex) {
                            throw new RuntimeException(ex);
                        }
                        byte[] encryptedData = Encryption.encryptString(noteField.getText(),key,chipher);
                            String encryptedString = new String(encryptedData);
                            System.out.println();
                            System.out.println("Encrypted Note: "+encryptedString);

                            //Decrypt Note
                            String decryptedData = Encryption.decryptData(encryptedData,key,chipher);
                            System.out.println("Decrypted Note: "+decryptedData);
                    }
                });
            }
        }
    });
}

    //creating a method to load all the patient details from the File
    static void loadPatient(){
        try (BufferedReader reader = new BufferedReader(new FileReader(patientFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String name = parts[0];
                String surname = parts[1];
                String dateOfBirth = parts[2];
                String mobileNumber = parts[3];
                int getPatientId = Integer.parseInt(parts[4]);
                LocalDateTime startLocalDateTime = LocalDateTime.parse(parts[5]);
                LocalDateTime endLocalDateTime = LocalDateTime.parse(parts[6]);

                Patient patient = new Patient(name,surname,dateOfBirth,mobileNumber,getPatientId,startLocalDateTime,endLocalDateTime);
                consultations.add(patient);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            // File not found or error reading file
        }
    }
}


