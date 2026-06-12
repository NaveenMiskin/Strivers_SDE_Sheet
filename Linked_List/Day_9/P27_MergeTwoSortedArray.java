package Linked_List.Day_9;

import java.util.ArrayList;

public class P27_MergeTwoSortedArray {

    // Brute Force
    // TC -> O(n + n + nlogn + n)
    // SC -> O(n)
    public ListNode convertToLL(int[] arr){
        if(arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for(int i=1; i<arr.length; i++){
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public ListNode mergeTwoLists_BF(ListNode list1, ListNode list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode t1 = list1;
        while(t1 != null){
            arr.add(t1.val);
            t1 = t1.next;
        }

        ListNode t2 = list2;
        while(t2 != null){
            arr.add(t2.val);
            t2 = t2.next;
        }
        
        arr.sort(null);

        int[] array = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            array[i] = arr.get(i);
        }

        ListNode head = convertToLL(array);
        return head;
    }

    // optimal approach..
    // TC -> O(n)

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;
        ListNode l = list1;
        ListNode r = list2;

        while(l != null && r != null) {
            if(l.val < r.val) {
                temp.next = l;
                l = l.next;
                temp = temp.next;
            }
            else {
                temp.next = r;
                r = r.next;
                temp = temp.next;
            }
        }
        if(l != null) temp.next = l;
        else temp.next = r;
        return dNode.next;
    }
}
