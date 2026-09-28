class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            while(left<right && !isAlphaNumeric(s.charAt(left))){
                left++;
            }
            while(left<right && !isAlphaNumeric(s.charAt(right))){
                right--;
            }

            char l = toLower(s.charAt(left));
            char r = toLower(s.charAt(right));
            if(l != r){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
    public boolean isAlphaNumeric(char ch){
        if((ch >= 'a' && ch <= 'z')||
           (ch >= 'A' && ch <= 'Z')||
           (ch >= '0' && ch <= '9')){
            return true;
           }
           return false;
    }
    public char toLower(char ch){
        if(ch >= 'A' && ch <= 'Z'){
            ch = (char)(ch+32);
        }
        return ch;
    }
}
