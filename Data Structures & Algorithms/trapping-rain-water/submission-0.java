class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftmax = height[0];
        int rightmax = height[n-1];
        int i = 1; int j = n-2; int total_water=0;
        while(i <= j){
            if(leftmax <= rightmax){
                if(leftmax > height[i]){
                    total_water += (leftmax - height[i]);
                }
                else{
                    leftmax = height[i];
                }
                i++;
                } else{
                 if(rightmax > height[j]){
                    total_water += (rightmax - height[j]);
                } else{
                    rightmax = height[j];
                }
                j--;
            }
        }
        return total_water;
    }
}
