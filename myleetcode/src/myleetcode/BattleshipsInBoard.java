package myleetcode;

public class BattleshipsInBoard {
	public int countBattleShip(char[][] board){
		if(board==null || board.length==0)
			return 0;
		int count=0;
		int i;
		for(i=0; i<board[0].length-1; i++){
			if(board[0][i]=='X' && board[0][i+1]=='.')
				count++;
		}
		if(board[0][i]=='X')
			count++;
		
		for( i=1; i<board.length; i++){
			int j;
			for( j=0; j<board[i].length-1; j++){
				if(board[i][j] == 'X'){
					if(board[i][j+1]=='.' &&
							board[i-1][j]=='.')
						count++;
				}
			}
			if(board[i][j] == 'X' && board[i-1][j]=='.')
				count++;				
		}
		return count;
	}
}
