package ir.ac.kntu;

import java.util.List;
import java.util.Map;

public class ForeignTour extends Tour {
    String destination;
    public ForeignTour(String name, int identifier, Date dateOFStart, Date datOfEnd, int duration, Region region, long price, int minCapacity, int maxCapacity, String begin, String destination, HowToTravel howToTravel, Map<Integer,String> orderedSubRegions, Leader tourLeader){
        super(name,identifier,dateOFStart,datOfEnd,duration,region,price,minCapacity,maxCapacity,begin,destination,howToTravel,orderedSubRegions,tourLeader);
    }
    public static int mainForeignTourSearch(String tourName, int identifier, List<ForeignTour> foreignTourList){
        for(int i = 0; i < foreignTourList.size(); i++) {
            if(tourName.equals(foreignTourList.get(i).getName()) && identifier==foreignTourList.get(i).getIdentifier()){
                return i;
            }
        }
        return -1;
    }
}
