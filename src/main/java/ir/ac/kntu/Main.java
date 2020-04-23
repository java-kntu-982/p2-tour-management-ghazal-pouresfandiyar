package ir.ac.kntu;
import ir.ac.kntu.maputil.MapUtil;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/**
 * @author Ghazal pouresfandiyar
 * @version 11.0
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        int count=0;
        User loggedInUser=new User("admin");
        Scanner scan=new Scanner(System.in);
        boolean first , second=false;
        first=false;
        while (first==false) {
            System.out.println("________________________LOGIN________________________");
            System.out.println("Enter the username:");
            String userName = scan.next();
            if (userName.equals("admin")) {
                second=false;
                while (second == false) {
                    System.out.println("Enter the password:");
                    String password = scan.next();
                    if (password.equals(loggedInUser.getPassword())) {
                        loggedInUser.setAccess(Access.ADMIN);
                        first=true;
                        second=true;
                        System.out.println("_____________________________________________________");
                    } else {
                        System.out.println("Invalid password!Try again!");
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
        List<ForeignTour> foreignTourList=new ArrayList<>();
        List <InnerTour> innerTourList  = new ArrayList<>();
        System.out.println("Enter the current year:");
        int currentYear=scan.nextInt();
        boolean exit0 ,exit1 ,exit2 ,exit3 ,exit4  ,exit5  ,exit6  ,exit7 , exit8 ;
        while(true) {
            boolean third, fourth = false;
            third = false;
            if (count != 0) {
                while (third == false) {
                    System.out.println("________________________LOGIN________________________");
                    System.out.println("Enter the username:");
                    String userName = scan.next();
                    int index = User.mainUserSearch(userName, userList);
                    if (index >= 0) {
                        fourth = false;
                        while (fourth == false) {
                            System.out.println("Enter the password:");
                            String password = scan.next();
                            if (userList.get(index).getPassword().equals(password)) {
                                loggedInUser=new User(userName,password,userList.get(index).getAccess());
                                third = true;
                                fourth = true;
                                System.out.println("_____________________________________________________");
                            } else {
                                System.out.println("Invalid password!Try again!");
                            }
                        }
                    } else {
                        System.out.println("Invalid username!Try again!");
                    }
                }
            }
            count = 1;
            exit0=false;
            while (exit0 == false) {
                menu();
                int choice = scan.nextInt();
                switch (choice) {
                    case 1://handle tours
                        exit1 = false;
                        while (exit1 == false) {
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
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        kindsOfTours.add(Tour.scanKindsOfTour(regionList));
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 4://Add new tour
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        tourList.add(Tour.scanTour(regionList, leaderList,foreignTourList,innerTourList));
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 5://Remove tour
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter name of the tour and it's identifier:(it should be a space between them)");
                                        String tourName = scan.next();
                                        int identifier = scan.nextInt();
                                        int index = Tour.mainTourSearch(tourName, identifier, tourList);
                                        if (index >= 0) {
                                            tourList.remove(tourList.get(index));
                                        } else {
                                            System.out.println("Not found!");
                                        }
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 6://Edit kinds of tours
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter tour's name:");
                                        String tourName = scan.next();
                                        int index = Tour.mainKindsOfToursSearch(tourName, tourList);
                                        if (index >= 0) {
                                            Tour.editKindOfTour();
                                            int choice1 = scan.nextInt();
                                            switch (choice1) {
                                                case 1:
                                                    System.out.println("Enter new name:");
                                                    String name = scan.next();
                                                    kindsOfTours.get(index).setName(name);
                                                    break;
                                                case 2:
                                                    System.out.println("Enter the duration:");
                                                    int duration = scan.nextInt();
                                                    kindsOfTours.get(index).setDuration(duration);
                                                    break;
                                                case 3:
                                                    System.out.println("Enter the name of region:");
                                                    String regionName = scan.next();
                                                    boolean bool = false;
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
                                                case 4:
                                                    System.out.println("Enter price:");
                                                    kindsOfTours.get(index).setPrice(scan.nextLong());
                                                    break;
                                                case 5:
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
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 7://Edit tour's information
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter tour's name and identifier (with a space between them):");
                                        String tourName = scan.next();
                                        int identifier = scan.nextInt();
                                        int index = Tour.mainTourSearch(tourName, identifier, tourList);
                                        if (index >= 0) {
                                            Tour.editTour();
                                            int choice2 = scan.nextInt();
                                            switch (choice2) {
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
                                                    System.out.println("Enter date of start:(day,month,year)");
                                                    int day = scan.nextInt();
                                                    int month = scan.nextInt();
                                                    int year = scan.nextInt();
                                                    Date newDate = new Date(year, month, day);
                                                    tourList.get(index).setDateOFStart(newDate);
                                                    break;
                                                case 4:
                                                    System.out.println("Enter the duration:");
                                                    int duration = scan.nextInt();
                                                    tourList.get(index).setDuration(duration);
                                                    Date dateOfEnd = null;
                                                    for (int i = 0; i < duration; i++) {
                                                        dateOfEnd = tourList.get(index).getDateOFStart().nextDay();
                                                    }
                                                    tourList.get(index).setDatOfEnd(dateOfEnd);
                                                    break;
                                                case 5:
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
                                                case 6:
                                                    System.out.println("Enter price:");
                                                    tourList.get(index).setPrice(scan.nextLong());
                                                    break;
                                                case 7:
                                                    System.out.println("Enter the min and max of capacity in order:");
                                                    tourList.get(index).setMinCapacity(scan.nextInt());
                                                    tourList.get(index).setMaxCapacity(scan.nextInt());
                                                    break;
                                                case 8:
//                                                    System.out.println("Enter the beginning and the destination:(if it isn't foreign tour just enter beginning)");
//                                                    String begin, destination;
//                                                    if (tourList.get(index).isForeign() == false) {
//                                                        begin = scan.next();
//                                                        destination = begin;
//                                                    } else {
//                                                        begin = scan.next();
//                                                        destination = scan.next();
//                                                    }
//                                                    tourList.get(index).setBegin(begin);
//                                                    tourList.get(index).setDestination(destination);
                                                    break;
                                                case 9:
                                                    System.out.println("How the passengers will travel?");
                                                    System.out.println("1- By air");
                                                    System.out.println("2- On ground");
                                                    int choice3 = scan.nextInt();
                                                    HowToTravel howToTravel = HowToTravel.NONE;
                                                    switch (choice3) {
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
                                                case 10:
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
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 8:// Search a special tour
                                    exit2 = false;
                                    while (exit2 == false) {
                                        Tour.searchTourMenu();
                                        int choice4 = scan.nextInt();
                                        switch (choice4) {
                                            case 1://search by leaders
                                                System.out.println("Enter the firs name and last name:");
                                                String firstName = scan.next();
                                                String lastName = scan.next();
                                                Tour.searchTourByLeader(firstName, lastName, tourList, leaderList);
                                                break;
                                            case 2://search based on date
                                                Date.dateMenu();
                                                int choice5 = scan.nextInt();
                                                Tour.searchTourByDate(choice5, tourList);
                                                break;
                                            case 3://search by duration
                                                System.out.println("Enter duration:");
                                                int duration = scan.nextInt();
                                                Tour.searchTourByDuration(duration, tourList);
                                                break;
                                            case 4://search based on subRegion
                                                System.out.println("Enter the name of subRegion:");
                                                String subRegionName = scan.next();
                                                Tour.searchTourBySubRegion(subRegionName, tourList);
                                                break;
                                            case 5://search by region
                                                System.out.println("Enter the name of region:");
                                                String regionName = scan.next();
                                                Tour.searchTourByRegion(regionName, tourList);
                                                break;
                                            case 6://search by capacity
                                                System.out.println("Enter capacity:");
                                                int capacity = scan.nextInt();
                                                Tour.searchTourByCapacity(capacity, tourList);
                                                break;
                                            case 7://search by price
                                                Tour.priceMenu();
                                                int choice6 = scan.nextInt();
                                                Tour.searchTourByPrice(choice6, tourList);
                                                break;
                                            case 8://back to menu
                                                exit2 = true;
                                                break;
                                        }
                                    }
                                    break;
                                case 9://search kinds of tour
                                    exit3 = false;
                                    while (exit3 == false) {
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
                                                String subRegionName = scan.next();
                                                Tour.searchKindOfTourBySubRegion(subRegionName, kindsOfTours);
                                                break;
                                            case 3://search by region
                                                System.out.println("Enter the name of region:");
                                                String regionName = scan.next();
                                                Tour.searchKindOfTourByRegion(regionName, kindsOfTours);
                                                break;
                                            case 4://search by capacity
                                                System.out.println("Enter capacity:");
                                                int capacity = scan.nextInt();
                                                Tour.searchKindOfTourByCapacity(capacity, kindsOfTours);
                                                break;
                                            case 5://search by price
                                                Tour.priceMenu();
                                                int choice8 = scan.nextInt();
                                                Tour.searchKindOfTourByPrice(choice8, kindsOfTours);
                                                break;
                                            case 6://back to menu
                                                exit3 = true;
                                                break;
                                        }
                                    }
                                    break;
                                case 10:// Back to Menu
                                    exit1 = true;
                                    break;
                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                        }
                        break;
                    case 2://handle leaders
                        exit4 = false;
                        while (exit4 == false) {
                            Leader.leaderMenu();
                            int choice9 = scan.nextInt();
                            switch (choice9) {
                                case 1://show list of leaders
                                    Leader.showLeaders(leaderList);
                                    break;
                                case 2://add new leader
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        leaderList.add(Leader.scanLeader(currentYear));
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 3://remove leader
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter first name and last name:");
                                        String firstName = scan.next();
                                        String lastName = scan.next();
                                        int index = Leader.mainLeaderSearch(firstName, lastName, leaderList);
                                        if (index >= 0) {
                                            leaderList.remove(leaderList.get(index));
                                        } else {
                                            System.out.println("Not found!");
                                        }
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 4://edit leader
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter first name and last name:");
                                        String firstName = scan.next();
                                        String lastName = scan.next();
                                        int index = Leader.mainLeaderSearch(firstName, lastName, leaderList);
                                        if (index >= 0) {
                                            Leader.editLeader();
                                            int choice10 = scan.nextInt();
                                            switch (choice10) {
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
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 5://search leader and print result
                                    exit5 = false;
                                    while (exit5 == false) {
                                        Leader.searchLeaderMenu();
                                        int choice10 = scan.nextInt();
                                        switch (choice10) {
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
                                                for (int i = 0; i < leaderList.size(); i++) {
                                                    for (int j = 0; j < leaderList.get(i).getRegionOfLeader().size(); j++) {
                                                        if (regionName.equals(leaderList.get(i).getRegionOfLeader().get(j))) {
                                                            System.out.println("* " + leaderList.get(i).getFirstName() + " " + leaderList.get(i).getLastName());
                                                        }
                                                    }
                                                }
                                                break;
                                            case 4://search by age
                                                Leader.ageMenu();
                                                int choice12 = scan.nextInt();
                                                Leader.searchLeaderByAge(choice12, leaderList);
                                                break;
                                            case 5://back to menu
                                                exit5 = true;
                                                break;
                                        }
                                    }
                                    break;
                                case 6://back to menu
                                    exit4 = true;
                                    break;
                            }
                        }
                        break;
                    case 3://use map
                        exit6 = false;
                        while (exit6 == false) {
                            mapMenu();
                            int choice13 = scan.nextInt();
                            int identifier, index = -1 ,index1=-1;
                            if (choice13 != 1 && choice13 != 2) {
                                System.out.println("Enter the name and identifier of the tour:");
                                String tourName = scan.next();
                                identifier = scan.nextInt();
                                index = Tour.mainTourSearch(tourName, identifier, tourList);
                                index1= ForeignTour.mainForeignTourSearch(tourName,identifier,foreignTourList);
                            }
                            switch (choice13) {
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
                                    if (index1 >= 0) {
                                        System.out.println("Enter the number of the day that you want to see the location of the tour in it(it should be less than duration of the tour):");
                                        int num = scan.nextInt();
                                        if (num <= foreignTourList.get(index1).getDuration()) {
                                            MapUtil.showMap(foreignTourList.get(index1).getOrderedSubRegions().get(num));
                                        }
                                    }
                                    break;
                                case 4:// Show the beginning city or destination
                                    if (index >= 0) {
                                        System.out.println("What are you going to search for?");
                                        System.out.println("1- Beginning of the tour");
                                        System.out.println("2- Destination of the tour");
                                        int choice14 = scan.nextInt();
                                        switch (choice14) {
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
                                    if (index1 >= 0) {
                                        MapUtil.showMap(foreignTourList.get(index1).getBegin(), foreignTourList.get(index1).getDestination());
                                    } else {
                                        System.out.println("Tour not found!");
                                    }
                                    break;
                                case 6://Show the subRegions of a foreign tour
                                    if (index1 >= 0) {
                                        for (int i = 0; i < foreignTourList.get(index1).getRegion().getSubRegion().size(); i++) {
                                            MapUtil.showMap(foreignTourList.get(index1).getRegion().getSubRegion().get(i));
                                        }
                                    } else {
                                        System.out.println("This option is just for foreign tours!");
                                    }
                                    break;
                                case 7://back to menu
                                    exit6 = true;
                                    break;
                            }
                        }
                        break;
                    case 4: //handle regions
                        exit7 = false;
                        while (exit7 == false) {
                            Region.regionMenu();
                            int choice15 = scan.nextInt();
                            switch (choice15) {
                                case 1://show all regions
                                    Region.showRegions(regionList);
                                    break;
                                case 2://add new region
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter region's name:");
                                        String regionName = scan.next();
                                        subRegionList = Region.scanSubRegion();
                                        Region region = new Region(regionName, subRegionList);
                                        regionList.add(region);
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 3://edit region
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter name of region:");
                                        String regionName = scan.next();
                                        int index = Region.mainRegionSearch(regionName, regionList);
                                        if (index >= 0) {
                                            Region.editRegion();
                                            int choice16 = scan.nextInt();
                                            switch (choice16) {
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
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 4://remove region
                                    if (loggedInUser.getAccess().equals(Access.ADMIN)) {
                                        System.out.println("Enter name of the region:");
                                        String regionName = scan.next();
                                        int index = Region.mainRegionSearch(regionName, regionList);
                                        if (index >= 0) {
                                            regionList.remove(regionList.get(index));
                                        } else {
                                            System.out.println("Not found!");
                                        }
                                    } else {
                                        System.out.println("You can't do it,because you are not admin!");
                                    }
                                    break;
                                case 5://back to menu
                                    exit7 = true;
                                    break;
                            }
                        }
                        break;
                    case 5://Handle users
                        exit8 = false;
                        while (exit8 == false) {
                            User.userMenu();
                            int choice17 = scan.nextInt();
                            switch (choice17) {
                                case 1://add new user
                                    if (!loggedInUser.getAccess().equals(Access.CUSTOMER)) {
                                        User user = User.scanUser();
                                        System.out.println("Select the access mode:");
                                        System.out.println("1- Employee");
                                        System.out.println("2- Customer");
                                        System.out.println("3- Leader");
                                        int choice18 = scan.nextInt();
                                        switch (choice18) {
                                            case 1:
                                                if (!loggedInUser.getAccess().equals(Access.LEADER)) {
                                                    user = Employee.scanEmployee(user.getUserName(), user.getPassword());
                                                    user.setAccess(Access.EMPLOYEE);
                                                } else {
                                                    System.out.println("You are a leader and you can't add new employee!");
                                                }
                                                break;
                                            case 2:
                                                user.setAccess(Access.CUSTOMER);
                                                break;
                                            case 3:
                                                if (!loggedInUser.getAccess().equals(Access.LEADER)) {
                                                    user.setAccess(Access.LEADER);
                                                } else {
                                                    System.out.println("You are a leader and you can't add new leader!");
                                                }
                                                break;
                                            default:
                                                System.out.println("Invalid input!");
                                                break;
                                        }
                                        userList.add(user);
                                    } else {
                                        System.out.println("You are a customer and you can't add new user!");
                                    }
                                    break;
                                case 2://edit user
                                    if (loggedInUser.getAccess().equals(Access.ADMIN) || loggedInUser.getAccess().equals(Access.EMPLOYEE)) {
                                        System.out.println("Enter the username of user");
                                        String userName = scan.next();
                                        int index = User.mainUserSearch(userName, userList);
                                        if (index >= 0) {
                                            System.out.println("What are you going to do?");
                                            System.out.println("1- Edit username");
                                            System.out.println("2- Edit password");
                                            System.out.println("3- Edit emial");
                                            System.out.println("4- Edit phone number");
                                            int choice19 = scan.nextInt();
                                            switch (choice19) {
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
                                                    String mobile = scan.next();
                                                    if (User.checkMobile(mobile) == true) {
                                                        userList.get(index).setMobile(mobile);
                                                    } else {
                                                        System.out.println("Invalid phone number!");
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Invalid input!");
                                                    break;
                                            }
                                        } else {
                                            System.out.println("User not found!");
                                        }
                                    } else {
                                        System.out.println("Only Employees and admin can edit users.");
                                    }
                                    break;
                                case 3://remove user
                                    if (loggedInUser.getAccess().equals(Access.ADMIN) || loggedInUser.getAccess().equals(Access.EMPLOYEE)) {
                                        System.out.println("Enter the username of user");
                                        String userName = scan.next();
                                        int index = User.mainUserSearch(userName, userList);
                                        if (index >= 0) {
                                            userList.remove(userList.get(index));
                                        } else {
                                            System.out.println("User not found!");
                                        }
                                    } else {
                                        System.out.println("Only Employees and admin can remove users.");
                                    }
                                    break;
                                case 4://back to last menu
                                    exit8 = true;
                                    break;
                            }
                        }
                        break;
                    case 6://edit your information
                        System.out.println("Enter your username:");
                        String userName = scan.next();
                        if (userName.equals(loggedInUser.getUserName())) {
                            int index = User.mainUserSearch(userName, userList);
                            if (index >= 0) {
                                System.out.println("What are you going to do?");
                                System.out.println("1- Edit username");
                                System.out.println("2- Edit password");
                                System.out.println("3- Edit emial");
                                System.out.println("4- Edit phone number");
                                int choice20 = scan.nextInt();
                                switch (choice20) {
                                    case 1:
                                        System.out.println("Enter new username");
                                        userList.get(index).setUserName(scan.next());
                                        break;
                                    case 2:
                                        System.out.println("Enter new password");
                                        userList.get(index).setPassword(scan.next());
                                        break;
                                    case 3:
                                        System.out.println("Enter email");
                                        userList.get(index).setEmial(scan.next());
                                        break;
                                    case 4:
                                        System.out.println("Enter phone number");
                                        userList.get(index).setMobile(scan.next());
                                        break;
                                    default:
                                        System.out.println("Invalid input!");
                                        break;
                                }
                            } else {
                                System.out.println("Invalid input!");
                            }
                        } else {
                            System.out.println("This is not your username!");
                        }
                        break;
                    case 7://exit
                        exit0 = true;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
    }
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