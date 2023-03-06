import java.util.ArrayList;
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
                System.out.println("El tipo de mapa no es correcto, ingresar de nuevo.");
            } else{

                System.out.println("SHOWING MENU");
                Map<String, ArrayList<String>> mapBuilt = MapBuilder.getInitialValues(map);

                while(true){

                    //Second Menu, user operations
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Mostrar categoria del producto");
                    System.out.println("3. Mostrar datos del producto");
                    System.out.println("4. Mostrar producto y los productos del la categoria ");
                    System.out.println("6. Mostrar producto y categoria existentes.");
                    System.out.println("7. Salir");
                    String menuSelection = in.nextLine();

                    switch (menuSelection){
                        case "1":
                            System.out.println(mapBuilt.size());
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        case "4":
                            break;
                        case "5":
                            break;
                        case "6":

                            //Might retire from scope.
                            for(Object key:mapBuilt.keySet()){
                                System.out.println("Categoria: "+key);
                                System.out.println(mapBuilt.get(key));
                                System.out.println("SIZE: "+mapBuilt.get(key).size());

                                for(int i = 0; i<mapBuilt.size();i++){
                                    try {
                                        System.out.println((i + 1) + ". " + mapBuilt.get(key).get(i));
                                    }catch (Exception e){
                                    }
                                }

                            }
                            break;
                        case "7":
                            return;
                        default:
                            System.out.println("getting out");
                            break;
                    }
                }
            }
        }
    }
}