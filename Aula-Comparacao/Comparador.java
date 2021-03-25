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
 
        System.out.println("Tempo em nano para procurar: " + (interval.getNano()/1000));
    }
    public static void main(String[] args) {
        Random r = new Random();
        //int [] numbers = r.ints(50000, 0, 1000000).toArray();
        int [] numbers = r.ints(10000, 0, 1000000).toArray();
        //int [] numbers = r.ints(1000, 0, 1000000).toArray();
        //int [] numbers = r.ints(100, 0, 1000000).toArray();

        //int [] numbers2 = r.ints(100, 0, 1000000).toArray();
        //int [] numbers2 = r.ints(500, 0, 1000000).toArray();
        //int [] numbers2 = r.ints(1000, 0, 1000000).toArray();
        //int [] numbers2 = r.ints(2000, 0, 1000000).toArray();
        int [] numbers2 = r.ints(5000, 0, 1000000).toArray();
        
        
        List<Integer> l = new LinkedList<Integer>();
        for (Integer i : numbers) {
            l.add(i);
        }
        Runnable doIt;
        doIt = new Runnable() {
            @Override
            public void run() {
                for (Integer i : numbers2) {
                        l.contains(i);
                }
            }
        };
        strac(doIt);
        
        
        List<Integer> l2 = new LinkedList<Integer>();
        for (Integer i : numbers) {
            l2.add(i);
        }
        doIt = new Runnable() {
            @Override
            public void run() {
                for (Integer i : numbers2) {
                        l2.contains(i);
                }
            }
        };
        strac(doIt);
        // //https://github.com/TheAlgorithms/Java/tree/master/DataStructures/Trees
        // AVLtree tree = new AVLtree();
        // for (Integer i : numbers) {
        //     tree.insert(i);
        // }
        // doIt = new Runnable() {
        //     @Override
        //     public void run() {
        //         for (Integer i : numbers2) {
        //             tree.;
        //         }
        //     }
        // };
        // strac(doIt);
        
        RedBlackBST tree2 = new RedBlackBST();
        for (Integer i : numbers) {
            tree2.insertDemo(i);
        }
        doIt = new Runnable() {
            @Override
            public void run() {
                for (Integer i : numbers) {
                    tree2.findNode(i);
                }
            }
        };
        strac(doIt);
    }
    private static Runnable extracted(int[] numbers, List<Integer> lista) {
        Runnable doIt;
        doIt = new Runnable() {
            @Override
            public void run() {
                for (Integer i : numbers) {
                        lista.add(i);
                }
            }
        };
        return doIt;
    }
}