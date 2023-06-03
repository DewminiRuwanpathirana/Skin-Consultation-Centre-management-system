import java.time.LocalDateTime;

public class Consultation {

    private LocalDateTime dateTime;
    private int cost;    //creating a variable to store consultation fee
    private String notes;//creating a variable to store patient notes

    //creating a constructor
    public Consultation(LocalDateTime dateTime, int cost, String notes) {
        this.dateTime = dateTime;
        this.cost = cost;
        this.notes = notes;
    }

    //creating a get/set methods
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
