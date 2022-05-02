package Binary_Tree;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class SumPairBST
{
    static Scanner in;
    static ArrayList<Integer> bstList;
    
    static {
        SumPairBST.in = new Scanner(System.in);
        SumPairBST.bstList = new ArrayList<Integer>();
    }
    
    static SumPairBST.Node newNode(SumPairBST.Node node, final int data) {
        node = new SumPairBST.Node();
        node.key = data;
        node.left = null;
        node.right = null;
        return node;
    }
    
    public SumPairBST.Node insert(SumPairBST.Node root, final int data) {
        if (root == null) {
            root = newNode(root, data);
        }
        else if (data < root.key) {
            root.left = this.insert(root.left, data);
        }
        else if (data > root.key) {
            root.right = this.insert(root.right, data);
        }
        else {
            System.out.println("Value already present!");
        }
        return root;
    }
    
    public boolean haveSumPair(final int sum) {
        final int sumHalf = sum / 2;
        int indexOf = 0;
        for (final int val : SumPairBST.bstList) {
            if (val > sumHalf) {
                indexOf = SumPairBST.bstList.indexOf(val);
                break;
            }
        }
        final int checkSum = SumPairBST.bstList.get(indexOf);
        while (indexOf > 0) {
            --indexOf;
            if (checkSum + SumPairBST.bstList.get(indexOf) == sum) {
                System.out.println(SumPairBST.bstList.get(indexOf) + " + " + checkSum + " = " + sum);
                return true;
            }
        }
        return false;
    }
    
    public void inOrderTraversal(final SumPairBST.Node root) {
        if (root == null) {
            return;
        }
        this.inOrderTraversal(root.left);
        System.out.print(String.valueOf(root.key) + " ");
        SumPairBST.bstList.add(root.key);
        this.inOrderTraversal(root.right);
    }
    
    public static void main(final String[] args) {
        final SumPairBST bst = new SumPairBST();
        System.out.print("Enter the number of values to insert in BST :: ");
        final int n = SumPairBST.in.nextInt();
        SumPairBST.Node root = null;
        for (int i = 1; i <= n; ++i) {
            System.out.print("Enter value " + i + " : ");
            root = bst.insert(root, SumPairBST.in.nextInt());
        }
        System.out.println("\nInorder Traversal : ");
        bst.inOrderTraversal(root);
        System.out.println();
        System.out.print("Enter the check sum :  ");
        final int sum = SumPairBST.in.nextInt();
        if (bst.haveSumPair(sum)) {
            System.out.println("Nodes are found.");
        }
        else {
            System.out.println("Could not find nodes");
        }
    }
}