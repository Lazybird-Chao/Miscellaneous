package google;

public class TicTacToe {
	public:
	    /** Initialize your data structure here. */
	    TicTacToe(int n) {
	        board_size = n;
	        board = vector<vector<int>>(n, vector<int>(n, 0));
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    int move(int row, int col, int player) {
	        board[row][col] = player;
	        int i=0;
	        while(i<board_size && board[row][i]==player)
	            i++;
	        if(i==board_size)
	            return player;
	        i=0;
	        while(i<board_size && board[i][col]==player)
	            i++;
	        if(i==board_size)
	            return player;
	        if(row==col){
	            i=0;
	            while(i<board_size && board[i][i] == player)
	                i++;
	            if(i==board_size)
	                return player;
	        }
	        if(row+col == board_size-1){
	            i= 0;
	            while(i<board_size && board[i][board_size-1-i] == player)
	                i++;
	            if(i==board_size)
	                return player;
	        }
	        return 0;
	            
	    }
	private:
	    int board_size;
	    vector<vector<int>> board;

}
