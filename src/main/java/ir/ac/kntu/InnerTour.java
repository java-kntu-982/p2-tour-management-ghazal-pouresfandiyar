package ir.ac.kntu;

import java.util.Map;

public class InnerTour extends Tour {
    public InnerTour(String name, int identifier, Date dateOFStart, Date datOfEnd, int duration, Region region, long price, int minCapacity, int maxCapacity, String begin, HowToTravel howToTravel, Map<Integer,String> orderedSubRegions, Leader tourLeader){
        super(name,identifier,dateOFStart,datOfEnd,duration,region,price,minCapacity,maxCapacity,begin,howToTravel,orderedSubRegions,tourLeader);
    }
}
