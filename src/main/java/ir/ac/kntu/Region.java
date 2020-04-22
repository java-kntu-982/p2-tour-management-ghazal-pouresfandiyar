package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Region {
    private String name;
    private List<String> subRegion;

    public String getName() {
        return name;
    }

    public List<String> getSubRegion() {
        return subRegion;
    }

    public Region(String name, List<String> subRegion) {
        this.name = name;
        this.subRegion=subRegion;
    }
    public static void editRegion(){
        System.out.println("_____________________________________________________");
        System.out.println("Enter the number of the object that you want edit");
        System.out.println("1- Name of the region");
        System.out.println("2- SubRegions");
    }
    public static void regionMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("What do you want to do?");
        System.out.println("1- Show all regions");
        System.out.println("2- Add new region");
        System.out.println("3- Edit a region");
        System.out.println("4- Remove a region");
        System.out.println("5- Back to last menu");
    }
    public static List<String> scanSubRegion(){
        Scanner scan =new Scanner(System.in);
        List<String> subRegions = new ArrayList<>();
        System.out.println("How many subRegion does it have?(It should be at least one)");
        int num=scan.nextInt();
        System.out.println("Enter name of subRegions(use _ instead replace in the name of 1 subRegion) ");
        for(int i=0;i<num;i++){
            subRegions.add(scan.next());
        }
        return subRegions;
    }
    public static int mainRegionSearch(String regionName,List<Region> regionList){
        for(int i = 0; i < regionList.size(); i++) {
            if(regionName.equals(regionList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }
    public static void showRegions(List<Region> regionList){
        boolean bool=false;
        for(int i = 0; i < regionList.size(); i++) {
            System.out.println((i+1)+"- "+regionList.get(i).getName());
            bool=true;
        }
        if(bool==false){
            System.out.println("There isn't any region!");
        }
    }
}