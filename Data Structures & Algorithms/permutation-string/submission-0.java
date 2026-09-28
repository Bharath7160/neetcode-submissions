class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Build map1 (frequency of s1)
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int windowSize = s1.length();

        // Build initial window in s2
        for (int i = 0; i < windowSize; i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // Check first window
        if (map1.equals(map2)) return true;

        // Sliding window
        for (int i = windowSize; i < s2.length(); i++) {

            char addChar = s2.charAt(i);
            char removeChar = s2.charAt(i - windowSize);

            // Add new char
            map2.put(addChar, map2.getOrDefault(addChar, 0) + 1);

            // Remove old char
            map2.put(removeChar, map2.get(removeChar) - 1);

            if (map2.get(removeChar) == 0) {
                map2.remove(removeChar);
            }

            // Compare maps
            if (map1.equals(map2)) return true;
        }

        return false;
    }
}
