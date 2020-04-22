package ir.ac.kntu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        super();
        this.firstName=firstName;
        this.lastName=lastName;
        this.creditId=creditId;
        this.dateOfBirth=dateOfBirth;
        this.dateOfEmployment=dateOfEmployment;
        this.married=married;
        this.regionOfLeader=regionOfLeader;
    }
    public static void leaderMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("What do you want to do?");
        System.out.println("1- Show the list of all leaders");
        System.out.println("2- Add new leader");
        System.out.println("3- Remove leader");
        System.out.println("4- Edit leader's information");
        System.out.println("5- Search a special leader");
        System.out.println("6- Back to Menu");
    }
    public static void searchLeaderMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("What kind of search do you want to do?");
        System.out.println("1- Based on first name");
        System.out.println("2- Based on last name");
        System.out.println("3- Based on region's name");
        System.out.println("4- Based on age");
        System.out.println("5- Back to last menu");
    }
    public static void editLeader(){
        System.out.println("_____________________________________________________");
        System.out.println("Enter the number of the object that you want edit");
        System.out.println("1- First name");
        System.out.println("2- Last name");
        System.out.println("3- Credit ID");
        System.out.println("4- Date of birth");
        System.out.println("5- Date of employment");
        System.out.println("6- Is she/he married?");
        System.out.println("7- Region of leaders");
        System.out.println("8- Shifts' days");
    }
    public static void ageMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("How do you want search?");
        System.out.println("1- A special age");
        System.out.println("2- More than a special age");
        System.out.println("3- Less than a special age");
        System.out.println("4- Between two special ages");
        System.out.println("5- Back to last menu");
    }
    public static int mainLeaderSearch(String firstName,String lastName,List<Leader> leaderList){
        for(int i = 0; i < leaderList.size(); i++) {
            if(firstName.equals(leaderList.get(i).getFirstName()) && lastName.equals(leaderList.get(i).getLastName())){
                return i;
            }
        }
        return -1;
    }
    public static void searchLeaderByFirstName(String firstName,List<Leader> leaderList){
        for(int i = 0; i < leaderList.size(); i++) {
            if(firstName.equals(leaderList.get(i).getFirstName())){
                System.out.println("* "+leaderList.get(i).getFirstName()+" "+leaderList.get(i).getLastName());
            }
        }
    }
    public static void searchLeaderByLastName(String lastName,List<Leader> leaderList){
        for(int i = 0; i < leaderList.size(); i++) {
            if(lastName.equals(leaderList.get(i).getLastName())){
                System.out.println("* "+leaderList.get(i).getFirstName()+" "+leaderList.get(i).getLastName());
            }

        }
    }
    public static void searchLeaderByAge(int choice,List <Leader> leaderList){
        Scanner scan=new Scanner(System.in);
        switch(choice){
            case 1://a special age
                System.out.println("Enter age:");
                int age=scan.nextInt();
                for(int i = 0; i < leaderList.size(); i++) {
                    if (age == leaderList.get(i).getAge()) {
                        System.out.println("* "+leaderList.get(i).getFirstName() + " " + leaderList.get(i).getLastName());
                    }
                }
                break;
            case 2:// more than a special age
                System.out.println("Enter age:");
                age=scan.nextInt();
                for(int j = 0; j < leaderList.size(); j++) {
                    if (leaderList.get(j).getAge() > age) {
                        System.out.println("* "+leaderList.get(j).getFirstName() + " " + leaderList.get(j).getLastName());
                    }
                }
                break;
            case 3:// less than a special age
                System.out.println("Enter age:");
                age = scan.nextInt();
                for (int k = 0; k < leaderList.size(); k++) {
                    if (leaderList.get(k).getAge() < age) {
                        System.out.println("* "+leaderList.get(k).getFirstName() + " " + leaderList.get(k).getLastName());
                    }
                }
                break;
            case 4://between 2 special age
                System.out.println("Enter minAge:");
                int minAge = scan.nextInt();
                System.out.println("Enter maxAge:");
                int maxAge = scan.nextInt();
                for (int l = 0; l < leaderList.size(); l++) {
                    if (leaderList.get(l).getAge() < maxAge && leaderList.get(l).getAge() > minAge) {
                        System.out.println("* "+leaderList.get(l).getFirstName() + " " + leaderList.get(l).getLastName());
                    }
                }
                break;
            default:
                break;
        }
    }
    public static void showLeaders(List<Leader> leaderList){
        boolean bool=false;
        for(int i = 0; i < leaderList.size(); i++) {
            System.out.println((i+1)+"- "+leaderList.get(i).getFirstName()+" "+leaderList.get(i).getLastName());
            bool=true;
        }
        if(bool==false){
            System.out.println("There isn't any leader!");
        }
    }
    public static Leader scanLeader(int currentYear){
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter first name and last name:");
        String firstName=scan.next();
        String lastName=scan.next();
        System.out.println("Enter credit ID:");
        long creditId=scan.nextLong();
        System.out.println("Enter date of birth(day month year):");
        int dayOfBirth=scan.nextInt();
        int monthOfBirth=scan.nextInt();
        int yearOfBirth=scan.nextInt();
        Date dateOfBirth= new Date(yearOfBirth,monthOfBirth,dayOfBirth);
        System.out.println("Enter date of employment(day month year):");
        int dayOfEmployment=scan.nextInt();
        int monthOfEmployment=scan.nextInt();
        int yearOfEmployment=scan.nextInt();
        Date dateOfEmployment = new Date(yearOfEmployment,monthOfEmployment,dayOfEmployment);
        System.out.println("Is she/he married?(Enter boolean)");
        boolean married=scan.nextBoolean();
        List<String> regionOfLeader=new ArrayList<>();
        System.out.println("How many regions does he/she know?");
        int num=scan.nextInt();
        System.out.println("Enter the name of regions:");
        for(int i=0;i<num;i++){
            regionOfLeader.add(scan.next());
        }
        Leader leader=new Leader(firstName,lastName,creditId,dateOfBirth,dateOfEmployment,married,regionOfLeader);
        leader.setAge((currentYear-yearOfBirth));
        return leader;
    }

}

