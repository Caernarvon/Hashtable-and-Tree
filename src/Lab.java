import java.math.BigDecimal;
import java.util.*;
public class Lab {
    public static void main(String[] args) {


        Tree<Integer> treeSeq = new Tree<Integer>();
        Tree<Integer> treeRnd = new Tree<Integer>();
        //fillTree(tree);

        //System.out.println("Fill tree with sequental elements");
        int b;
        Integer a = 0;
        long tStart = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            a++;
            treeSeq.insert(a);
        }
        long tEnd = System.nanoTime();
        System.out.println("Fill to 1k sequental tree: \t\t" + (tEnd - tStart) + " ns.");
        //System.out.println("Fill random tree: ");
        tStart = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            b = (int) (Math.random()*(2000+1)) - 1000;
            a = b;
            treeRnd.insert(a);
        }
        tEnd = System.nanoTime();
        System.out.println("Fill to 1k random tree: \t\t" + (tEnd - tStart) + " ns.");

        //элементы последовательного дерева
        //System.out.println("sequental tree: ");
        List <Integer> listSeq = treeSeq.getNodes();
        //System.out.println(listSeq);
        //treeSeq.printTree();
        //System.out.println();

        //элементы рандомного дерева
        //System.out.println("random tree: ");
        List <Integer> listRnd = treeRnd.getNodes();
        //System.out.println(listRnd);
        //treeRnd.printTree();
        //System.out.println();

        //сортирую список последовательного дерева и позже заполняю его
        tStart = System.nanoTime();
        Collections.sort(listSeq);
        Tree<Integer> newSeqTree = new Tree<Integer>();
        newSeqTree.createTreeFromList(listSeq);
        tEnd = System.nanoTime();
        //System.out.println("sequental tree after sorting");
        //System.out.println(listSeq);
        System.out.println("Sort + fill 1k seq tree: \t\t" + (tEnd - tStart) + " ns.");
        //System.out.println();

        //сортирую список рандомного дерева и позже заполняю его
        tStart = System.nanoTime();
        Collections.sort(listRnd);
        Tree<Integer> newRndTree = new Tree<Integer>();
        newRndTree.createTreeFromList(listRnd);
        tEnd = System.nanoTime();
        //System.out.println("random tree after sorting");
        //System.out.println(listRnd);
        System.out.println("Sort + fill 1k rnd tree: \t\t" + (tEnd - tStart) + " ns.");
        //System.out.println();
        //newTree.printTree();


        //время поиска в не сбалансир. и сбалансир. деревьях
        tStart = System.nanoTime();
        treeRnd.find(Integer.valueOf(900));
        tEnd = System.nanoTime();
        System.out.println("Unsorted 1k tree findtime: \t\t" + (tEnd - tStart) + " ns.");
        tStart = System.nanoTime();
        newRndTree.find(Integer.valueOf(900));
        tEnd = System.nanoTime();
        System.out.println("Sorted 1k tree findtime: \t\t" + (tEnd - tStart) + " ns.");

        //System.out.println();

        a = 0;
        Tree <Integer> treeRem = new Tree<Integer>();
        for (int i = 0; i < 5; i++) {
            a++;
            treeRem.insert(a);
        }
        //treeRem.printTree();
        treeRem.Remove(Integer.valueOf(4));
        //System.out.println();
        //treeRem.printTree();

        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();




        HashTable3<Number, Number> table = new AdressHashTable<Number, Number>();

        int rand;
        BigDecimal balancePut;
        BigDecimal incomePut;
        BigDecimal outcomePut;
        long accPut;
        long txidPut;

        tStart = System.nanoTime();
        for(int i = 0; i < 1000; i++) {
            rand = (int) (Math.random()*(2000+1)) - 1000;
            balancePut = BigDecimal.valueOf(rand);
            rand = (int) (Math.random()*(2000+1)) - 1000;
            incomePut = BigDecimal.valueOf(rand);
            rand = (int) (Math.random()*(2000+1)) - 1000;
            outcomePut = BigDecimal.valueOf(rand);
            accPut = (long) (Math.random()*(2000+1)) - 1000;
            txidPut = (long) (Math.random()*(2000+1)) - 1000;
            table.push(balancePut, incomePut, outcomePut, accPut, txidPut);
        }
        tEnd = System.nanoTime();
        System.out.println("Hashtable 1k filltime: \t\t\t" + (tEnd - tStart) + " ns.");

        HashTable3<Number, Number> table2 = new AdressHashTable<Number, Number>();
        tStart = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            rand = (int) (Math.random()*(2000+1)) - 1000;
            balancePut = BigDecimal.valueOf(rand);
            rand = (int) (Math.random()*(2000+1)) - 1000;
            incomePut = BigDecimal.valueOf(rand);
            rand = (int) (Math.random()*(2000+1)) - 1000;
            outcomePut = BigDecimal.valueOf(rand);
            accPut = (long) (Math.random()*(2000+1)) - 1000;
            txidPut = (long) (Math.random()*(2000+1)) - 1000;
            table2.push(balancePut, incomePut, outcomePut, accPut, txidPut);
        }
        tEnd = System.nanoTime();
        System.out.println("Hashtable 10k filltime: \t\t" + (tEnd - tStart) + " ns.");

        //System.out.println(table2);

        tStart = System.nanoTime();
        table.get(300);
        tEnd = System.nanoTime();
        System.out.println("Search time in the table of 1k: " + (tEnd - tStart) + " ns.");

        tStart = System.nanoTime();
        table2.get(300);
        tEnd = System.nanoTime();
        System.out.println("Search time in the table of 10k:" + (tEnd - tStart) + " ns.");
    }
}
