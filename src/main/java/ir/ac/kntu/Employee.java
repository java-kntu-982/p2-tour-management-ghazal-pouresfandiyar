package ir.ac.kntu;

public class Employee extends User{
    private Date dateOfEmployment;
    private long wage;

    public Employee(String userName, String password) {
        super(userName, password);
    }
}
