import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of elements in array ? ");
        int size = scanner.nextInt();
        Integer[] intList = new Integer[size];
        for (int i = 0; i < size; i++) {
            intList[i] = scanner.nextInt();
        }
        SegmentTree<Integer> segTree = new SegmentTree<>(intList);
        segTree.buildSegmentTree(Integer::max);
        System.out.println(segTree.printTree());
    }
}
