package google;

public class LongestLineOfOneInMatrix {
	int longestLine(vector<vector<int>>& M) {
        if(M.empty() || M[0].empty())
            return 0;
        int m = M.size();
        int n= M[0].size();
        int dp[n][4];
        int maxlen = 0;
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = M[0][0];
        maxlen = max(maxlen, dp[0][0]);
        for(int i=1; i<n; i++){
            if(M[0][i] == 1){
                dp[i][0] = 1;
                dp[i][1] = 1+dp[i-1][1];
                dp[i][2] = 1;
                dp[i][3] = 1;
                maxlen = max(maxlen, dp[i][1]);
            }else{
                dp[i][0] = dp[i][1] = dp[i][2] = dp[i][3] = 0;
            }
        }
        int pre_2 = 0;
        for(int i = 1; i<m; i++){
            pre_2 = dp[0][2];
            if(M[i][0] == 1){
                dp[0][0] = 1+dp[0][0];
                dp[0][1] = 1;
                dp[0][2] = 1;
                if(n > 1)
                    dp[0][3] = 1 + dp[1][3];
                else
                    dp[0][3] = 1;
                maxlen = max(maxlen, dp[0][0]);
                maxlen = max(maxlen, dp[0][3]);
            }else{
                dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = 0;
            }
            for(int j = 1; j<n; j++){
                int tmp = dp[j][2];
                if(M[i][j]==1){
                    dp[j][0] = 1+dp[j][0];
                    dp[j][1] = 1+dp[j-1][1];
                    dp[j][2] = 1+pre_2;
                    if(n>j+1)
                        dp[j][3] = 1+dp[j+1][3];
                    else
                        dp[j][3] = 1;
                    maxlen = max(maxlen, dp[j][0]);
                    maxlen = max(maxlen, dp[j][1]);
                    maxlen = max(maxlen, dp[j][2]);
                    maxlen = max(maxlen, dp[j][3]);
                    
                }else{
                    dp[j][0] = dp[j][1] = dp[j][2] = dp[j][3] = 0;
                }
                pre_2 = tmp;
            }
        }
        return maxlen;
    }

}
