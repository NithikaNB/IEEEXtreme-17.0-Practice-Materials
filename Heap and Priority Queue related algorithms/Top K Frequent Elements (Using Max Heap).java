import java.util.*;

public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }
    
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue()
    );
    
    maxHeap.addAll(frequencyMap.entrySet());
    
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
        result[i] = maxHeap.poll().getKey();
    }
    return result;
}
