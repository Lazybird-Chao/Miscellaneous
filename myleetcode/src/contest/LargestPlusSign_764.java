package contest;

public class LargestPlusSign_764 {
	int orderOfLargestPlusSign(int N, vector<vector<int>>& mines) {
        if(N<1)
            return 0;
        if(mines.empty())
            return N/2;
        int m[N][N];
        int f[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                m[i][j] = 1;
                f[i][j] = 1;
            }
        }
        for(int i=0; i<mines.size(); i++){
            m[mines[i][0]][mines[i][1]] = 0;
            f[mines[i][0]][mines[i][1]] = 0;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(f[i][j]==0)
                    continue;
                if(i>0)
                    f[i][j] = 1+f[i-1][j];
                if(j>0)
                    m[i][j] = 1+m[i][j-1];
            }
        }
        int maxorder = 0;
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){
                if(f[i][j]==0)
                    continue;
                int right;
                int down;
                if(j==N-1)
                    right = 1;
                else
                    right = 1+m[i][j+1];
                if(i==N-1)
                    down = 1;
                else
                    down = 1+f[i+1][j];
                int cur = min(right, down);
                cur = min(cur, f[i][j]);
                cur = min(cur, m[i][j]);
                maxorder = max(maxorder, cur);
                f[i][j] = down;
                m[i][j] = right;
            }
        }
        return maxorder;
    }

}
