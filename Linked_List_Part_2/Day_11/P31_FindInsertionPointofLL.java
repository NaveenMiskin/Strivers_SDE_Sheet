package Linked_List_Part_2.Day_11;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class P31_FindInsertionPointofLL {

    // TC -> O(n + n)
    // SC -> O(n) for map
    public ListNode getIntersectionNode_BF(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> hm = new HashMap<>();

        ListNode temp = headA;
        while(temp != null){
            hm.put(temp, 1);
            temp = temp.next;
        }

        temp = headB;
        while(temp != null){
            if(hm.containsKey(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // TC -> O(n); single pass
    // SC -> O(1);
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l = headA;
        ListNode r = headB;
        while(l != r) {
            l = l.next;
            r = r.next;

            if(l == r) return l;
            if(l == null) l = headB;
            if(r == null) r = headA;
        }
        return l;
    }
}
