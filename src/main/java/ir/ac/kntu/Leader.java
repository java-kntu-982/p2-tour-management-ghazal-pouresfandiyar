package ir.ac.kntu;
import java.util.ArrayList;
import java.util.List;

public class Leader extends User{
    private String firstName;
    private String lastName;
    private long creditId;
    private Date dateOfBirth;
    private Date dateOfEmployment;
    private boolean married;
    private List<String> regionOfLeader;
    private int age;
    public List<Date> fullDay=new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public List<String> getRegionOfLeader() {
        return regionOfLeader;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreditId(long creditId) {
        this.creditId = creditId;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setRegionOfLeader(List<String> regionOfLeader) {
        this.regionOfLeader = regionOfLeader;
    }

    public List<Date> getFullDay() {
        return fullDay;

    }

    public Leader(String firstName, String lastName, long creditId, Date dateOfBirth, Date dateOfEmployment, boolean married, List<String> regionOfLeader){
        this.firstName=firstName;
        this.lastName=lastName;
        this.creditId=creditId;
        this.dateOfBirth=dateOfBirth;
        this.dateOfEmployment=dateOfEmployment;
        this.married=married;
        this.regionOfLeader=regionOfLeader;
    }
}

