package ir.ac.kntu;

import java.util.Scanner;

public class Employee extends User{
    private Date dateOfEmployment;
    private long wage;

    public Employee(String userName, String password,Date dateOfEmployment,long wage) {
        super(userName, password);
        this.dateOfEmployment=dateOfEmployment;
        this.wage=wage;
    }
    public static Employee scanEmployee(String username,String password){
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter date of employment(day month year):");
        int dayOfEmployment=scan.nextInt();
        int monthOfEmployment=scan.nextInt();
        int yearOfEmployment=scan.nextInt();
        Date dateOfEmployment = new Date(yearOfEmployment,monthOfEmployment,dayOfEmployment);
        System.out.println("Enter the wage:");
        long wage=scan.nextLong();
        Employee employee=new Employee(username,password,dateOfEmployment,wage);
        return employee;
    }
}

