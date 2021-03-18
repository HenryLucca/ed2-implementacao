import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Comparador{

    public static void strac(Runnable r){
        Instant start = Instant.now();
        r.run();
        Instant end = Instant.now();
        Duration interval = Duration.between(start, end);
 
        System.out.println("Tempo em nano para inserir: " + (interval.getNano()/1000));
    }
    public static void main(String[] args) {
        Random r = new Random();
        int [] numbers10000 = r.ints(1000, 0, 1000000).toArray();
        //int [] numbers1000 = r.ints(1000, 0, 1000000).toArray();
        //int [] numbers100 = r.ints(100, 0, 1000000).toArray();
        Runnable doIt = extracted(numbers10000, new LinkedList<Integer>());
        strac(doIt);
        
        doIt = extracted(numbers10000, new ArrayList<Integer>());
        strac(doIt);
        //https://github.com/TheAlgorithms/Java/tree/master/DataStructures/Trees
        AVLtree tree = new AVLtree();
        doIt = new Runnable() {
            @Override
            public void run() {
                for (Integer i : numbers10000) {
                    tree.insert(i);
                }
            }
        };
        strac(doIt);
        
        RedBlackBST tree2 = new RedBlackBST();
        doIt = new Runnable() {
            @Override
            public void run() {
                for (Integer i : numbers10000) {
                    tree2.insertDemo(i);
                }
            }
        };
        strac(doIt);
    }
    private static Runnable extracted(int[] numbers10000, List<Integer> lista) {
        Runnable doIt;
        doIt = new Runnable() {
            @Override
            public void run() {
                for (Integer i : numbers10000) {
                        lista.add(i);
                }
            }
        };
        return doIt;
    }
}