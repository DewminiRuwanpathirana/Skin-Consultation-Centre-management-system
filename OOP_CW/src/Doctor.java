import java.time.LocalDateTime;
public class Doctor extends Person {
    private String medicalLicenceNumber; //creating a variable to store Doctor's medical licence numbers
    private String specialisation;//creating a variable to store Doctor's specialisations


    //creating a constructor with super class
    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialisation, LocalDateTime startLocalDateTime , LocalDateTime  endtLocalDateTime) {
        super(name, surname, dateOfBirth, mobileNumber,startLocalDateTime,endtLocalDateTime);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }


    //creating a get/set methods
    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

}