package google;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                updateNeighbor(board, i, j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                int livecount = board[i][j]>>1;
                int s = board[i][j] & 1;
                //System.out.println(livecount);
                if(s == 1 && (livecount < 2 || livecount >3))
                    s = 0;
                else if(s == 1 && livecount <=3 && livecount >=2)
                    s = 1;
                else if(s == 0 && livecount == 3)
                    s = 1;
                board[i][j] = s;
            }
        }
        return;
    }
    
    void updateNeighbor(int[][] board, int i, int j){
        int[] ni = {0,0,1,1,1,-1,-1,-1};
        int[] nj = {1,-1,0,1,-1,0,1,-1};
        if((board[i][j] & 1) == 0)
            return;
        for(int k = 0; k < 8; k++){
            int tmpi = i+ni[k];
            int tmpj = j + nj[k];
            if(isValid(board, tmpi, tmpj)){
                board[tmpi][tmpj] +=  (1<<1);
            }
        }
    }
    
    boolean isValid(int[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        return true;
    }

}
