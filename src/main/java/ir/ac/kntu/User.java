package ir.ac.kntu;

import java.util.List;
import java.util.Scanner;

public class User {
    private String userName;
    private String password;
    private String emial;
    private String mobile;
    private Access access=Access.NONE;

    public void setAccess(Access access) {
        this.access = access;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Access getAccess() {
        return access;
    }

    public User(){}
    public User(String password){
        this.password=password;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public User(String userName,String password,Access access){
        this.userName=userName;
        this.password=password;
        this.access=access;
    }
    public static boolean checkMobile(String mobile) {
        String regex = "^[0][9][0-9]{9}$";
        return mobile.matches(regex);
    }
    public static void userMenu() {
        System.out.println("_____________________________________________________");
        System.out.println("What are you going to do?");
        System.out.println("1- Add new user");
        System.out.println("2- Edit users");
        System.out.println("3- Remove user");
        System.out.println("4- Back to last menu");
    }
    public static User scanUser(){
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter username:");
        String userName=scan.next();
        System.out.println("Enter the password");
        String password=scan.next();
        User user = new User(userName, password);
        return user;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public void setmobile(String mobile) {
        this.mobile = mobile;
    }

    public static int mainUserSearch(String userName, List<User> userList){
        for(int i = 0; i < userList.size(); i++) {
            if(userName.equals(userList.get(i).getUserName())){
                return i;
            }
        }
        return -1;
    }
}
