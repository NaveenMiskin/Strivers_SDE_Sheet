package Linked_List.Day_10;

public class P29_AddTwoNumberOfLL {
    
    // TC -> O(max(N, M))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;
        ListNode l = l1;
        ListNode r = l2;
        int carry = 0;
        while(l != null || r != null) {
            int sum = carry;
            if(l != null) sum += l.val;
            if(r != null) sum += r.val;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;

            if(l != null) l = l.next;
            if(r != null) r = r.next;
        }
        if(carry != 0) temp.next = new ListNode(carry);
        return dNode.next;
    }
}
