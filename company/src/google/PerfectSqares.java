package google;

public class PerfectSqares {
	 /*
    public int numSquares(int n) {
        if(n < 1)
            return 0;
        int[] f = new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        for(int i = 1; i*i <= n; i++)
            f[i*i] = 1;
        for(int i = 1; i<n; i++){
            for(int j = i+1; j<= n; j++)
                f[j] = Math.min(f[j], f[i] + f[j-i]);
        }
        return f[n];
    }
    */
    public int numSquares(int n) {
        if(n < 1)
            return 0;
        int[] f = new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for(int i = 1; i*i <= n; i++){
            int v = i*i;
            for(int j = v; j <= n; j++){
                f[j] = Math.min(f[j], f[j-v] + 1);
            }
        }
        return f[n];
    }

}
