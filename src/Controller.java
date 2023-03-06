import java.util.ArrayList;

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








}
