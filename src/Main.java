import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //User collection

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

                Map<String, ArrayList<String>> mapBuilt = MapBuilder.getInitialValues(map); //Inventory
                Map<String,Integer> userCollection = MapFactory.getMap(mapType); //User Collection
                //Were key:product value: the qt

                while(true){

                    //Second Menu, user operations
                    System.out.println("MENU PRINCIPAL\n1) Agregar producto");
                    System.out.println("2) Mostrar categoria del producto");
                    System.out.println("3) Mostrar datos del producto");
                    System.out.println("4) Mostrar producto y los productos del la categoria ");
                    System.out.println("5) Mostrar el producto y la categoría de todo el inventario");
                    System.out.println("6) Mostrar producto y categoria existentes.");
                    System.out.println("7) Salir");
                    String menuSelection = in.nextLine();

                    switch (menuSelection){

                        case "1":
                            while(true){ //Forced to check.
                                System.out.println("Ingresar la categoria del producto: ");
                                String car = in.nextLine();
                                if (Controller.isMapCategory(mapBuilt,car)){
                                    System.out.println("Ingresar articulo");
                                    String art = in.nextLine();
                                    if(Controller.isArticle(mapBuilt,art,false)){
                                        //All verified in this scope.
                                        //Adding the article to user collection
                                        if(Controller.productInCollections(userCollection,art)){
                                            userCollection.put(art, userCollection.get(art)+1);
                                            Controller.iterateMap(userCollection);
                                        }else{
                                            userCollection.put(art,1);
                                            Controller.iterateMap(userCollection);
                                        }
                                        System.out.println("Artciulo agrado a la coleccion :)");
                                        break;
                                    }else{
                                        System.out.println("El articulo no existe o no es de la categoria: "+car);
                                    }
                                }else{
                                    System.out.println("La categoria no existe, ingresar de nuevo.");
                                }
                            }
                            break;
                        case "2":
                            Controller.articleInfo(in,mapBuilt,userCollection,false);
                            break;
                        case "3":
                            Controller.articleInfo(in,mapBuilt,userCollection,true);
                            break;
                        case "4":
                            Controller.showSortUserInfor(mapBuilt,userCollection,true);
                            break;
                        case "5":
                            break;
                        case "6":
                            Controller.showSortUserInfor(mapBuilt,userCollection,false);
                            break;
                        case "7":
                            return;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                }
            }
        }
    }
}