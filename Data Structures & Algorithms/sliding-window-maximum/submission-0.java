class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

          int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>(); // stores indices
        int resIndex = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove elements out of window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // 2. Remove smaller elements (they are useless)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Store result when window is ready
            if (i >= k - 1) {
                result[resIndex++] = nums[dq.peekFirst()];
            }
        }

        return result;
        
    }
}
