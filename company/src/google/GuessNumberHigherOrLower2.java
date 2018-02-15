package google;

public class GuessNumberHigherOrLower2 {
	int getMoneyAmount(int n) {
        int f[n+2][n+2];
        for(int i=0; i<=n+1; i++)
            for(int j=0; j<=n+1; j++)
                f[i][j] = 0;
        for(int j = 2; j<=n; j++){
            for(int i=j-1; i>=1; i--){
                int min_i_j = INT_MAX;
                for(int k=i; k<=j; k++){
                    int lower = f[i][k-1] + k;
                    int higher = f[k+1][j] + k;
                    min_i_j = min(min_i_j, max(lower, higher));
                }
                f[i][j] = min_i_j;
            }
        }
        return f[1][n];
    }

}
