import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExemploMap{
    public static void main(String[] args) {
        String [] array  = new String [10];
        array[0] = "Neto";
        array[1] = "Waldemar";
        System.out.println(" array 0 = " + array[0]);
        System.out.println(" array 1 = " + array[1]);

        List<String> l = new ArrayList<String>();
        l.add("Neto");
        l.add("Waldemar");
        System.out.println(" List 0 = " + l.get(0));
        System.out.println(" List 1 = " + l.get(1));

        Map<String, String> m = new TreeMap<String, String> ();
        m.put("nome", "Waldemar");
        m.put("apelido", "Neto");
        System.out.println(" Map para nome = " + m.get("nome"));
        System.out.println(" Map para apelido = " + m.get("apelido"));
        m.put("nome", "Waldemar Neto");
        System.out.println(" Map para nome = " + m.get("nome"));

    }
}