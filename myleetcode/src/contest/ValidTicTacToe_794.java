package contest;

public class ValidTicTacToe_794 {
	bool validTicTacToe(vector<string>& board) {
        if(board.empty())
            return false;
        vector<int> row_count1(3, 0);
        vector<int> row_count2(3, 0);
        vector<int> col_count1(3, 0);
        vector<int> col_count2(3, 0);
        vector<int> diag_count1(2, 0);
        vector<int> diag_count2(2, 0);
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board[0].size(); j++){
                if(board[i][j]=='X'){
                    row_count1[i]++;
                    col_count1[j]++;
                    if(i==j)
                        diag_count1[0]++;
                    if(i+j==2)
                        diag_count1[1]++;
                }else if(board[i][j] == 'O'){
                    row_count2[i]++;
                    col_count2[j]++;
                    if(i==j)
                        diag_count2[0]++;
                    if(i+j==2)
                        diag_count2[1]++;
                }
            }
        }
        int tmp3 = row_count1[0]+row_count1[1]+row_count1[2];
        int tmp4 = row_count2[0]+row_count2[1]+row_count2[2];
        if(tmp3 < tmp4 || tmp3-tmp4>1)
            return false;
        int tmp1 = 0;
        int tmp2 = 0;
        for(int i=0; i<3; i++){
            if(row_count1[i]==3)
                tmp1++;
            if(row_count2[i]==3)
                tmp2++;
            if(col_count1[i]==3)
                tmp1++;
            if(col_count2[i]==3)
                tmp2++;
            if(i<2){
                if(diag_count1[i]==3)
                    tmp1++;
                if(diag_count2[i]==3)
                    tmp2++;
            }
        }
        //cout<<tmp1<<" "<<diag_count2[1]<<endl;
        if(tmp3==tmp4 && tmp1==0 && tmp2>0)
            return true;
        if(tmp3==tmp4 && tmp1==0 && tmp2==0)
            return true;
        if(tmp3>tmp4 && tmp1==0 && tmp2==0)
            return true;
        if(tmp3>tmp4 && tmp1>0 && tmp2==0)
            return true;
        return false;
    }

}
