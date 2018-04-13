package contest;

public class DominoAndTrominoTiling_790 {
	int numTilings(int N) {
        if(N < 1)
            return 0;
        else if(N<2)
            return 1;
        else if(N<3)
            return 2;
        long f[N+1];    //valid ending for length i
        long g[N+1];    //invalid ending for length i (with one more corner)
        f[0] = 1;
        g[0] = 0;
        f[1] = 1;
        g[1] = 2;
        f[2] = 2;
        g[2] = 2*f[1] + g[1];
        for(int i=3; i<=N; i++){
            f[i] = f[i-1] + f[i-2] + g[i-2];
            g[i] = 2*f[i-1] + g[i-1];
            f[i] %= 1000000007;
            g[i] %= 1000000007;
        }
        return f[N] % 1000000007;
    }

}
