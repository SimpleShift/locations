import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Location> locations = new ArrayList<Location>();

    public static List<Location> getLocations() {
        return locations;
    }

    public static Location getLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id))
                return l;
        }

        return null;
    }

    public static void addLocation(Location e) {
        locations.add(e);
    }

    public static void deleteLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                locations.remove(l);
                break;
            }
        }
    }
}