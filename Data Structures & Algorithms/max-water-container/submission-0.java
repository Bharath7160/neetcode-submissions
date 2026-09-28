class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int max_area = 0;

        while(i<j){
           int area = Math.min(heights[i],heights[j])*(j-i);
           max_area=Math.max(max_area,area);
           if(heights[i]<heights[j]){
            i++;
           }
           else{
            j--;
           }
        }
        return max_area;
    }
}
