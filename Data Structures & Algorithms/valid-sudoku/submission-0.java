
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                char num = board[row][col];

                if (num=='.'){
                    continue;
                }

                String rowkey = num + "in rows" + row;
                String colkey = num + "in col" + col;
                String boxes = num + "in boxes" + (row/3) + "-" + (col/3);

                if(set.contains(rowkey)||
                   set.contains(colkey)||
                   set.contains(boxes)){
                    return false;
                   }
                   set.add(rowkey);
                   set.add(colkey);
                   set.add(boxes);

            }
        }
        return true;
    }
}
