class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<tokens.length; i++){
            switch(tokens[i]){
                case "+":
                int b = st.pop();
                int a = st.pop();
                st.push(a+b);
                break;
                case "-":
                 b = st.pop();
                 a = st.pop();
                st.push(a-b);
                break;
                case "*":
                 b = st.pop();
                 a = st.pop();
                st.push(a*b);
                break;
                case "/":
                 b = st.pop();
                 a = st.pop();
                st.push(a/b);
                break;
                default:
                st.push(Integer.parseInt(tokens[i]));

            }
        }
        return st.pop();       
        
    }
}
