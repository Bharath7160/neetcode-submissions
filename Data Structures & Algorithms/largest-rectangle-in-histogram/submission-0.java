class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max_area = 0;

        for(int i =0 ; i<=n; i++){
            int h = (i==n) ? 0 : heights[i];

            while(!st.isEmpty() && h<heights[st.peek()]){
                int height = heights[st.pop()];
                int width;

                if(st.isEmpty()){
                    width = i;
                }
                    else {
                        width = i - st.peek() - 1;
                    }
                max_area = Math.max(max_area,height*width);
                }
                st.push(i);
            
        }
        return max_area;
        
    }
}
