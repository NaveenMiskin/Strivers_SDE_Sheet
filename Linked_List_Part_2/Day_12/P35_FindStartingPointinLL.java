package Linked_List_Part_2.Day_12;

import java.util.HashMap;

public class P35_FindStartingPointinLL {

    // TC -> O(n)
    // SC -> O(n) for HashMap....
    public ListNode detectCycle_BF(ListNode head) {
        HashMap<ListNode,Integer> hm = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            if(hm.containsKey(temp)){
                return temp;
            }
            hm.put(temp,1);
            temp = temp.next;
        }
        return null;
    }


    
    // TC -> O(n)

    // Floyd's Totoise and Hase approch for cycle detection.
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if(s == f){
                f = head;
                while(s != f) {
                    s = s.next;
                    f = f.next;
                }
                return s;
            }
        }
        return null;
    }
}
