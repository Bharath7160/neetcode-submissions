class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
         for(int n : nums){
            set.add(n);
         }
         int max_len = 0;
         for(int n : set){
            if(!set.contains(n-1)){
                int currentNum=n;
                int count = 1;
            
            while(set.contains(currentNum+1)){
                currentNum++;
                count++;
            }
            max_len=Math.max(max_len, count);
            }

         }
        return max_len;
    }
}
