import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
         static String doctorsFile = "doctors.txt"; //Creating a File to store details about doctors
         static final int maxDoctorsCount = 10; //Create a variable and set the maximum doctors count as 10
         static List<Doctor> doctorsList = new ArrayList<>(); //Creating a ArrayList for store details about doctors
         static Scanner scanner1 = new Scanner(System.in); //Creating a static scanner to get inputs in whole class

         //Method for add doctors to the system
         public void addDoctor() {
             if (doctorsList.size() >= maxDoctorsCount) {
                 System.out.println("Cannot add more doctors. Maximum number of doctors reached!");
                 return;
             }
             System.out.print("Enter Doctor's name         : ");
             String name = scanner1.next();
             System.out.print("Enter Doctor's surname      : ");
             String surname = scanner1.next();
             System.out.print("Enter Doctor's date Of Birth: ");
             String dateOfBirth = scanner1.next();
             System.out.print("Enter Doctor's mobileNumber : ");
             String mobileNumber = scanner1.next();
             System.out.print("Enter MedicalLicenceNumber  : ");
             String medicalLicenceNumber = scanner1.next();
             System.out.print("Enter specialization        : ");
             String specialization = scanner1.next();
             int sYear;
             int sMonth;
             int sDate;
             int eYear;
             int eMonth;
             int eDate;
             int sHour;
             int eHour;
             int min = 0;

             System.out.println();
             System.out.println("--Enter doctor's available time period for the consultation-- ");

             while (true){
                 try {
                     System.out.print("Enter consultation start year : ");
                     sYear = scanner1.nextInt();
                     System.out.print("                         Month: ");
                     sMonth = scanner1.nextInt();
                     System.out.print("                         Date : ");
                     sDate = scanner1.nextInt();
                     System.out.println();
                     System.out.print("Enter consultation end year   : ");
                     eYear = scanner1.nextInt();
                     System.out.print("                       Month  : ");
                     eMonth = scanner1.nextInt();
                     System.out.print("                       Date   : ");
                     eDate = scanner1.nextInt();
                     System.out.println();
                     System.out.print("Enter consultation start time(Hour): ");
                     sHour = scanner1.nextInt();
                     System.out.print("Enter consultation end time(Hour)  : ");
                     eHour = scanner1.nextInt();
                     break;
                 }catch (Exception e){
                     System.out.println("Integer Required! Please enter the number ");
                     scanner1.next();
                 }
             }

             LocalDateTime startDate = LocalDateTime.of(sYear, sMonth, sDate, sHour, min);
             LocalDateTime endtDate = LocalDateTime.of(eYear, eMonth, eDate, eHour, min);

             Doctor obj1 = new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenceNumber, specialization, startDate, endtDate);
             doctorsList.add(obj1);
             System.out.println();
             System.out.println("Dr." +name+ " was successfully added to the system" );
             saveDoctors();
         }

        //Method for delete doctors from the system
        public void deleteDoctor(){
            printDoctors();//call the method to display all the available doctors
            System.out.print("Enter the Doctor's medicalLicenceNumber: ");
            String medicalLicenceNumber = scanner1.next();
            try{
                boolean found = false;
            for(Doctor doct:doctorsList){        //check in book array for given isbn
                if(doct.getMedicalLicenceNumber().equals(medicalLicenceNumber)){
                    found = true;
                    System.out.println(medicalLicenceNumber +" Doctor is successfully deleted! ");
                    System.out.println();
                    System.out.println("----------Deleted Doctor's details-------------" +
                                    "\nName                    :" + doct.getName() +" "+doct.getSurname()+
                                    "\nDate Of Birth           :" + doct.getDateOfBirth() +
                                    "\nMobile Number           :" + doct.getMobileNumber() +
                                    "\nMedical Licence Number  :" + doct.getMedicalLicenceNumber() +
                                    "\nSpecialisation          :" + doct.getSpecialisation() +
                                    "\nConsultation start date :" + doct.startLocalDateTime +
                                    "\nConsultation start date :" + doct.endLocalDateTime +
                                    "\n-----------------------------------------------");

                    doctorsList.remove(doct); // remove item from the arraylist
                    System.out.println();
                    System.out.println("Available doctor count is: " + doctorsList.size() );
                    saveDoctors();
                }
            }
            if (!found ){
                System.out.println("Not founded");}
            }catch(ConcurrentModificationException ex){}
        }

         //Method for print the list of doctors
         public void printDoctors(){
             ArrayList<Doctor> myObject = new ArrayList<Doctor>(doctorsList);
                     Collections.sort(myObject, new Comparator<Doctor>() {
                         @Override
                         public int compare(Doctor p1, Doctor p2) {
                             return p1.getSurname().compareTo(p2.getSurname());
                         }
                     });

             System.out.println("------------------------------------------------------------------------------------------------------------");
             System.out.printf("%1s %15s %32s %10s %10s %10s", "| Name", "| Surname", "| Medical Licence Number", "| Specialisation", "| Date Of Birth ", "| Mobile Number  |");
             System.out.println("\n------------------------------------------------------------------------------------------------------------");

             for(Doctor doctor : myObject)
             {
                 System.out.format("|%13s %17s %24s %16s %16s %16s", doctor.getName()+" |" , doctor.getSurname()+" |" , doctor.getMedicalLicenceNumber()+" |" , doctor.getSpecialisation()+" |" , doctor.getDateOfBirth()+" |" , doctor.getMobileNumber()+" |" );
                 System.out.println();
             }
             System.out.println("------------------------------------------------------------------------------------------------------------");
         }

        //Method for save doctors to the file
        public void saveDoctors(){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(doctorsFile))) {
                    for (Doctor doctor : doctorsList) {
                        writer.write(doctor.getName() + "\t" + doctor.getSurname() + "\t" + doctor.getDateOfBirth()+ "\t" + doctor.getMobileNumber()+ "\t" + doctor.getMedicalLicenceNumber() +"\t" + doctor.getSpecialisation() +"\t" + doctor.startLocalDateTime +"\t" + doctor.endLocalDateTime + "\n");
                    }
                } catch (IOException e) {
                    System.out.println("Error saving doctors to file");
                }
            }

        //Method for load doctors from the file
        public void loadDoctors(){
            try (BufferedReader reader = new BufferedReader(new FileReader(doctorsFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\t");
                        String name = parts[0];
                        String surname = parts[1];
                        String dateOfBirth = parts[2];
                        String mobileNumber = parts[3];
                        String medicalLicenceNumber = parts[4];
                        String specialization = parts[5];
                        LocalDateTime startLocalDateTime = LocalDateTime.parse(parts[6]);
                        LocalDateTime endLocalDateTime = LocalDateTime.parse(parts[7]);

                        Doctor doctor = new Doctor(name,surname,dateOfBirth,mobileNumber,medicalLicenceNumber,specialization,startLocalDateTime,endLocalDateTime);
                        doctorsList.add(doctor);
                    }
                } catch (IOException | ArrayIndexOutOfBoundsException e) {
                    // File not found or error reading file
                }
            }
        }
