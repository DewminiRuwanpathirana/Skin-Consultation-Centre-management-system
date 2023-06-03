import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creating a WestminsterSkinConsultationManager class object
        WestminsterSkinConsultationManager myclass = new WestminsterSkinConsultationManager();
        //call the loadDoctors() method from WestminsterSkinConsultationManager class
        myclass.loadDoctors();

        //creating a while loop to loop the MENU option
        while (true) {
            System.out.println("""
                                
                                ---------MENU-------------
                                1. Add a new doctor
                                2. Delete a doctor
                                3. Print list of doctors
                                4. Save
                                5. Open GUI
                                6. Exit
                                --------------------------
                                """);

            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            String choice = scanner1.next();

            switch (choice) {
                case "1":
                    myclass.addDoctor();//call the add doctor method from WestminsterSkinConsultationManager class
                    break;
                case "2":
                    myclass.deleteDoctor();//call the delete doctor method from WestminsterSkinConsultationManager class
                    break;
                case "3":
                    myclass.printDoctors();//call the print doctor method from WestminsterSkinConsultationManager class
                    break;
                case "4":
                    myclass.saveDoctors();//call the save doctor method from WestminsterSkinConsultationManager class
                    break;
                case "5":
                    new SkinConsultationCentreGUI();//call the main GUI form
                    break;
                case "6":
                    //Exit from the Menu
                    myclass.saveDoctors();//call the save doctor method from WestminsterSkinConsultationManager class
                    System.out.println("Thank you!");
                    return;
                default:
                    //set a messege to display when the user enter invalid option
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }
}

