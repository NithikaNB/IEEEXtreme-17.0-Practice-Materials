import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
        if (node != null) {
            minHeap.offer(node);
        }
    }
    
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (!minHeap.isEmpty()) {
        ListNode minNode = minHeap.poll();
        tail.next = minNode;
        tail = minNode;
        if (minNode.next != null) {
            minHeap.offer(minNode.next);
        }
    }
    
    return dummy.next;
}
