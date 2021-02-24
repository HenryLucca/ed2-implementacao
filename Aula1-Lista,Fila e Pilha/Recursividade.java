import java.util.ArrayList;
import java.util.LinkedList;

public class Recursividade {
    
    LinkedList<Integer> lista1 = new LinkedList<Integer>();
    ArrayList<Integer> lista2 = new ArrayList<Integer>();


    public static void funcRec(int numero){
        if(numero < 0){
            System.out.println("Acabou");
            return;
        }
        funcRec(numero -1);
        System.out.println("valor de numero "+numero);
        //funcRec(numero -1);
        return;
    }
    
    public static void main(String[] args) {
        funcRec(2);
    }
}
