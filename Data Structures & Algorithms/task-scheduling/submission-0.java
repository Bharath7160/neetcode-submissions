class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // The task with the most remaining copies comes first.
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Comparator.reverseOrder());

        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        // Each entry is {remainingCount, timeWhenCooldownEnds}.
        Queue<int[]> cooldown = new ArrayDeque<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1; // Run one task.

                if (remaining > 0) {
                    cooldown.offer(new int[]{remaining, time + n});
                }
            }

            // This task can be chosen starting in the next time slot.
            if (!cooldown.isEmpty() && cooldown.peek()[1] <= time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
