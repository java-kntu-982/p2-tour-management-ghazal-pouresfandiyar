package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
}