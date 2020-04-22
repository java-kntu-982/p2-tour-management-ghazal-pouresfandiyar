package ir.ac.kntu;
import java.util.HashMap;
import java.util.Map;

public class Tour {
    private String name;
    private int identifier;
    private Date dateOFStart;
    private boolean isForeign;
    private int duration;
    private Date datOfEnd;
    private Region region;
    private long price;
    private int minCapacity;
    private int maxCapacity;
    //if isforeign==false,then begin and destination is the same
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

    public void setForeign(boolean foreign) {
        isForeign = foreign;
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

    public boolean isForeign() {
        return isForeign;
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

    public Tour(String name, int identifier, Date dateOFStart, Date datOfEnd, boolean isForeign, int duration, Region region, long price, int minCapacity, int maxCapacity, String begin, String destination, HowToTravel howToTravel, Map<Integer,String> orderedSubRegions, Leader tourLeader){
        this.name=name;
        this.identifier=identifier;
        this.dateOFStart=dateOFStart;
        this.datOfEnd=datOfEnd;
        this.isForeign=isForeign;
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
    public Tour(String name,boolean isForeign,int duration,Region region,long price,int minCapacity,int maxCapacity){
        this.name=name;
        this.isForeign=isForeign;
        this.duration=duration;
        this.region=region;
        this.price=price;
        this.minCapacity=minCapacity;
        this.maxCapacity=maxCapacity;
    }
}
