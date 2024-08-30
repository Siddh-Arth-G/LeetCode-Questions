class Solution {

    public void saveBoard(char[][] board, List<List<String>> allBoard){
        String row  = "";
        List<String> newBoard = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            row = "";
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'Q'){
                    row += 'Q';
                }else{
                    row += '.';
                }
            }
            newBoard.add(row);
        }
        allBoard.add(newBoard);
    }

    public boolean isSafe(int row, int col, char[][] board){
        // row check
        for(int i=0; i<board.length; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // colummn check
        for(int i=0; i<board[0].length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // left upper diagonal check
        for(int c=col,r=row; c>=0 && r>=0; c--, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // right upper diagonal check
        for(int c=col, r= row; c<board[0].length && r>=0; r--, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // left bottom digonal check
        for(int c= col, r= row; c>=0 && r<board.length; r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // right bottom diagonal check
        for(int c=col,r= row; c<board[0].length && r<board.length; r++, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public void queens(char[][] board, List<List<String>> allBoard, int col){
        if(col == board.length){
            saveBoard(board, allBoard);
            return;
        }
        for(int row=0; row<board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                queens(board, allBoard, col+1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];

        queens(board, allBoard, 0);
        return allBoard;
    }
}