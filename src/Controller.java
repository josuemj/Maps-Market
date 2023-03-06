import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

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

    /**
     * Receives the list of categories and check if the given one belongs to it so the user can put article
     * @param map
     * @param cat
     * @return
     */
    public static boolean isMapCategory(Map<String,ArrayList<String>> map,String cat){
        for(String key: map.keySet()){
            if(key.equals(cat)){
                return true;
           }
        }
        return false;
    }

    /**
     * Method verifies if the article given is in the main map, bool to show additional information.
     * @param map
     * @param article
     * @param showCat
     * @return
     */

    public static boolean isArticle(Map<String,ArrayList<String>> map, String article,boolean showCat){
        for(String key: map.keySet()){
            for(int i = 0; i<map.get(key).size();i++){
                try {
                    if (map.get(key).get(i).equals(article)) {
                        if (showCat){
                            System.out.println("Categoria de: "+article+" -- "+key);
                        }
                        return true;
                    }
                }catch (Exception e){
                }
            }
        }
        return false;
    }

    /**
     * product checks if product is on the scope si the list won't be triggered.
     * @param userMap
     * @param product
     * @return
     */
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

    /**
     * Software control func might change.
     * @param map
     */

    public static void iterateMap(Map<String,Integer> map){
        for (String key: map.keySet()){
            System.out.println("KEY: "+key+" VALUE: "+map.get(key));
        }
    }

    public static void articleInfo(Scanner in,Map mapBuilt,Map userMap,boolean userProduct){
        System.out.println("Ingresar el articulo");
        String art = in.nextLine();
        if (Controller.isArticle(mapBuilt,art,true)){
            System.out.println("==========================");
            if(userProduct){
                //Checks if user has the art
               if(Controller.userHasArt(userMap,art)){
               }else{
                   System.out.println("El usuario no tiene el producto en su coleccion");
               }
            }
        }else{
            System.out.println("Articulo no encontrado ;(");
        }
    }

    public static boolean userHasArt(Map<String,Integer> userMap,String art){
        for(String key: userMap.keySet()){
            if(art.equals(key)){
                System.out.println("Usuario tiene: "+userMap.get(key)+" de "+key);
                return true;
            }
        }
        return false;
    }

    public static void showSortUserInfor(Map<String,ArrayList<String>> mapBuilt, Map<String,Integer> userMap,boolean userInfor){
        for(String key: mapBuilt.keySet()){
            System.out.println("\nCATEGORIA: "+key);
            for(int i = 0; i<mapBuilt.size();i++) {
                try {
                    if (userInfor){
                        if (userMap.get(mapBuilt.get(key).get(i))==null){
                            System.out.println((i + 1) + ". " + mapBuilt.get(key).get(i)+" --User collection: 0");
                        }else{
                            System.out.println((i + 1) + ". " + mapBuilt.get(key).get(i)+" --User collection: "+userMap.get(mapBuilt.get(key).get(i)));
                        }
                    }else{
                        System.out.println((i + 1) + ". " + mapBuilt.get(key).get(i));
                    }
                } catch (Exception e) {
                }
            }

        }
    }
}
