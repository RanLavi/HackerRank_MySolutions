import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{
    public static Node removeDuplicates(Node head) {
        /* Start of my code */
        // If list is empty, return it
        if(head==null)
            return null;
        else{
            // Save reference to the head of the list
            Node curr = head;
            // Checking we didn't arrive to the last node
            while(curr.next != null){
                // If the data of the current node is equal to the data of the next node, then set the next node to be second next node, thus removing the current next node 
                if(curr.data == curr.next.data){
                    curr.next = curr.next.next;
                }
                // If the data of the current node isn't equal to the data of the next node, then we just move to the next node
                else
                    curr = curr.next;
            }
        // Return the original head. It will always remain unchanged since we removed duplicates always changing the next node, never the current one. And since we start with the head, there's no scenario that will cause it to change
        return head;
        }
    /* End of my code */
    }

	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }