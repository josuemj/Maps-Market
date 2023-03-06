import java.util.ArrayList;
import java.util.Map;

public class Controller {

    /**
     * Method checks if te category is already in the scope.
     * @param categories
     * @param category
     * @return boolean.
     */

    public static boolean categoryExists(ArrayList<String> categories, String category){
        for (int i = 0; i<categories.size();i++){
            if(categories.get(i).equals(category)){
                return true;
            }
        }
        return false;
    }

    public static boolean isMapCategory(Map<String,ArrayList<String>> map,String cat){
        for(String key: map.keySet()){
            if(key.equals(cat)){
                return true;
           }
        }
        return false;
    }

    public static boolean isArticle(Map<String,ArrayList<String>> map, String article){
        for(String key: map.keySet()){
            for(int i = 0; i<map.get(key).size();i++){
                try {
                    if (map.get(key).get(i).equals(article)) {
                        return true;
                    }
                }catch (Exception e){
                }
            }
        }
        return false;
    }

    public static boolean productInCollections(Map <String,Integer> userMap,String product){
        if (userMap.size() == 0){
            return false;
        }else{
            for(String key:userMap.keySet()){
                if (key.equals(product)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void iterateMap(Map<String,Integer> map){
        for (String key: map.keySet()){
            System.out.println("KEY: "+key+" VALUE: "+map.get(key));
        }

    }







}
