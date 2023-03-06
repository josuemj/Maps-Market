import java.util.*;

public class MapFactory {
    /**
     * Return the implementation of the map.
     * @param mapType
     * @return
     */

    public static Map getMap(String mapType){
        if (mapType.equals("1")) {
            return new HashMap<String, ArrayList<String>>();
        } else if (mapType.equals("2")) {
            return new TreeMap<String, ArrayList<String>>();
        } else if (mapType.equals("3")) {
            return new LinkedHashMap<String, ArrayList<String>>();
        }
        return null;
    }
}
