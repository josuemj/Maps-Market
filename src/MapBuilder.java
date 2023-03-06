import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MapBuilder {

    /**
     * Method fills up the map with the content in file given.
     * @param map
     * @return map full of data
     */
    public static Map getInitialValues(Map<String,ArrayList<String>> map){
        BufferedReader reader = null;
        try {

            //Scr
            reader = new BufferedReader(new FileReader("ListadoProducto.txt"));
            String line = reader.readLine();
            ArrayList<String> categories = new ArrayList<String>();

            while (line != null) {

                //Splitting (Separating) the data to read elements.
                String[] lineSplited = line.split("[|]");
                //Like python String[x:y]
                String key = lineSplited[0].substring(0,lineSplited[0].length()-1); //The future map key
                //System.out.println("Key=="+key+"==lenght:"+key.length());
                String value = lineSplited[1].substring(1,lineSplited[1].length());
                //System.out.println("Value=="+value+"==lenght:"+value.length());

                if (Controller.categoryExists(categories,key)){
                    map.get(key).add(value);
                }else{
                    categories.add(key);
                    map.put(key,new ArrayList<String>());
                    map.get(key).add(value);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error con fil");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("ERROR");
            }
        }
    return map;
    }


}
