package facebook;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if(board == null || board[0] == null)
            return false;
        if(word == null || word.isEmpty())
            return true;
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == w[0]){
                    board[i][j] = '#';
                    if(dfs(board, w, 0, i, j ))
                        return true;
                    board[i][j] = w[0];
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, char[] w, int index, int x, int y){
        if(index == w.length-1)
            return true;
        char nextc = w[index+1];
        int[] xn = {1,-1,0,0};
        int[] yn = {0,0,1,-1};
        for(int i=0; i < 4; i++){
            int xnext = x + xn[i];
            int ynext = y + yn[i];
            if(valid(board, xnext, ynext) && board[xnext][ynext] == nextc){
                board[xnext][ynext] = '#';
                if(dfs(board, w, index+1, xnext, ynext))
                    return true;
                else
                    board[xnext][ynext] = nextc;
            }
        }
        return false;
    }
    
    boolean valid(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
        return true;
    }

}
