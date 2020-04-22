package ir.ac.kntu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tour {
    private String name;
    private int identifier;
    private Date dateOFStart;
    private int duration;
    private Date datOfEnd;
    private Region region;
    private long price;
    private int minCapacity;
    private int maxCapacity;
    private String begin;
    private String destination;
    private HowToTravel howToTravel;
    private Map< Integer,String> orderedSubRegions= new HashMap<>();//String is the name of the place and Integer is number of day
    private  Leader tourLeader;

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setDateOFStart(Date dateOFStart) {
        this.dateOFStart = dateOFStart;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDatOfEnd(Date datOfEnd) {
        this.datOfEnd = datOfEnd;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setHowToTravel(HowToTravel howToTravel) {
        this.howToTravel = howToTravel;
    }

    public void setOrderedSubRegions(Map<Integer, String> orderedSubRegions) {
        this.orderedSubRegions = orderedSubRegions;
    }

    public void setTourLeader(Leader tourLeader) {
        this.tourLeader = tourLeader;
    }

    public String getName() {
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getBegin() {
        return begin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDateOFStart() {
        return dateOFStart;
    }

    public Date getDatOfEnd() {
        return datOfEnd;
    }

    public Map< Integer,String> getOrderedSubRegions() {
        return orderedSubRegions;
    }

    public int getDuration() {
        return duration;
    }

    public long getPrice() {
        return price;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public HowToTravel getHowToTravel() {
        return howToTravel;
    }

    public Region getRegion() {
        return region;
    }

    public Leader getTourLeader() {
        return tourLeader;
    }

    public Tour(String name, int identifier, Date dateOFStart, Date datOfEnd, int duration, Region region, long price, int minCapacity, int maxCapacity, String begin, String destination, HowToTravel howToTravel, Map<Integer,String> orderedSubRegions, Leader tourLeader){
        this.name=name;
        this.identifier=identifier;
        this.dateOFStart=dateOFStart;
        this.datOfEnd=datOfEnd;
        this.duration=duration;
        this.region=region;
        this.price=price;
        this.minCapacity=minCapacity;
        this.maxCapacity=maxCapacity;
        this.begin=begin;
        this.destination=destination;
        this.howToTravel=howToTravel;
        this.orderedSubRegions=orderedSubRegions;
        this.tourLeader=tourLeader;
    }
    public Tour(String name, int identifier, Date dateOFStart, Date datOfEnd, int duration, Region region, long price, int minCapacity, int maxCapacity, String begin, HowToTravel howToTravel, Map<Integer,String> orderedSubRegions, Leader tourLeader){
        this.name=name;
        this.identifier=identifier;
        this.dateOFStart=dateOFStart;
        this.datOfEnd=datOfEnd;
        this.duration=duration;
        this.region=region;
        this.price=price;
        this.minCapacity=minCapacity;
        this.maxCapacity=maxCapacity;
        this.begin=begin;
        this.howToTravel=howToTravel;
        this.orderedSubRegions=orderedSubRegions;
        this.tourLeader=tourLeader;
    }
    public Tour(String name,int duration,Region region,long price,int minCapacity,int maxCapacity){
        this.name=name;
        this.duration=duration;
        this.region=region;
        this.price=price;
        this.minCapacity=minCapacity;
        this.maxCapacity=maxCapacity;
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
    public static void editTour(){
        System.out.println("_____________________________________________________");
        System.out.println("Enter the number of the object that you want edit");
        System.out.println("1- Name");
        System.out.println("2- Identifier");
        System.out.println("3- Date of start");
        System.out.println("4- Duration");
        System.out.println("5- Region");
        System.out.println("6- price");
        System.out.println("7- Min and max of capacity");
        System.out.println("8- Begin and destination");
        System.out.println("9- How the tour will travel?");
        System.out.println("10- Order the subRegions");
    }
    public static void editKindOfTour(){
        System.out.println("_____________________________________________________");
        System.out.println("Enter the number of the object that you want edit");
        System.out.println("1- Name");
        System.out.println("2- Duration");
        System.out.println("3- Region");
        System.out.println("4- price");
        System.out.println("5- Min and max of capacity");
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
    public static Tour scanTour(List<Region> regionList, List <Leader> leaderList,List<ForeignTour> foreignTourList,List<InnerTour> innerTourList){
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
            region=new Region(regionName,Region.scanSubRegion());
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
        int index = Leader.mainLeaderSearch(scan.next(),scan.next(),leaderList);
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
                        if (Date.compareDate((leaderList.get(index).getFullDay().get(j)),date)==0){
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
        Tour tour = new Tour(name, identifier, dateOfStart, dateOfEnd, duration, region, price, minCapacity, maxCapacity, begin, destination, howToTravel, subRegion, leaderList.get(index));
        if(isForeign==true){
            ForeignTour foreignTour=new ForeignTour(name, identifier, dateOfStart, dateOfEnd, duration, region, price, minCapacity, maxCapacity, begin, destination, howToTravel, subRegion, leaderList.get(index));
            foreignTourList.add(foreignTour);
        }else{
            InnerTour innerTour=new InnerTour(name, identifier, dateOfStart, dateOfEnd, duration, region, price, minCapacity, maxCapacity, begin, howToTravel, subRegion, leaderList.get(index));
            innerTourList.add(innerTour);
        }
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
            region=new Region(regionName,Region.scanSubRegion());
            regionList.add(region);
        }
        System.out.println("Enter the price of tour:");
        long price=scan.nextLong();
        System.out.println("Enter the min and max of tour's capacity in order:");
        int minCapacity=scan.nextInt();
        int maxCapacity=scan.nextInt();
        Tour tour=new Tour(name,duration,region,price,minCapacity,maxCapacity);
        return tour;
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
    public static void searchTourByLeader(String firstName,String lastName,List<Tour> tourList,List<Leader>leaderList) {
        int index = Leader.mainLeaderSearch(firstName, lastName, leaderList);
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
                    if (Date.compareDate(date,tourList.get(i).getDateOFStart())==-1 ){
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
                    if (Date.compareDate(date,tourList.get(i).getDatOfEnd())==1 ){
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
                    if (Date.compareDate(date1,tourList.get(i).getDateOFStart())==-1 && Date.compareDate(date2,tourList.get(i).getDatOfEnd())==1 ){
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

}
