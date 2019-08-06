import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinterTest {

    private static Node4<Integer> test1() {
        Node4<Integer> root = new Node4<Integer>(2);
        Node4<Integer> n11 = new Node4<Integer>(7);
        Node4<Integer> n12 = new Node4<Integer>(5);
        Node4<Integer> n21 = new Node4<Integer>(2);
        Node4<Integer> n22 = new Node4<Integer>(6);
        Node4<Integer> n23 = new Node4<Integer>(3);
        Node4<Integer> n24 = new Node4<Integer>(6);
        Node4<Integer> n31 = new Node4<Integer>(5);
        Node4<Integer> n32 = new Node4<Integer>(8);
        Node4<Integer> n33 = new Node4<Integer>(4);
        Node4<Integer> n34 = new Node4<Integer>(5);
        Node4<Integer> n35 = new Node4<Integer>(8);
        Node4<Integer> n36 = new Node4<Integer>(4);
        Node4<Integer> n37 = new Node4<Integer>(5);
        Node4<Integer> n38 = new Node4<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }
    Private static Node4<Integer> test3(){
    	
    }

    private static Node4<Integer> test2() {
    	Tree t2 = new Tree(); 
        int arr[] = { 10,12,15,4,6,7,18,25,2,14,9,15,9,12,65,80,45,40,12,35,2,8,44,50,22 }; 
        t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
        Node4<Integer> root = new Node4<Integer>(10);
        Node4<Integer> n11 = new Node4<Integer>(12);
        Node4<Integer> n12 = new Node4<Integer>(15);
        Node4<Integer> n21 = new Node4<Integer>(4);
        Node4<Integer> n22 = new Node4<Integer>(6);
        Node4<Integer> n23 = new Node4<Integer>(7);
        Node4<Integer> n31 = new Node4<Integer>(18);
        Node4<Integer> n32 = new Node4<Integer>(25);
        Node4<Integer> n33 = new Node4<Integer>(2);
        Node4<Integer> n50 = new Node4<Integer>(14);
        Node4<Integer> n34 = new Node4<Integer>(9);
        Node4<Integer> n35 = new Node4<Integer>(15);
        Node4<Integer> n36 = new Node4<Integer>(9);
        Node4<Integer> n37 = new Node4<Integer>(12);
        Node4<Integer> n38 = new Node4<Integer>(65);
        Node4<Integer> n39 = new Node4<Integer>(80);
        Node4<Integer> n40 = new Node4<Integer>(45);
        Node4<Integer> n41 = new Node4<Integer>(40);
        Node4<Integer> n42 = new Node4<Integer>(12);
        Node4<Integer> n43 = new Node4<Integer>(35);
        Node4<Integer> n44 = new Node4<Integer>(2);
        Node4<Integer> n45 = new Node4<Integer>(8);
        Node4<Integer> n46 = new Node4<Integer>(44);
        Node4<Integer> n47 = new Node4<Integer>(50);
        Node4<Integer> n48 = new Node4<Integer>(22);
        Node4<Integer> n49 = new Node4<Integer>(2);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());
        Tree t2 = new Tree(); 
        int arr[] = { 10,12,15,4,6,7,18,25,2,14,9,15,9,12,65,80,45,40,12,35,2,8,44,50,22 }; 
        t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
        t2.inOrder(t2.root); 
        B

    }
}

class Node4<T extends Comparable<?>> {
    Node4<T> left, right;
    T data;

    public Node4(T data) {
        this.data = data;
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node4<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node4<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node4<T>> newNodes = new ArrayList<Node4<T>>();
        for (Node4<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node4<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
