package Linked_List_Part_2.Day_12;

import java.util.PriorityQueue;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
    
public class P36_FlatteingLL {

    // TC -> O(n)
    // SC -> O(n) for the priority Queue to store the elements for sorting
    // because it store min elemnt at top always stors element always in sorted order..
    public Node flatten_BF(Node root) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Node temp = root;
        
        while(temp != null) {
            Node btemp = temp;
            while(btemp != null) {
                pq.add(btemp.data);
                btemp = btemp.bottom;
            }
            temp = temp.next;
        }
        
        Node dNode = new Node(-1);
        Node cur = dNode;
        while(!pq.isEmpty()) {
            cur.bottom = new Node(pq.poll());
            cur = cur.bottom;
        }
        return dNode.bottom;
    }


    public Node mergeLL(Node list1, Node list2){
        Node dNode = new Node(-1);
        Node temp = dNode;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                temp.bottom = list1;
                temp = list1;
                list1 = list1.bottom;
            }
            else {
                temp.bottom = list2;
                temp = list2;
                list2 = list2.bottom;
            }
        }
        if(list1 != null){
            temp.bottom = list1;
        }
        else{
            temp.bottom = list2;
        }
        return dNode.bottom;
    }
    
    
    Node flatten(Node root) {
        
        if(root == null || root.next == null){
            return root;
        }
        Node mergedHead = flatten(root.next);
        Node head = mergeLL(root, mergedHead);
        return head;
    }
}
