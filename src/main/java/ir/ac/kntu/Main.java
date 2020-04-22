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
        User user=new User("admin");
        Scanner scan=new Scanner(System.in);
        boolean ok , ook=false;
        ok=false;
        while (ok==false) {
            System.out.println("Enter the username:");
            String userName = scan.next();
            if (userName.equals("admin")) {
                ook=false;
                while (ook == false) {
                    System.out.println("Enter the password:");
                    String password = scan.next();
                    if (password.equals(user.getPassword())) {
                        user.setAccess(Access.ADMIN);
                        ok=true;
                        ook=true;
                    } else {
                        System.out.println("Invalid passwprd!Try again!");
                    }
                }
            }else {
                System.out.println("Invalid username!Try again!");
            }
        }
        List <Leader> leaderList  = new ArrayList<>();
        List <Tour> tourList  = new ArrayList<>();
        List<Tour> kindsOfTours = new ArrayList<>();
        List <Region> regionList = new ArrayList<>();
        List<String> subRegionList=new ArrayList<>();
        List <User> userList  = new ArrayList<>();
        System.out.println("Enter the current year:");
        int currentYear=scan.nextInt();
        boolean exit0 = false ,exit1 = false ,exit2 = false ,exit3 = false,exit4 = false ,exit5 = false ,exit6 = false ,exit7 = false;
        while(true) {
            menu();
            int choice1 = scan.nextInt();
            switch (choice1) {
                case 1://handle tours
                    exit6=false;
                    while (exit6 == false) {
                        Tour.tourMenu();
                        int choice0 = scan.nextInt();
                        switch (choice0) {
                            case 1://Show kinds of tours
                                Tour.showKindsOfTours(kindsOfTours);
                                break;
                            case 2://show all tours with details
                                Tour.showToursInformation(tourList);
                                break;
                            case 3://Add new kind of tour
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    kindsOfTours.add(Tour.scanKindsOfTour(regionList));
                                }else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 4://Add new tour
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    tourList.add(Tour.scanTour(regionList, leaderList));
                                } else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 5://Remove tour
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter name of the tour and it's identifier:(it should be a space between them)");
                                    String tourName = scan.next();
                                    int identifier = scan.nextInt();
                                    int index = Tour.mainTourSearch(tourName, identifier, tourList);
                                    if (index >= 0) {
                                        tourList.remove(tourList.get(index));
                                    } else {
                                        System.out.println("Not found!");
                                    }
                                }else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 6://Edit kinds of tours
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter tour's name:");
                                    String tourName = scan.next();
                                    int index = Tour.mainKindsOfToursSearch(tourName, tourList);
                                    if (index >= 0) {
                                        Tour.editKindOfTour();
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
                                                int duration = scan.nextInt();
                                                kindsOfTours.get(index).setDuration(duration);
                                                break;
                                            case 4:
                                                System.out.println("Enter the name of region:");
                                                String regionName = scan.next();
                                                Boolean bool = false;
                                                Region region = null;
                                                for (int i = 0; i < regionList.size(); i++) {
                                                    if (regionName.equals(regionList.get(i).getName())) {
                                                        region = regionList.get(i);
                                                        bool = true;
                                                    }
                                                }
                                                if (bool == false) {
                                                    System.out.println("The region does't exist.Don't worry create it now ^_^!");
                                                    region = new Region(regionName, Region.scanSubRegion());
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
                                }else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 7://Edit tour's information
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter tour's name and identifier (with a space between them):");
                                    String tourName = scan.next();
                                    int identifier = scan.nextInt();
                                    int index = Tour.mainTourSearch(tourName, identifier, tourList);
                                    if (index >= 0) {
                                        Tour.editTour();
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
                                                int duration = scan.nextInt();
                                                tourList.get(index).setDuration(duration);
                                                Date dateOfEnd = null;
                                                for (int i = 0; i < duration; i++) {
                                                    dateOfEnd = tourList.get(index).getDateOFStart().nextDay();
                                                }
                                                tourList.get(index).setDatOfEnd(dateOfEnd);
                                                break;
                                            case 6:
                                                System.out.println("Enter the name of region:");
                                                String regionName = scan.next();
                                                Boolean bool = false;
                                                Region region = null;
                                                for (int i = 0; i < regionList.size(); i++) {
                                                    if (regionName.equals(regionList.get(i).getName())) {
                                                        region = regionList.get(i);
                                                        bool = true;
                                                    }
                                                }
                                                if (bool == false) {
                                                    System.out.println("The region does't exist.Don't worry create it now ^_^!");
                                                    region = new Region(regionName, Region.scanSubRegion());
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
                                                String begin, destination;
                                                if (tourList.get(index).isForeign() == false) {
                                                    begin = scan.next();
                                                    destination = begin;
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
                                                int choicee = scan.nextInt();
                                                HowToTravel howToTravel = HowToTravel.NONE;
                                                switch (choicee) {
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
                                                Map<Integer, String> subRegion = new HashMap<>();
                                                System.out.println("Now enter the subRegions in order to set the schedule of tours:");
                                                for (Integer d = 1; d <= tourList.get(index).getDuration(); d++) {
                                                    subRegion.put(d, scan.next());
                                                }
                                                tourList.get(index).setOrderedSubRegions(subRegion);
                                                break;
                                            default:
                                                break;
                                        }
                                    } else {
                                        System.out.println("Not found!");
                                    }
                                }else {
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 8:// Search a special tour
                                exit5=false;
                                while (exit5 == false) {
                                    Tour.searchTourMenu();
                                    int choice6 = scan.nextInt();
                                    switch (choice6) {
                                        case 1://search by leaders
                                            System.out.println("Enter the firs name and last name:");
                                            String firstName = scan.next();
                                            String lastName = scan.next();
                                            Tour.searchTourByLeader(firstName, lastName, tourList,leaderList);
                                            break;
                                        case 2://search based on date
                                            Date.dateMenu();
                                            int choice5 = scan.nextInt();
                                            Tour.searchTourByDate(choice5, tourList);
                                            break;
                                        case 3://search by duration
                                            System.out.println("Enter duration:");
                                            int duration=scan.nextInt();
                                            Tour.searchTourByDuration(duration,tourList);
                                            break;
                                        case 4://search based on subRegion
                                            System.out.println("Enter the name of subRegion:");
                                            String subRegionName=scan.next();
                                            Tour.searchTourBySubRegion(subRegionName,tourList);
                                            break;
                                        case 5://search by region
                                            System.out.println("Enter the name of region:");
                                            String regionName=scan.next();
                                            Tour.searchTourByRegion(regionName,tourList);
                                            break;
                                        case 6://search by capacity
                                            System.out.println("Enter capacity:");
                                            int capacity=scan.nextInt();
                                            Tour.searchTourByCapacity(capacity,tourList);
                                            break;
                                        case 7://search by price
                                            Tour.priceMenu();
                                            int choice4 = scan.nextInt();
                                            Tour.searchTourByPrice(choice4, tourList);
                                            break;
                                        case 8://back to menu
                                            exit5 = true;
                                            break;
                                    }
                                }
                                break;
                            case 9://search kinds of tour
                                exit7=false;
                                while (exit7 == false) {
                                    Tour.searchKindOfTourMenu();
                                    int choice7 = scan.nextInt();
                                    switch (choice7) {
                                        case 1://search by duration
                                            System.out.println("Enter the duration:");
                                            int duration = scan.nextInt();
                                            Tour.searchKindsOfTourByDuration(duration, kindsOfTours);
                                            break;
                                        case 2://search based on subRegion
                                            System.out.println("Enter the name of subRregion:");
                                            String subRegionName=scan.next();
                                            Tour.searchKindOfTourBySubRegion(subRegionName,kindsOfTours);
                                            break;
                                        case 3://search by region
                                            System.out.println("Enter the name of region:");
                                            String regionName=scan.next();
                                            Tour.searchKindOfTourByRegion(regionName,kindsOfTours);
                                            break;
                                        case 4://search by capacity
                                            System.out.println("Enter capacity:");
                                            int capacity=scan.nextInt();
                                            Tour.searchKindOfTourByCapacity(capacity,kindsOfTours);
                                            break;
                                        case 5://search by price
                                            Tour.priceMenu();
                                            int choice4 = scan.nextInt();
                                            Tour.searchKindOfTourByPrice(choice4, kindsOfTours);
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
                    exit1=false;
                    while(exit1==false) {
                        Leader.leaderMenu();
                        int choice2 = scan.nextInt();
                        switch (choice2) {
                            case 1://show list of leaders
                                Leader.showLeaders(leaderList);
                                break;
                            case 2://add new leader
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    leaderList.add(Leader.scanLeader(currentYear));
                                }else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 3://remove leader
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter first name and last name:");
                                    String firstName = scan.next();
                                    String lastName = scan.next();
                                    int index = Leader.mainLeaderSearch(firstName, lastName, leaderList);
                                    if (index >= 0) {
                                        leaderList.remove(leaderList.get(index));
                                    } else {
                                        System.out.println("Not found!");
                                    }
                                }else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 4://edit leader
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter first name and last name:");
                                    String firstName = scan.next();
                                    String lastName = scan.next();
                                    int index = Leader.mainLeaderSearch(firstName, lastName, leaderList);
                                    if (index >= 0) {
                                        Leader.editLeader();
                                        int choice = scan.nextInt();
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
                                                int index1 = Date.mainDateSearch(previoysDate, leaderList.get(index).getFullDay());
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
                                }else {
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 5://search leader and print result
                                exit4=false;
                                while(exit4==false) {
                                    Leader.searchLeaderMenu();
                                    int choice3 = scan.nextInt();
                                    switch (choice3) {
                                        case 1://search by first name
                                            System.out.println("Enter the first name:");
                                            String firstName = scan.next();
                                            Leader.searchLeaderByFirstName(firstName, leaderList);
                                            break;
                                        case 2://search by last name
                                            System.out.println("Enter last name:");
                                            String lastName = scan.next();
                                            Leader.searchLeaderByLastName(lastName, leaderList);
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
                                            Leader.ageMenu();
                                            int choice4 = scan.nextInt();
                                            Leader.searchLeaderByAge(choice4, leaderList);
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
                    exit2=false;
                    while (exit2 == false) {
                        mapMenu();
                        int choice5 = scan.nextInt();
                        int identifier, index = -1;
                        if (choice5 != 1 && choice5!= 2) {
                            System.out.println("Enter the name and identifier of the tour:");
                            String tourName = scan.next();
                            identifier = scan.nextInt();
                            index = Tour.mainTourSearch(tourName, identifier, tourList);
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
                    exit3=false;
                    while (exit3==false) {
                        Region.regionMenu();
                        int choice6 = scan.nextInt();
                        switch (choice6) {
                            case 1://show all regions
                                Region.showRegions(regionList);
                                break;
                            case 2://add new region
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter region's name:");
                                    String regionName = scan.next();
                                    subRegionList = Region.scanSubRegion();
                                    Region region = new Region(regionName, subRegionList);
                                    regionList.add(region);
                                }else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 3://edit region
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter name of region:");
                                    String regionName = scan.next();
                                    int index = Region.mainRegionSearch(regionName, regionList);
                                    if (index >= 0) {
                                        Region.editRegion();
                                        int choice = scan.nextInt();
                                        switch (choice) {
                                            case 1:
                                                System.out.println("Enter region's new name:");
                                                Region region = new Region(scan.next(), subRegionList);
                                                regionList.set(index, region);
                                                break;
                                            case 2:
                                                System.out.println("Enter new subRegions");
                                                region = new Region(regionName, Region.scanSubRegion());
                                                regionList.set(index, region);
                                                break;
                                            default:
                                                break;
                                        }
                                    } else {
                                        System.out.println("Region not found!");
                                    }
                                }else{
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 4://remove region
                                if(user.getAccess().equals(Access.ADMIN)) {
                                    System.out.println("Enter name of the region:");
                                    String regionName = scan.next();
                                    int index = Region.mainRegionSearch(regionName, regionList);
                                    if (index >= 0) {
                                        regionList.remove(regionList.get(index));
                                    } else {
                                        System.out.println("Not found!");
                                    }
                                }else {
                                    System.out.println("You can't do it,because you are not admin!");
                                }
                                break;
                            case 5://back to menu
                                exit3=true;
                                break;
                        }
                    }
                    break;
                case 5://Handle users
                    User.userMenu();
                    int choice=scan.nextInt();
                    switch (choice){
                        case 1://add new user
                            if( !user.getAccess().equals(Access.CUSTOMER)){
                            User user1=User.scanUser();
                            System.out.println("Select the access mode:");
                            System.out.println("1- Employee");
                            System.out.println("2- Customer");
                            System.out.println("3- Leader");
                            int choicee=scan.nextInt();
                            switch (choicee){
                                case 1:
                                    if (! user.getAccess().equals(Access.LEADER)) {
                                        user1.setAccess(Access.EMPLOYEE);
                                    }else {
                                        System.out.println("You are a leader and you can't add new employee!");
                                    }
                                    break;
                                case 2:
                                    user1.setAccess(Access.CUSTOMER);
                                    break;
                                case 3:
                                    if (! user.getAccess().equals(Access.LEADER)) {
                                        user1.setAccess(Access.LEADER);
                                    }else {
                                        System.out.println("You are a leader and you can't add new leader!");
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                                userList.add(user1);
                            }else{
                                System.out.println("You are a leader and you can't add new user!");
                            }
                            break;
                        case 2://edit user
                            if(user.getAccess().equals(Access.ADMIN) || user.getAccess().equals(Access.EMPLOYEE)) {
                                System.out.println("Enter the username of user");
                                String userName = scan.next();
                                int index = User.mainUserSearch(userName, userList);
                                if (index >= 0) {
                                    System.out.println("What are you going to do?");
                                    System.out.println("1- Edit username");
                                    System.out.println("2- Edit password");
                                    System.out.println("3- Edit emial");
                                    System.out.println("4- Edit phone number");
                                    choice = scan.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("Enter new username");
                                            userList.get(index).setUserName(scan.next());
                                            break;
                                        case 2:
                                            System.out.println("Enter new passwrord");
                                            userList.get(index).setPassword(scan.next());
                                            break;
                                        case 3:
                                            System.out.println("Enter email");
                                            userList.get(index).setEmial(scan.next());
                                            break;
                                        case 4:
                                            System.out.println("Enter phone number");
                                            userList.get(index).setPhone_number(scan.next());
                                            break;
                                        default:
                                            System.out.println("Invalid input!");
                                            break;
                                    }
                                } else {
                                    System.out.println("User not found!");
                                }
                            }else{
                                System.out.println("Only Employees and admin can edit users.");
                            }
                            break;
                        case 3://remove user
                            if(user.getAccess().equals(Access.ADMIN) || user.getAccess().equals(Access.EMPLOYEE)) {
                                System.out.println("Enter the username of user");
                                String userName = scan.next();
                                int index = User.mainUserSearch(userName, userList);
                                if (index >= 0) {
                                    userList.remove(userList.get(index));
                                } else {
                                    System.out.println("User not found!");
                                }
                            }else{
                                System.out.println("Only Employees and admin can remove users.");
                            }
                            break;
                        case 4://back to last menu
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Enter your username:");
                    String userName = scan.next();
                    if(userName.equals(user.getUserName())) {
                        int index = User.mainUserSearch(userName, userList);
                        if (index >= 0) {
                            System.out.println("What are you going to do?");
                            System.out.println("1- Edit username");
                            System.out.println("2- Edit password");
                            System.out.println("3- Edit emial");
                            System.out.println("4- Edit phone number");
                            choice = scan.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Enter new username");
                                    userList.get(index).setUserName(scan.next());
                                    break;
                                case 2:
                                    System.out.println("Enter new passwrord");
                                    userList.get(index).setPassword(scan.next());
                                    break;
                                case 3:
                                    System.out.println("Enter email");
                                    userList.get(index).setEmial(scan.next());
                                    break;
                                case 4:
                                    System.out.println("Enter phone number");
                                    userList.get(index).setPhone_number(scan.next());
                                    break;
                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                        } else {
                            System.out.println("Invalid input!");
                        }
                    }else{
                        System.out.println("This is not your username!");
                    }
                case 7://exit
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
        System.out.println("5- Handle Users");
        System.out.println("6- Edit your informations");
        System.out.println("7- Exit");
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
}