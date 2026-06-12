package Linked_List_Part_2.Day_11;

public class P33_ReverseLLGroupOfK {

    // TC -> O(n / k) * O(k) total n / k groups for k element 
    // overall TC -> O(n)
    public ListNode reverseLL(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode findKthNode(ListNode head, int k){
        k -= 1;
        while(head != null && k > 0){
            k--;
            head = head.next;
        }
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null) {
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head) {
                head = kthNode;
            }
            else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
