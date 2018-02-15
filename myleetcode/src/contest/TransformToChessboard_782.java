package contest;

public class TransformToChessboard_782 {
	int movesToChessboard(vector<vector<int>>& board) {
        if(board.empty() || board[0].empty())
            return 0;
        int n = board.size();
        int type1 = 0;
        int type2 = 0;
        for(int i=1; i<n; i+=2)
            type1 += 1<<i;
        for(int i=0; i<n; i+=2)
            type2 += 1<<i;
        unordered_map<int, int> row_as_num;
        for(int i=0; i<n; i++){
            int tmp = 0;
            for(int j=0; j<n; j++){
                if(board[i][j]==1)
                    tmp += 1<<j;
            }
            if(row_as_num.find(tmp) == row_as_num.end())
                row_as_num[tmp] = 1;
            else
                row_as_num[tmp] += 1;
        }
        int minswap1 = check(row_as_num, n, type1, type2);
        if(minswap1 == -1)
            return -1;
        
        unordered_map<int, int> col_as_num;
        for(int i=0; i<n; i++){
            int tmp = 0;
            for(int j=0;j<n; j++){
                if(board[j][i] == 1)
                    tmp += 1<<j;
            }
            if(col_as_num.find(tmp) == col_as_num.end())
                col_as_num[tmp] = 1;
            else
                col_as_num[tmp] += 1;
        }
        int minswap2 = check(col_as_num, n, type1, type2);
        if(minswap2 == -1)
            return -1;
        return minswap1 + minswap2;
        
    }
    int check(unordered_map<int, int> &m, int n, int type1, int type2){
        if(m.size() != 2)
            return -1;
        int n1, n2, c1, c2;
        n1 = m.begin()->first;
        c1 = m.begin()->second;
        int one1 = getOneCount(n1);
        n2 = (++m.begin())->first;
        int one2 = getOneCount(n2);
        c2 = (++m.begin())->second;
        //cout<<n1<<" "<<n2<<endl;
        if(one1 < one2){
            int tmp = n2;
            n2 = n1;
            n1 = tmp;
            tmp = c2;
            c2 = c1;
            c1 = tmp;
        }
        if( (n1 & n2) != 0 || abs(c1-c2) >1)
            return -1;
        int minswap = getSwap(n1, type2);
        if(n % 2 ==0)
            minswap = min(minswap, getSwap(n1, type1));
        return minswap;
        
    }
    int getOneCount(int x){
        int c= 0;
        while(x != 0){
            c += x & 1;
            x >>= 1;
        }
        return c;
    }
    int getSwap(int s, int e){
        int x = s ^ e;
        int c = 0;
        while(x != 0){
            c += x & 1;
            x >>= 1;
        }
        return  c/2;
    }

}
