class Solution {
    public int characterReplacement(String s, int k) {
        int max_length = 0;
        int max_freq = 0;
        int i = 0; int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            //calculate max_freq
            max_freq=0;
            for(char key: map.keySet()){
                max_freq = Math.max(max_freq, map.get(key));
            }
            //check condition
            if((j-i+1)-max_freq <= k){
                max_length = Math.max(max_length, j-i+1);
            }
            else{
                char leftch = s.charAt(i);
                map.put(leftch, map.get(leftch)-1);
                i++;

                //calculate max_freq
            max_freq=0;
            for(char key: map.keySet()){
                max_freq = Math.max(max_freq, map.get(key));
            }
            }
            j++;

        }
        return max_length;
    }
}
