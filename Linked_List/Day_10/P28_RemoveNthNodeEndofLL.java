package Linked_List.Day_10;

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

public class P28_RemoveNthNodeEndofLL {

    // Brute Force
    // TC -> O(n + n)
    public ListNode removeNthFromEnd_BF(ListNode head, int n) {
        int cnt = 0;
        ListNode temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        int nthnode = cnt - n + 1;
        if(nthnode == 1) return head.next;

        temp = head;
        ListNode prev = null;
        while(nthnode > 1){
            prev = temp;
            temp = temp.next;
            nthnode--;
        }
        prev.next = temp.next;
        return head;
    }

    // TC -> O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        while(n > 0) {
            f = f.next;
            n--;
        }
        
        if(f == null) return head.next;
        ListNode s = head;
        while(f.next != null) {
            s = s.next;
            f = f.next;
        }

        s.next = s.next.next;
        return head;
    }
}
