package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    Map< Integer,String> orderedSubRegions= new HashMap<>();//String is the name of the place and Integer is number of day
    private  Leader tourLeader;
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