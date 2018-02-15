package google;

public class FourKeyBoard {
	int maxA(int N) {
        if(N==0)
            return 0;
        vector<int> dp(N+1);
        for(int i=1; i<=N; i++)
            dp[i] = i;
        for(int i=7; i<=N; i++){
            dp[i] = dp[i-1]+1;
            for(int j=3; j<i; j++){
                dp[i] = max(dp[i], dp[i-j]*(j-1));
            }
        }
        return dp[N];
    }

}
