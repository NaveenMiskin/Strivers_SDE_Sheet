package Linked_List_Part_2.Day_12;

import java.util.ArrayList;
import java.util.List;

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


public class P34_CheckIfLLisPalindromeOrNot {

    // TC -> O(n + n)
    // SC -> O(n) for list to store the value
    public boolean isPalindrome_BF(ListNode head) {

        List<Integer> al = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            al.add(curr.val);
            curr = curr.next;
        }

        int l = 0;
        int r = al.size() - 1;
        while (l < r) {
            if (!al.get(l).equals(al.get(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }



    // TC -> O(n/2 + n/2 + n/2) overall O(n)  n/2 steps each
    // SC -> O(n) for recursive stack space...
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode secondhalf = reverse(s.next);

        ListNode l = head;
        ListNode r = secondhalf;
        while(r != null) {
            if(l.val != r.val) return false;
            l = l.next;
            r = r.next;
        }
        return true;
    }
}
