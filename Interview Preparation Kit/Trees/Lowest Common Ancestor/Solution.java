import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
        /* Start Of My Code */
        Node curr = root;
        while(root != null){
            // If current data if smaller than both v1 and v2, then they're both to his right, and current data isn't their lowest common ancestor
            if(curr.data < v1 && curr.data < v2)
                curr = curr.right;
            // Else, if current data if bigger than both v1 and v2, then they're both to his leftt, and current data isn't their lowest common ancestor
            else if(curr.data > v1 && curr.data > v2)
                curr = curr.left;
            // One vof v1 or v2 is to the left of the current data and the other is to the right, so current data is their lowest common ancestor
            else
                break;
        }
        return curr;
        /* End Of My Code */
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}