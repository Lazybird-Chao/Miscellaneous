package contest;

public class CandyCrush {
	public int[][] candyCrush(int[][] board) {
        if(board == null || board.length == 0 || board[0].length ==0)
            return new int[0][0];
        int w = board[0].length;
        int h = board.length;
        boolean donecrush = false;
        while(true){
            donecrush = false;
            for(int i = 0; i < h; i++){
                for(int j = 0; j< w; j++){
                    if(board[i][j] > 0 && crush(board, i, j))
                       donecrush = true;
                }
            }
            if(donecrush){
                for(int j = 0; j < w; j++)
                    reformOneColumn(board, j); 
            }else
                break;
        }
        return board;  
    }
    void reformOneColumn(int[][] board, int col){
        int i = board.length-1;
        int j = board.length-1;
        while(j >= 0){
            if(board[j][col] > 0){
                board[i][col] = board[j][col];
                j--;
                i--;
            }else
                j--;
        }
        while(i >=0){
            board[i][col] = 0;
            i--;
        }
        return;
    }
    boolean crush(int[][] board, int i, int j){
        int up, down, left, right;
        up = down = i;
        left = right = j;
        boolean donecrush = false;
        while(up >= 0 && Math.abs(board[up][j]) == board[i][j])
            up--;
        up++;
        while(down < board.length && Math.abs(board[down][j]) == board[i][j])
            down++;
        down--;
        while(left>=0 && Math.abs(board[i][left]) == board[i][j])
            left--;
        left++;
        while(right < board[0].length && Math.abs(board[i][right]) == board[i][j])
            right++;
        right--;
        if(down-up+1 >= 3){
            for(int r = up; r<=down; r++){
                if(board[r][j] > 0)
                    board[r][j] = -1*board[r][j];
            }   
            donecrush = true;
        }
        if(right-left+1 >= 3){
            for(int c = left; c <= right; c++){
                if(board[i][c] > 0)
                    board[i][c] = -1*board[i][c];
            }
            donecrush = true;
        }
        return donecrush;
    }

}
