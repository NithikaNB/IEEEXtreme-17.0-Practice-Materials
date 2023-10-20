import java.util.PriorityQueue;

public int kthSmallest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.offer(num);
    }
    int result = 0;
    for (int i = 0; i < k; i++) {
        result = minHeap.poll();
    }
    return result;
}
