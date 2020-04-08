package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Region {
    private String name;
    private List<String> subRegion = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<String> getSubRegion() {
        return subRegion;
    }

    public Region(String name, List<String> subRegion) {
        this.name = name;
        for (int i = 0; i < subRegion.size(); i++) {
            this.subRegion.add(subRegion.get(i));
        }
    }
}