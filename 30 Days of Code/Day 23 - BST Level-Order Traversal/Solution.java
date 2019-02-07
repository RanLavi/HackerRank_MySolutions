import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

static void levelOrder(Node root){
    /* Start of my code */
    // Creating a linked list of nodes, using the queue interface in order to utilize FIFO
    Queue<Node> myQueue = new LinkedList<Node>();
    if(root != null) {
        // Add current root
        myQueue.add(root);
        
        // While there are nodes to process
        while( myQueue.peek()!=null ) {
            // Remove next node
            Node tree = myQueue.remove();
            
            System.out.print(tree.data + " ");
            
            // Add child elements from next level in order
            if( tree.left!=null ) {
                myQueue.add(tree.left);
            }
            if( tree.right!=null ) {
                myQueue.add(tree.right);
            }
        }
    }
    /* End of my code */ 
}
      

public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}