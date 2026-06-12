package Linked_List.Day_9;

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

public class P26_FindMiddleOfLL {


    // Brute Force
    // TC -> O(n + n);
    public ListNode middleNode_BF(ListNode head) {
        int n = 0;
        ListNode t1 = head;
        while (t1 != null) {
            n++;
            t1 = t1.next;
        }
        int mid = (n / 2) + 1;
        t1 = head;
        while (t1 != null) {
            mid -= 1;
            if (mid == 0)
                break;
            t1 = t1.next;
        }
        return t1;
    }

    // optimal approach
    // TC -> O(n)
    // SC -> O(1);
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
