package com.simpleshift.app.locations;

import java.util.ArrayList;
import java.util.List;

class Database {
    private static List<Location> locations = new ArrayList<Location>();

    static List<Location> getLocations() {
        return locations;
    }

    static Location getLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id))
                return l;
        }

        return null;
    }

    static void addLocation(Location e) {
        locations.add(e);
    }

    static void deleteLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                locations.remove(l);
                break;
            }
        }
    }
}