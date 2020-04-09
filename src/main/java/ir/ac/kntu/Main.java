package ir.ac.kntu;
import ir.ac.kntu.maputil.MapUtil;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/**
 * @author Ghazal pouresfandiyar
 * @version 9.0
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List <Leader> leaderList  = new ArrayList<>();
        List <Tour> tourList  = new ArrayList<>();
        List<Tour> kindsOfTours = new ArrayList<>();
        List <Region> regionList = new ArrayList<>();
        List<String> subRegionList=new ArrayList<>();
        System.out.println("Enter the current year:");
        int currentYear=scan.nextInt();
        boolean exit0 = false ,exit1 = false ,exit2 = false ,exit3 = false,exit4 = false ,exit5 = false ,exit6 = false ,exit7 = false;
        while(true) {
            menu();
            int choice1 = scan.nextInt();
            switch (choice1) {
                case 1://handle tours
                    while (exit6 == false) {
                        tourMenu();
                        int choice0 = scan.nextInt();
                        switch (choice0) {
                            case 1://Show kinds of tours
                                showKindsOfTours(kindsOfTours);
                                break;
                            case 2://show all tours with details
                                showToursInformation(tourList);
                                break;
                            case 3://Add new kind of tour
                                kindsOfTours.add(scanKindsOfTour(regionList));
                                break;
                            case 4://Add new tour
                                tourList.add(scanTour(regionList,leaderList));
                                break;
                            case 5://Remove tour
                                System.out.println("Enter name of the tour and it's identifier:(it should be a space between them)");
                                String tourName = scan.next();
                                int identifier = scan.nextInt();
                                int index = mainTourSearch(tourName, identifier, tourList);
                                if (index >= 0) {
                                    tourList.remove(tourList.get(index));
                                } else {
                                    System.out.println("Not found!");
                                }
                                break;
                            case 6://Edit kinds of tours
                                System.out.println("Enter tour's name:");
                                tourName = scan.next();
                                index = mainKindsOfToursSearch(tourName, tourList);
                                if (index >= 0) {
                                    editKindOfTour();
                                    int choice = scan.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("Enter new name:");
                                            String name = scan.next();
                                            kindsOfTours.get(index).setName(name);
                                            break;
                                        case 2:
                                            System.out.println("Is it foreign tour?");
                                            kindsOfTours.get(index).setForeign(scan.nextBoolean());
                                            break;
                                        case 3:
                                            System.out.println("Enter the duration:");
                                            int duration=scan.nextInt();
                                            kindsOfTours.get(index).setDuration(duration);
                                            break;
                                        case 4:
                                            System.out.println("Enter the name of region:");
                                            String regionName=scan.next();
                                            Boolean bool=false;
                                            Region region = null;
                                            for(int i=0;i<regionList.size();i++){
                                                if (regionName.equals(regionList.get(i).getName())){
                                                    region=regionList.get(i);
                                                    bool=true;
                                                }
                                            }
                                            if(bool==false){
                                                System.out.println("The region does't exist.Don't worry create it now ^_^!");
                                                region=new Region(regionName,scanSubRegion());
                                                regionList.add(region);
                                            }
                                            kindsOfTours.get(index).setRegion(region);
                                        case 5:
                                            System.out.println("Enter price:");
                                            kindsOfTours.get(index).setPrice(scan.nextLong());
                                            break;
                                        case 6:
                                            System.out.println("Enter the min and max of capacity in order:");
                                            kindsOfTours.get(index).setMinCapacity(scan.nextInt());
                                            kindsOfTours.get(index).setMaxCapacity(scan.nextInt());
                                            break;

                                        default:
                                            break;
                                    }
                                } else {
                                    System.out.println("Not found!");
                                }
                                break;
                            case 7://Edit tour's information
                                System.out.println("Enter tour's name and identifier (with a space between them):");
                                tourName = scan.next();
                                identifier = scan.nextInt();
                                index = mainTourSearch(tourName, identifier, tourList);
                                if (index >= 0) {
                                    editTour();
                                    int choice = scan.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("Enter new name:");
                                            String name = scan.next();
                                            tourList.get(index).setName(name);
                                            break;
                                        case 2:
                                            System.out.println("Enter Identifier:");
                                            identifier = scan.nextInt();
                                            tourList.get(index).setIdentifier(identifier);
                                            break;
                                        case 3:
                                            System.out.println("Enter date of start:(dat,month,year)");
                                            int day = scan.nextInt();
                                            int month = scan.nextInt();
                                            int year = scan.nextInt();
                                            Date newDate = new Date(year, month, year);
                                            tourList.get(index).setDateOFStart(newDate);
                                            break;
                                        case 4:
                                            System.out.println("Is it foreign tour?");
                                            tourList.get(index).setForeign(scan.nextBoolean());
                                        case 5:
                                            System.out.println("Enter the duration:");
                                            int duration=scan.nextInt();
                                            tourList.get(index).setDuration(duration);
                                            Date dateOfEnd=null;
                                            for(int i=0;i<duration;i++){
                                                dateOfEnd=tourList.get(index).getDateOFStart().nextDay();
                                            }
                                            tourList.get(index).setDatOfEnd(dateOfEnd);
                                            break;
                                        case 6:
                                            System.out.println("Enter the name of region:");
                                            String regionName=scan.next();
                                            Boolean bool=false;
                                            Region region = null;
                                            for(int i=0;i<regionList.size();i++){
                                                if (regionName.equals(regionList.get(i).getName())){
                                                    region=regionList.get(i);
                                                    bool=true;
                                                }
                                            }
                                            if(bool==false){
                                                System.out.println("The region does't exist.Don't worry create it now ^_^!");
                                                region=new Region(regionName,scanSubRegion());
                                                regionList.add(region);
                                            }
                                            tourList.get(index).setRegion(region);

                                        case 7:
                                            System.out.println("Enter price:");
                                            tourList.get(index).setPrice(scan.nextLong());
                                            break;
                                        case 8:
                                            System.out.println("Enter the min and max of capacity in order:");
                                            tourList.get(index).setMinCapacity(scan.nextInt());
                                            tourList.get(index).setMaxCapacity(scan.nextInt());
                                            break;
                                        case 9:
                                            System.out.println("Enter the beginning and the destination:(if it isn't foreign tour just enter beginning)");
                                            String begin,destination;
                                            if(tourList.get(index).isForeign()==false){
                                                begin=scan.next();
                                                destination=begin;
                                            } else {
                                                begin = scan.next();
                                                destination = scan.next();
                                            }
                                            tourList.get(index).setBegin(begin);
                                            tourList.get(index).setDestination(destination);
                                            break;
                                        case 10:
                                            System.out.println("How thw passengers will travel?");
                                            System.out.println("1- By air");
                                            System.out.println("2- On ground");
                                            int choicee=scan.nextInt();
                                            HowToTravel howToTravel=HowToTravel.NONE;
                                            switch(choicee){
                                                case 1:
                                                    tourList.get(index).setHowToTravel(HowToTravel.BY_AIR);
                                                    break;
                                                case 2:
                                                    tourList.get(index).setHowToTravel(HowToTravel.ON_GROUND);
                                                    break;
                                                default:
                                                    System.out.println("Invalid input!");
                                            }
                                            break;
                                        case 11:
                                            Map<Integer, String> subRegion=new HashMap<>();
                                            System.out.println("Now enter the subRegions in order to set the schedule of tours:");
                                            for(Integer d=1;d<=tourList.get(index).getDuration();d++) {
                                                subRegion.put(d,scan.next());
                                            }
                                            tourList.get(index).setOrderedSubRegions(subRegion);
                                            break;
                                        default:
                                            break;
                                    }
                                } else {
                                    System.out.println("Not found!");
                                }
                                break;
                            case 8:// Search a special tour
                                while (exit5 == false) {
                                    searchTourMenu();
                                    int choice6 = scan.nextInt();
                                    switch (choice6) {
                                        case 1://search by leaders
                                            System.out.println("Enter the firs name and last name:");
                                            String firstName = scan.next();
                                            String lastName = scan.next();
                                            searchTourByLeader(firstName, lastName, tourList,leaderList);
                                            break;
                                        case 2://search based on date
                                            dateMenu();
                                            int choice5 = scan.nextInt();
                                            searchTourByDate(choice5, tourList);
                                            break;
                                        case 3://search by duration
                                            System.out.println("Enter duration:");
                                            int duration=scan.nextInt();
                                            searchTourByDuration(duration,tourList);
                                            break;
                                        case 4://search based on subRegion
                                            System.out.println("Enter the name of subRegion:");
                                            String subRegionName=scan.next();
                                            searchTourBySubRegion(subRegionName,tourList);
                                            break;
                                        case 5://search by region
                                            System.out.println("Enter the name of region:");
                                            String regionName=scan.next();
                                            searchTourByRegion(regionName,tourList);
                                            break;
                                        case 6://search by capacity
                                            System.out.println("Enter capacity:");
                                            int capacity=scan.nextInt();
                                            searchTourByCapacity(capacity,tourList);
                                            break;
                                        case 7://search by price
                                            priceMenu();
                                            int choice4 = scan.nextInt();
                                            searchTourByPrice(choice4, tourList);
                                            break;
                                        case 8://back to menu
                                            exit5 = true;
                                            break;
                                    }
                                }
                                break;
                            case 9://search kinds of tour
                                while (exit7 == false) {
                                    searchKindOfTourMenu();
                                    int choice7 = scan.nextInt();
                                    switch (choice7) {
                                        case 1://search by duration
                                            System.out.println("Enter the duration:");
                                            int duration = scan.nextInt();
                                            searchKindsOfTourByDuration(duration, kindsOfTours);
                                            break;
                                        case 2://search based on subRegion
                                            System.out.println("Enter the name of subRregion:");
                                            String subRegionName=scan.next();
                                            searchKindOfTourBySubRegion(subRegionName,kindsOfTours);
                                            break;
                                        case 3://search by region
                                            System.out.println("Enter the name of region:");
                                            String regionName=scan.next();
                                            searchKindOfTourByRegion(regionName,kindsOfTours);
                                            break;
                                        case 4://search by capacity
                                            System.out.println("Enter capacity:");
                                            int capacity=scan.nextInt();
                                            searchKindOfTourByCapacity(capacity,kindsOfTours);
                                            break;
                                        case 5://search by price
                                            priceMenu();
                                            int choice4 = scan.nextInt();
                                            searchKindOfTourByPrice(choice4, kindsOfTours);
                                            break;
                                        case 6://back to menu
                                            exit7 = true;
                                            break;
                                    }
                                }
                                break;
                            case 10:// Back to Menu
                                exit6 = true;
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                    }
                    break;
                case 2://handle leaders
                    while(exit1==false) {
                        leaderMenu();
                        int choice2 = scan.nextInt();
                        switch (choice2) {
                            case 1://show list of leaders
                                showLeaders(leaderList);
                                break;
                            case 2://add new leader
                                leaderList.add(scanLeader(currentYear));
                                break;
                            case 3://remove leader
                                System.out.println("Enter first name and last name:");
                                String firstName = scan.next();
                                String lastName = scan.next();
                                int index = mainLeaderSearch(firstName, lastName, leaderList);
                                if (index >= 0) {
                                    leaderList.remove(leaderList.get(index));
                                } else {
                                    System.out.println("Not found!");
                                }
                                break;
                            case 4://edit leader
                                System.out.println("Enter first name and last name:");
                                firstName = scan.next();
                                lastName = scan.next();
                                index = mainLeaderSearch(firstName, lastName, leaderList);
                                if (index >= 0) {
                                    editLeader();
                                    int choice=scan.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("Enter new first name:");
                                            firstName = scan.next();
                                            leaderList.get(index).setFirstName(firstName);
                                            break;
                                        case 2:
                                            System.out.println("Enter new last name:");
                                            lastName = scan.next();
                                            leaderList.get(index).setLastName(lastName);
                                            break;
                                        case 3:
                                            System.out.println("Enter Credit ID:");
                                            long creditId = scan.nextLong();
                                            leaderList.get(index).setCreditId(creditId);
                                            break;
                                        case 4:
                                            System.out.println("Enter date of birth:(dat,month,year)");
                                            int day = scan.nextInt();
                                            int month = scan.nextInt();
                                            int year = scan.nextInt();
                                            Date newDate = new Date(year, month, year);
                                            leaderList.get(index).setDateOfBirth(newDate);
                                            leaderList.get(index).setAge(currentYear - year);
                                            break;
                                        case 5:
                                            System.out.println("Enter date of employment:(dat,month,year)");
                                            day = scan.nextInt();
                                            month = scan.nextInt();
                                            year = scan.nextInt();
                                            newDate = new Date(year, month, year);
                                            leaderList.get(index).setDateOfEmployment(newDate);
                                            break;
                                        case 6:
                                            System.out.println("Is she/he married?");
                                            leaderList.get(index).setMarried(scan.nextBoolean());
                                            break;
                                        case 7:
                                            System.out.println("How many regions does he/she know?");
                                            int num = scan.nextInt();
                                            System.out.println("Enter new name of regions:");
                                            List<String> newRegionOfLeader = new ArrayList<>();
                                            for (int i = 0; i < num; i++) {
                                                newRegionOfLeader.add(scan.next());
                                            }
                                            leaderList.get(index).setRegionOfLeader(newRegionOfLeader);
                                            break;
                                        case 8:
                                            System.out.println("Enter previous date of shift:");
                                            day = scan.nextInt();
                                            month = scan.nextInt();
                                            year = scan.nextInt();
                                            Date previoysDate = new Date(year, month, day);
                                            int index1 = mainDateSearch(previoysDate, leaderList.get(index).getFullDay());
                                            if (index1 >= 0) {
                                                System.out.println("Enter new date of shift:");
                                                int newDay = scan.nextInt();
                                                int newMonth = scan.nextInt();
                                                int newYear = scan.nextInt();
                                                newDate = new Date(newYear, newMonth, newDay);
                                                leaderList.get(index).getFullDay().set(index1, newDate);
                                            } else {
                                                System.out.println("The date does not found!");
                                            }
                                            break;
                                        default:
                                            System.out.println("Invalid Input!");
                                            break;
                                    }
                                } else {
                                    System.out.println("Not found!");
                                }
                                break;
                            case 5://search leader and print result
                                while(exit4==false) {
                                    searchLeaderMenu();
                                    int choice3 = scan.nextInt();
                                    switch (choice3) {
                                        case 1://search by first name
                                            System.out.println("Enter the first name:");
                                            firstName = scan.next();
                                            searchLeaderByFirstName(firstName, leaderList);
                                            break;
                                        case 2://search by last name
                                            System.out.println("Enter last name:");
                                            lastName = scan.next();
                                            searchLeaderByLastName(lastName, leaderList);
                                            break;
                                        case 3://search by region
                                            System.out.println("Enter name of region:");
                                            String regionName = scan.next();
                                            for(int i=0;i<leaderList.size();i++){
                                                for (int j = 0; j<leaderList.get(i).getRegionOfLeader().size(); j++){
                                                    if(regionName.equals(leaderList.get(i).getRegionOfLeader().get(j))){
                                                        System.out.println("* "+leaderList.get(i).getFirstName()+" "+leaderList.get(i).getLastName());
                                                    }
                                                }
                                            }
                                            break;
                                        case 4://search by age
                                            ageMenu();
                                            int choice4 = scan.nextInt();
                                            searchLeaderByAge(choice4, leaderList);
                                            break;
                                        case 5://back to menu
                                            exit4=true;
                                            break;
                                    }
                                }
                                break;
                            case 6://back to menu
                                exit1 = true;
                                break;
                        }
                    }
                    break;
                case 3://use map
                    while (exit2 == false) {
                        mapMenu();
                        int choice5 = scan.nextInt();
                        int identifier, index = -1;
                        if (choice5 != 1 && choice5!= 2) {
                            System.out.println("Enter the name and identifier of the tour:");
                            String tourName = scan.next();
                            identifier = scan.nextInt();
                            index = mainTourSearch(tourName, identifier, tourList);
                        }
                        switch (choice5) {
                            case 1://show the information of 2 place (not in a tour)
                                System.out.println("Enter the name of first place:");
                                String place1 = scan.next();
                                System.out.println("Enter the name of second place:");
                                String place2 = scan.next();
                                MapUtil.showMap(place1, place2);
                                break;
                            case 2://show the information of 1 place (not in a tour)
                                System.out.println("Enter the name of place:");
                                String place = scan.next();
                                MapUtil.showMap(place);
                                break;
                            case 3://show current location of the tour
                                if (index >= 0) {
                                    System.out.println("Enter the number of the day that you want to see the location of the tour in it(it should be less than duration of the tour):");
                                    int num=scan.nextInt();
                                    if(num<=tourList.get(index).getDuration()) {
                                        MapUtil.showMap(tourList.get(index).getOrderedSubRegions().get(num));
                                    }
                                }
                                break;
                            case 4:// Show the beginning city or destination
                                if (index >= 0) {
                                    System.out.println("What are you going to search for?");
                                    System.out.println("1- Beginning of the tour");
                                    System.out.println("2- Destination of the tour");
                                    int choice = scan.nextInt();
                                    switch (choice) {
                                        case 1:
                                            MapUtil.showMap(tourList.get(index).getBegin());
                                            break;
                                        case 2:
                                            MapUtil.showMap(tourList.get(index).getDestination());
                                            break;
                                        default:
                                            System.out.println("Invalid input!");
                                            break;
                                    }
                                }
                                break;
                            case 5:// Show the beginning city and destination
                                if (index >= 0) {
                                    if(tourList.get(index).isForeign()==true) {
                                        MapUtil.showMap(tourList.get(index).getBegin(), tourList.get(index).getDestination());
                                    } else{
                                        System.out.println("The begining and distination of an inner tour are the same and you can't show them with this option!");
                                    }
                                } else {
                                    System.out.println("Tour not found!");
                                }
                                break;
                            case 6://Show the subRegions of a foreign tour
                                if (index >= 0) {
                                    if (tourList.get(index).isForeign() == true) {
                                        for(int i=0;i<tourList.get(index).getRegion().getSubRegion().size();i++){
                                            MapUtil.showMap(tourList.get(index).getRegion().getSubRegion().get(i));
                                        }
                                    } else{
                                        System.out.println("This option is just for foreign tours!");
                                    }
                                }
                                break;
                            case 7://back to menu
                                exit2 = true;
                                break;
                        }
                    }
                    break;
                case 4: //handle regions
                    while (exit3==false) {
                        regionMenu();
                        int choice6 = scan.nextInt();
                        switch (choice6) {
                            case 1://show all regions
                                showRegions(regionList);
                                break;
                            case 2://add new region
                                System.out.println("Enter region's name:");
                                String regionName=scan.next();
                                subRegionList=scanSubRegion();
                                Region region = new Region(regionName, subRegionList);
                                regionList.add(region);
                                break;
                            case 3://edit region
                                System.out.println("Enter name of region:");
                                regionName= scan.next();
                                int index = mainRegionSearch(regionName,regionList);
                                if (index >= 0) {
                                    editRegion();
                                    int choice = scan.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("Enter region's new name:");
                                            region = new Region(scan.next(), subRegionList);
                                            regionList.set(index, region);
                                            break;
                                        case 2:
                                            System.out.println("Enter new subRegions");
                                            region =new Region(regionName,scanSubRegion());
                                            regionList.set(index,region);
                                            break;
                                        default:
                                            break;
                                    }
                                } else {
                                    System.out.println("Region not found!");
                                }
                                break;
                            case 4://remove region
                                System.out.println("Enter name of the region:");
                                regionName = scan.next();
                                index = mainRegionSearch(regionName,regionList);
                                if (index >= 0) {
                                    regionList.remove(regionList.get(index));
                                } else {
                                    System.out.println("Not found!");
                                }
                                break;
                            case 5://back to menu
                                exit3=true;
                                break;
                        }
                    }
                    break;
                case 5://exit
                    return;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }

    /**
     * There are menus here
     */
    public static void menu(){
        System.out.println("_____________________________________________________");
        System.out.println("What are you going to do?");
        System.out.println("1- Handle tours");
        System.out.println("2- Handle leaders");
        System.out.println("3- Use map");
        System.out.println("4- Handle regions");
        System.out.println("5- Exit");
    }
    public static void tourMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("What do you want to do?");
        System.out.println("1- Show kinds of tours");
        System.out.println("2- Show the list of the information of all tours");
        System.out.println("3- Add new kinds of tour");
        System.out.println("4- Add new tour");
        System.out.println("5- Remove tour");
        System.out.println("6- Edit kinds of tours");
        System.out.println("7- Edit tour's information");
        System.out.println("8- Search a special tour");
        System.out.println("9- Search kind of tours");
        System.out.println("10- Back to last menu");
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
    public static void ageMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("How do you want search?");
        System.out.println("1- A special age");
        System.out.println("2- More than a special age");
        System.out.println("3- Less than a special age");
        System.out.println("4- Between two special ages");
        System.out.println("5- Back to last menu");
    }
    public static void mapMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("What do you want to do?");
        System.out.println("1- Show the information of two place in map(not in a tour)");
        System.out.println("2- Show the information of a place in map(not in a tour)");
        System.out.println("3- Show current location of the tour");
        System.out.println("4- Show the beginning city or destination");
        System.out.println("5- Show the beginning city and destination");
        System.out.println("6- Show the subRegions of a foreign tour");
        System.out.println("7- Back to last menu");

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
    public static void searchTourMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("What kind of search do you want to do?");
        System.out.println("1- Based on Leader");
        System.out.println("2- Based on date");
        System.out.println("3- Based on duration");
        System.out.println("4- Based on subRegion");
        System.out.println("5- Based on region");
        System.out.println("6- Based on capacity");
        System.out.println("7- Based on price");
        System.out.println("8- Back to last menu");
    }
    public static void searchKindOfTourMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("What kind of search do you want to do?");
        System.out.println("1- Based on duration");
        System.out.println("2- Based on subRegion");
        System.out.println("3- Based on region");
        System.out.println("4- Based on capacity");
        System.out.println("5- Based on price");
        System.out.println("6- Back to last menu");
    }
    public static void priceMenu(){
        System.out.println("_____________________________________________________");
        System.out.println("How do you want search?");
        System.out.println("1- A special price");
        System.out.println("2- More than a special price");
        System.out.println("3- Less than a special price");
        System.out.println("4- Between two special prices");
        System.out.println("5- Back to last menu");
    }
    public static void dateMenu() {
        System.out.println("_____________________________________________________");
        System.out.println("How do you want search?");
        System.out.println("1- After a special date");
        System.out.println("2- Before the special date");
        System.out.println("3- Between two special dates");
        System.out.println("4- Back to last menu");
    }

    /**
     *There are all scanner methods here
     */
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
    public static Tour scanTour(List<Region> regionList,List <Leader> leaderList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of the tour and it's identifier(it should be a space between the name and the identifier)");
        String name=scan.next();
        int identifier=scan.nextInt();
        System.out.println("Is it foreign tour?(answer in boolean)");
        boolean isForeign=scan.nextBoolean();
        System.out.println("Enter the name of region:");
        String regionName=scan.next();
        Boolean bool=false;
        Region region = null;
        for(int i=0;i<regionList.size();i++){
            if (regionName.equals(regionList.get(i).getName())){
                region=regionList.get(i);
                bool=true;
            }
        }
        if(bool==false){
            System.out.println("The region does't exist.Don't worry create it now ^_^!");
            region=new Region(regionName,scanSubRegion());
            regionList.add(region);
        }
        System.out.println("Enter the date of start:(Enter day , month and year in order)");
        int day=scan.nextInt();
        int month=scan.nextInt();
        int year=scan.nextInt();
        Date dateOfStart= new Date(year,month,day);
        System.out.println("Enter the duration of the tour:");
        int duration=scan.nextInt();
        Date dateOfEnd=null;
        for(int i=0;i<duration;i++){
            dateOfEnd=dateOfStart.nextDay();
        }
        System.out.println("Enter the first name and last name of the leader:");
        int index = mainLeaderSearch(scan.next(),scan.next(),leaderList);
        if(index>=0) {
            boolean canLead = false;
            for (int i = 0; i < leaderList.get(index).getRegionOfLeader().size(); i++) {
                if (leaderList.get(index).getRegionOfLeader().get(i).equals(regionName)) {
                    canLead = true;
                }
            }
            if (canLead == true) {
                Date date = dateOfStart;
                boolean isFull = false;
                for (int i = 0; i < duration; i++) {
                    for (int j = 0; j < leaderList.get(index).getFullDay().size(); j++) {
                        if (compareDate((leaderList.get(index).getFullDay().get(j)),date)==0){
                            isFull = true;
                        }
                    }
                    date = date.nextDay();
                }
                if (isFull == false) {
                    date = dateOfStart;
                    for (int i = 0; i < duration; i++) {
                        leaderList.get(index).getFullDay().add(date);
                        date = date.nextDay();
                    }
                    for(int i=0;i<leaderList.get(index).getFullDay().size();i++){
                        System.out.println(leaderList.get(index).getFullDay().get(i));
                        System.out.println();
                    }
                } else {
                    System.out.println("Leader is full in this date.Set another date for the tour or change the leader!");
                    return null;
                }
            } else {
                System.out.println("The leader can't lead this tour in this region! He/She doesn't know the region!");
                return null;
            }
        } else if(index<0){
            System.out.println("The leader not found!");
            return null;
        }
        System.out.println("Enter the price of tour:");
        long price=scan.nextLong();
        System.out.println("Enter the min and max of tour's capacity in order:");
        int minCapacity=scan.nextInt();
        int maxCapacity=scan.nextInt();
        System.out.println("Enter the beginning and the destination:(if it isn't foreign tour just enter beginning)");
        String begin,destination;
        if(isForeign==false){
            begin=scan.next();
            destination=begin;
        } else {
            begin = scan.next();
            destination = scan.next();
        }
        System.out.println("How thw passengers will travel?");
        System.out.println("1- By air");
        System.out.println("2- On ground");
        int choice=scan.nextInt();
        HowToTravel howToTravel=HowToTravel.NONE;
        switch(choice){
            case 1:
                howToTravel=HowToTravel.BY_AIR;
                break;
            case 2:
                howToTravel=HowToTravel.ON_GROUND;
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
        Map<Integer, String> subRegion=new HashMap<>();
        System.out.println("Now enter the subRegions in order to set the schedule of tours:");
        for(Integer d=1;d<=duration;d++) {
            subRegion.put(d,scan.next());
        }
        Tour tour=new Tour(name,identifier,dateOfStart,dateOfEnd,isForeign,duration,region,price,minCapacity,maxCapacity,begin,destination,howToTravel,subRegion,leaderList.get(index));
        return tour;
    }
    public static Tour scanKindsOfTour(List<Region> regionList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter kind of the tour");
        String name=scan.next();
        System.out.println("Enter the duration of the tour:");
        int duration=scan.nextInt();
        System.out.println("Is it foreign tour?(answer in boolean)");
        boolean isForeign=scan.nextBoolean();
        System.out.println("Enter the name of region:");
        String regionName=scan.next();
        Boolean bool=false;
        Region region = null;
        for(int i=0;i<regionList.size();i++){
            if (regionName.equals(regionList.get(i).getName())){
                region=regionList.get(i);
                bool=true;
            }
        }
        if(bool==false){
            System.out.println("The region does't exist.Don't worry create it now ^_^!");
            region=new Region(regionName,scanSubRegion());
            regionList.add(region);
        }
        System.out.println("Enter the price of tour:");
        long price=scan.nextLong();
        System.out.println("Enter the min and max of tour's capacity in order:");
        int minCapacity=scan.nextInt();
        int maxCapacity=scan.nextInt();
        Tour tour=new Tour(name,isForeign,duration,region,price,minCapacity,maxCapacity);
        return tour;
    }
    /**
     * There are all show methods here
     */
    public static void showKindsOfTours(List<Tour> kindsOfTours){
        boolean bool=false;
        for(int i = 0; i < kindsOfTours.size(); i++) {
            System.out.println((i+1)+"- "+kindsOfTours.get(i).getName());
            System.out.println("    Duration:"+kindsOfTours.get(i).getDuration());
            System.out.println("    Price:"+kindsOfTours.get(i).getPrice());
            System.out.println("    Capacity:"+kindsOfTours.get(i).getMinCapacity()+"-"+kindsOfTours.get(i).getMaxCapacity());
            bool=true;
        }
        if(bool==false){
            System.out.println("There isn't any tour!");
        }
    }
    public static void showToursInformation(List<Tour> tourList){
        boolean bool=false;
        for(int i = 0; i < tourList.size(); i++) {
            System.out.print((i+1)+"- "+tourList.get(i).getName()+" "+tourList.get(i).getIdentifier() );
            System.out.print("  It will start in date ");
            System.out.println(tourList.get(i).getDateOFStart().toString());
            System.out.print("and it will end in date ");
            System.out.println(tourList.get(i).getDatOfEnd().toString());
            System.out.println();
            System.out.println("    The price is: "+tourList.get(i).getPrice());
            System.out.println("    Leader: "+tourList.get(i).getTourLeader().getFirstName()+" "+tourList.get(i).getTourLeader().getLastName());
            System.out.println("    It's " + tourList.get(i).getHowToTravel()+".");
            System.out.println("    It's capacity is between "+tourList.get(i).getMinCapacity()+" and "+tourList.get(i).getMaxCapacity()+".");
            System.out.println("        The schedule is like this:");
            tourList.get(i).getOrderedSubRegions().forEach((key, value) -> System.out.println("         Day "+key +":"+ " =======> " + value));

            bool=true;
        }
        if(bool==false){
            System.out.println("There isn't any tour!");
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
    /**
     * There are all edit menus here
     */
    public static void editRegion(){
        System.out.println("_____________________________________________________");
        System.out.println("Enter the number of the object that you want edit");
        System.out.println("1- Name of the region");
        System.out.println("2- SubRegions");
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
    public static void editTour(){
        System.out.println("_____________________________________________________");
        System.out.println("Enter the number of the object that you want edit");
        System.out.println("1- Name");
        System.out.println("2- Identifier");
        System.out.println("3- Date of start");
        System.out.println("4- Is it foreign tour?");
        System.out.println("5- Duration");
        System.out.println("6- Region");
        System.out.println("7- price");
        System.out.println("8- Min and max of capacity");
        System.out.println("9- Begin and destination");
        System.out.println("10- How the tour will travel?");
        System.out.println("11- Order the subRegions");
    }
    public static void editKindOfTour(){
        System.out.println("_____________________________________________________");
        System.out.println("Enter the number of the object that you want edit");
        System.out.println("1- Name");
        System.out.println("2- Is it foreign tour?");
        System.out.println("3- Duration");
        System.out.println("4- Region");
        System.out.println("5- price");
        System.out.println("6- Min and max of capacity");
    }
    /**
     * There are all search methods here
     */
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
    public static void searchTourByLeader(String firstName,String lastName,List<Tour> tourList,List<Leader>leaderList) {
        int index = mainLeaderSearch(firstName, lastName, leaderList);
        if (index >= 0) {
            for (int i = 0; i < tourList.size(); i++) {
                if ((tourList.get(i).getTourLeader().getFirstName()).equals(firstName) &&(tourList.get(i).getTourLeader().getLastName()).equals(lastName)) {
                    System.out.println("* "+tourList.get(i).getName() + " " + tourList.get(i).getIdentifier());
                }
            }
        } else {
            System.out.println("Leader does not found!");
        }
    }
    public static void searchTourByDate(int choice,List<Tour> tourList) {
        Scanner scan=new Scanner(System.in);
        switch(choice){
            case 1://after a special date
                System.out.println("Enter day , month ,year :");
                int day=scan.nextInt();
                int month=scan.nextInt();
                int year=scan.nextInt();
                Date date=new Date(year,month,day);
                for(int i = 0; i < tourList.size(); i++) {
                    if (compareDate(date,tourList.get(i).getDateOFStart())==-1 ){
                        System.out.println("* "+tourList.get(i).getName() + " " + tourList.get(i).getIdentifier());
                    }
                }
                break;
            case 2:// before a special date
                System.out.println("Enter day , month ,year :");
                day=scan.nextInt();
                month=scan.nextInt();
                year=scan.nextInt();
                date=new Date(year,month,day);
                for(int i = 0; i < tourList.size(); i++) {
                    if (compareDate(date,tourList.get(i).getDatOfEnd())==1 ){
                        System.out.println("* "+tourList.get(i).getName() + " " + tourList.get(i).getIdentifier());
                    }
                }
                break;
            case 3:// between 2 special dates
                System.out.println("Enter day , month ,year of first date:");
                int day1=scan.nextInt();
                int month1=scan.nextInt();
                int year1=scan.nextInt();
                Date date1=new Date(year1,month1,day1);
                System.out.println("Enter day , month ,year of second date :");
                int day2=scan.nextInt();
                int month2=scan.nextInt();
                int year2=scan.nextInt();
                Date date2=new Date(year2,month2,day2);
                for(int i = 0; i < tourList.size(); i++) {
                    if (compareDate(date1,tourList.get(i).getDateOFStart())==-1 && compareDate(date2,tourList.get(i).getDatOfEnd())==1 ){
                        System.out.println("* "+tourList.get(i).getName() + " " + tourList.get(i).getIdentifier());
                    }
                }
                break;
            default:
                break;
        }
    }
    public static void searchTourByDuration(int duration,List<Tour> tourList){
        for(int i = 0; i < tourList.size(); i++) {
            if(duration==tourList.get(i).getDuration()){
                System.out.println("* " + tourList.get(i).getName() + " " + tourList.get(i).getIdentifier());
            }
        }
    }
    public static void searchTourByCapacity(int capacity,List<Tour> tourList){
        for(int i = 0; i < tourList.size(); i++) {
            if(capacity>=tourList.get(i).getMinCapacity() && capacity<=tourList.get(i).getMaxCapacity()){
                System.out.println("* "+tourList.get(i).getName()+ " " + tourList.get(i).getIdentifier());
            }
        }
    }
    public static void searchTourByPrice(int choice,List<Tour> tourList){
        Scanner scan=new Scanner(System.in);
        switch(choice){
            case 1://a special price
                System.out.println("Enter price:");
                int price=scan.nextInt();
                for(int i = 0; i < tourList.size(); i++) {
                    if (price == tourList.get(i).getPrice()) {
                        System.out.println("* "+tourList.get(i).getName() + " " + tourList.get(i).getIdentifier());
                    }
                }
                break;
            case 2:// more than a special price
                System.out.println("Enter price:");
                price=scan.nextInt();
                for(int j = 0; j < tourList.size(); j++) {
                    if (tourList.get(j).getPrice() > price) {
                        System.out.println("* "+tourList.get(j).getName() + " " + tourList.get(j).getIdentifier());
                    }
                }
                break;
            case 3:// less than a special price
                System.out.println("Enter price:");
                price = scan.nextInt();
                for (int k = 0; k < tourList.size(); k++) {
                    if (tourList.get(k).getPrice() < price) {
                        System.out.println("* "+tourList.get(k).getName() + " " + tourList.get(k).getIdentifier());
                    }
                }
                break;
            case 4://between 2 special price
                System.out.println("Enter minPrice:");
                int minPrice = scan.nextInt();
                System.out.println("Enter maxPrice:");
                int maxPrice = scan.nextInt();
                for (int l = 0; l < tourList.size(); l++) {
                    if (tourList.get(l).getPrice() < maxPrice && tourList.get(l).getPrice() > minPrice) {
                        System.out.println("* "+tourList.get(l).getName() + " " + tourList.get(l).getIdentifier());
                    }
                }
                break;
        }
    }
    public static void searchTourByRegion(String regionName,List<Tour> tourList){
        for(int i=0;i<tourList.size();i++){
            if(regionName.equals(tourList.get(i).getRegion().getName())){
                System.out.println("    *"+tourList.get(i).getName()+ " " + tourList.get(i).getIdentifier());
            }
        }
    }
    public static void searchTourBySubRegion(String subRegionName,List<Tour> tourList){
        for(int i=0;i<tourList.size();i++) {
            for (int j = 0; j < tourList.get(i).getRegion().getSubRegion().size(); j++) {
                if (subRegionName.equals(tourList.get(i).getRegion().getSubRegion().get(j))) {
                    System.out.println("    *" + tourList.get(i).getName()+ " " + tourList.get(i).getIdentifier());
                }
            }
        }
    }
    public static void searchKindOfTourByPrice(int choice,List<Tour> kindsOfTours){
        Scanner scan=new Scanner(System.in);
        switch(choice){
            case 1://a special price
                System.out.println("Enter price:");
                int price=scan.nextInt();
                for(int i = 0; i < kindsOfTours.size(); i++) {
                    if (price == kindsOfTours.get(i).getPrice()) {
                        System.out.println("* "+kindsOfTours.get(i).getName() );
                    }
                }
                break;
            case 2:// more than a special price
                System.out.println("Enter price:");
                price=scan.nextInt();
                for(int j = 0; j < kindsOfTours.size(); j++) {
                    if (kindsOfTours.get(j).getPrice() > price) {
                        System.out.println("* "+kindsOfTours.get(j).getName());
                    }
                }
                break;
            case 3:// less than a special price
                System.out.println("Enter price:");
                price = scan.nextInt();
                for (int k = 0; k < kindsOfTours.size(); k++) {
                    if (kindsOfTours.get(k).getPrice() < price) {
                        System.out.println("* "+kindsOfTours.get(k).getName());
                    }
                }
                break;
            case 4://between 2 special price
                System.out.println("Enter minPrice:");
                int minPrice = scan.nextInt();
                System.out.println("Enter maxPrice:");
                int maxPrice = scan.nextInt();
                for (int l = 0; l < kindsOfTours.size(); l++) {
                    if (kindsOfTours.get(l).getPrice() < maxPrice && kindsOfTours.get(l).getPrice() > minPrice) {
                        System.out.println("* "+kindsOfTours.get(l).getName());
                    }
                }
                break;
        }
    }
    public static void searchKindOfTourByCapacity(int capacity,List<Tour> kindsOfTours){
        for(int i = 0; i < kindsOfTours.size(); i++) {
            if(capacity>=kindsOfTours.get(i).getMinCapacity() && capacity<=kindsOfTours.get(i).getMaxCapacity()){
                System.out.println("* "+kindsOfTours.get(i).getName());
            }
        }
    }
    public static void searchKindOfTourByRegion(String regionName,List<Tour> kindsOfTours){
        for(int i=0;i<kindsOfTours.size();i++){
            if(regionName.equals(kindsOfTours.get(i).getRegion().getName())){
                System.out.println("    *"+kindsOfTours.get(i).getName());
            }
        }
    }
    public static void searchKindOfTourBySubRegion(String subRegionName,List<Tour> kindsOfTours){
        for(int i=0;i<kindsOfTours.size();i++) {
            for (int j = 0; j < kindsOfTours.get(i).getRegion().getSubRegion().size(); j++) {
                if (subRegionName.equals(kindsOfTours.get(i).getRegion().getSubRegion().get(j))) {
                    System.out.println("    *" + kindsOfTours.get(i).getName());
                }
            }
        }
    }
    public static void searchKindsOfTourByDuration(int duration,List<Tour> kindsOfTours){
        for(int i = 0; i < kindsOfTours.size(); i++) {
            if(duration==kindsOfTours.get(i).getDuration()){
                System.out.println("* " + kindsOfTours.get(i).getName());
            }
        }
    }
    //mainSearches
    public static int mainLeaderSearch(String firstName,String lastName,List<Leader> leaderList){
        for(int i = 0; i < leaderList.size(); i++) {
            if(firstName.equals(leaderList.get(i).getFirstName()) && lastName.equals(leaderList.get(i).getLastName())){
                return i;
            }
        }
        return -1;
    }
    public static int mainTourSearch(String tourName,int identifier,List<Tour> tourList){
        for(int i = 0; i < tourList.size(); i++) {
            if(tourName.equals(tourList.get(i).getName()) && identifier==tourList.get(i).getIdentifier()){
                return i;
            }
        }
        return -1;
    }
    public static int mainKindsOfToursSearch(String name,List<Tour> kindsOfTours) {
        for(int i = 0; i < kindsOfTours.size(); i++) {
            if(name.equals(kindsOfTours.get(i).getName())){
                return i;
            }
        }
        return -1;
    }
    public static int mainRegionSearch(String regionName,List<Region> regionList){
        for(int i = 0; i < regionList.size(); i++) {
            if(regionName.equals(regionList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }
    public static int mainDateSearch(Date date,List<Date> fullDay){
        for(int i=0;i<fullDay.size();i++){
            if(compareDate(date,fullDay.get(i))==0){
                return i;
            }
        }
        return -1;
    }
    /**
     * @return 1 if date2 is sooner than date1
     * @return -1 if date1 is sooner than date2
     * @return 0 if they are the same
     */
    public static int compareDate(Date date1,Date date2){
        if(date1.getYear()>date2.getYear() || (date1.getYear()==date2.getYear() && date1.getMonth()>date2.getMonth()) || (date1.getYear()==date2.getYear() && date1.getMonth()==date2.getMonth() && date1.getDay()>date2.getDay())){
            return 1;
        } else if(date1.getYear()<date2.getYear() || (date1.getYear()==date2.getYear() && date1.getMonth()<date2.getMonth()) || (date1.getYear()==date2.getYear() && date1.getMonth()==date2.getMonth() && date1.getDay()<date2.getDay())){
            return -1;
        } else if(date1.getYear()==date2.getYear() && date1.getMonth()==date2.getMonth() && date1.getDay()==date2.getDay() ) {
            return 0;
        }
        return -100;
    }
}