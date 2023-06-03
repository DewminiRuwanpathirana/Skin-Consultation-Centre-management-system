import java.time.LocalDateTime;

public class Person {
    private String name;        //creating a variable to store names
    private String surname;     //creating a variable to store surnames
    private String dateOfBirth; //creating a variable to store date of birthdays
    private String mobileNumber;//creating a variable to store mobile numbers

    public LocalDateTime startLocalDateTime;  //creating a LocalDateTime variable to store starting dates
    public LocalDateTime endLocalDateTime;    //creating a LocalDateTime variable to store ending dates


    //creating a constructor
    public Person(String name, String surname, String dateOfBirth, String mobileNumber, LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.startLocalDateTime = startLocalDateTime;
        this.endLocalDateTime = endLocalDateTime;
    }

    //creating a get/set methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
