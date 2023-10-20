import java.util.*;

public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> taskCount = new HashMap<>();
    for (char task : tasks) {
        taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.addAll(taskCount.values());

    int cycles = 0;
    while (!maxHeap.isEmpty()) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (!maxHeap.isEmpty()) {
                temp.add(maxHeap.poll());
            }
        }
        for (int count : temp) {
            if (count - 1 > 0) {
                maxHeap.offer(count - 1);
            }
        }
        cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
    }

    return cycles;
}
