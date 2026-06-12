package Linked_List.Day_10;

public class P30_DeleteNodeInaLL {
    // TC -> O(1)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
