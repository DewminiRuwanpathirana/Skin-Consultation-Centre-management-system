import java.time.LocalDateTime;
public class Patient extends Person{
    private int patientId; //creating a variable to store patient IDs

    //creating a constructor with super class
    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, int patientId, LocalDateTime startLocalDateTime , LocalDateTime  endtLocalDateTime) {
        super(name, surname, dateOfBirth, mobileNumber,startLocalDateTime,endtLocalDateTime);
        this.patientId = patientId;
    }

    //creating a get/set methods
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}