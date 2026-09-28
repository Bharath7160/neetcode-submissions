class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
        String result = "";
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char ch : t.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch, 0)+1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        int i = 0; int j = 0;
        int formed = 0;
        int required = map1.size();
        int min_length = Integer.MAX_VALUE;
        int min_start = 0;

        while(j<s.length()){
                char schar = s.charAt(j);
                map2.put(schar,map2.getOrDefault(schar, 0)+1);
                if(map1.containsKey(schar) && map2.get(schar).intValue() == map1.get(schar).intValue()){
                    formed++;
                }
            while(i<=j && formed == required){
                if (j - i + 1 < min_length) {
                    min_length = j - i + 1;
                    min_start = i;
                }
            char remove = s.charAt(i);
            map2.put(remove, map2.get(remove) - 1);
           if (map1.containsKey(remove) && map2.get(remove) < map1.get(remove)) {
               formed--;
            }
                i++;
            }
            j++;
        }
        if(min_length == Integer.MAX_VALUE) return "";
        return s.substring(min_start, min_start + min_length);
        
    }
}
