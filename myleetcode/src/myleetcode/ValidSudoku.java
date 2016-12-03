package myleetcode;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board){
		int[][] hashdigit= new int[9*3][9];
        for(int i=0; i<27; i++)
            for(int j=0; j<9; j++)
                hashdigit[i][j]=0;
		for(int i=0; i< 9; i++){
			for(int j=0; j<9; j++){
				char c = board[i][j];
				if(c!='.'){
					if(hashdigit[i][c-'1'] > 0)
						return false;
					hashdigit[i][c-'1']++;
					if(hashdigit[j+9][c-'1']>0)
						return false;
					hashdigit[j+9][c-'1']++;
					if(hashdigit[(i/3)*3 + j/3+18][c-'1']>0)
						return false;
					hashdigit[(i/3)*3 + j/3+18][c-'1']++;
				}
			}
		}
		return true;
	}
}
