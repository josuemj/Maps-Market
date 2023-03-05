import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true){
            System.out.println("Escoger implementacion\n1) HashMap\n2) TreeMap\n3) LinkeHashMap\n4) Salir");
            String mapType = in.nextLine();

            if (mapType.equals("4")){
                break;
            }

            Map map = MapFactory.getMap(mapType);

            if (map == null){
                System.out.println("Incorrect implementarion");
            } else{
                System.out.println("SHOWING MENU");
            }






        }
    }
}