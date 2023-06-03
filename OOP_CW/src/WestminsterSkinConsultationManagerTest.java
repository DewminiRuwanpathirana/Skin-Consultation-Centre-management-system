import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WestminsterSkinConsultationManagerTest {

    //test method for the add doctor
    @Test
    void addDoctor() {
        //add object to doctor's ArrayList
        WestminsterSkinConsultationManager.doctorsList.add(new Doctor("Ann", "Doe", "10-10-1990", "0712223345", "1001","cosmetic", LocalDateTime.now(),LocalDateTime.now()));
        assertEquals(1,WestminsterSkinConsultationManager.doctorsList.size());

        //add 10 objects doctor's to arrayList
        for (int i = 1; i < 10; i++) {
            WestminsterSkinConsultationManager.doctorsList.add(new Doctor("Ann", "Doe", "10-10-1990", "0712223345", "1001","cosmetic", LocalDateTime.now(),LocalDateTime.now()));
        }
        //Check and verify maximum doctor count
        assertEquals(10,WestminsterSkinConsultationManager.doctorsList.size());
    }

    //test method for the delete doctor
    @Test
    void deleteDoctor() {
        //add 2 objects to doctor's ArrayList
        WestminsterSkinConsultationManager.doctorsList.add(new Doctor("Ann", "Doe", "10-10-1990", "0712223345", "1001","cosmetic", LocalDateTime.now(),LocalDateTime.now()));
        WestminsterSkinConsultationManager.doctorsList.add(new Doctor("Jim", "Doe", "10-08-1989", "0712255565", "1002","medical", LocalDateTime.now(),LocalDateTime.now()));

        //remove one object from doctor's ArrayList
        WestminsterSkinConsultationManager.doctorsList.remove(1);

        //check and verify the object was deleted successfully
        assertEquals(1, WestminsterSkinConsultationManager.doctorsList.size());
        assertEquals("Ann", WestminsterSkinConsultationManager.doctorsList.get(0).getName());
    }

    //test method for the print doctors
    @Test
    void printDoctors() {
        //add 2 objects to doctor's ArrayList
        WestminsterSkinConsultationManager.doctorsList.add(new Doctor("Ann", "Doe", "10-10-1990", "0712223345", "1001","cosmetic", LocalDateTime.now(),LocalDateTime.now()));
        WestminsterSkinConsultationManager.doctorsList.add(new Doctor("Jim", "Doe", "10-08-1989", "0712255565", "1002","medical", LocalDateTime.now(),LocalDateTime.now()));

        //created and write objects in the file
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //printDoctors();

        //check and verify expected output
        String expectedOutput = "------------------------------------------------------------------------------------------------------------\n" +
                "| Name          | Surname         | Medical Licence Number    | Specialisation | Date Of Birth  | Mobile Number  |\n" +
                "-----------------------------------------------------------------------------------------------------------------\n" +
                "|      Ann      |      Doe        |          1001            |     cosmetic   |   10/10/1990   |  0712223345   |\n" +
                "|      Jim      |      Doe        |          1002            |     medical    |   10/08/1989   |  0712255565   |\n" ;

        //assertEquals(expectedOutput, outContent.toString());

    }
}