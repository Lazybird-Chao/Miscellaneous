package contest;

public class CherryPickup_741 {
	/*
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0)
            return 0;
        int[][] f = new int[grid.length][grid[0].length];
        int[][] direct = new int[grid.length][grid[0].length];
        int w  = grid[0].length;
        int h = grid.length;
        if(grid[0][0] == 1)
            f[0][0] = 1;
        else if(grid[0][0] == 0)
            f[0][0] = 0;
        else
            return 0;
        direct[0][0] = 0;
        
        for(int i =0; i<h; i++){
            for(int j=0; j<w; j++){
                if(i==0 && j==0)
                    continue;
                if(grid[i][j] == -1){
                    f[i][j] = -1;
                    continue;
                }
                f[i][j] = -1;
                if(i>0){
                    f[i][j] = f[i-1][j];
                    direct[i][j] = 1; 
                }
                if(j>0 && f[i][j-1] > f[i][j]){
                        f[i][j] = f[i][j-1];
                        direct[i][j] = -1;
                }
                if(f[i][j] != -1)
                    f[i][j] += grid[i][j];
            }
        }
        int maxCherry = f[h-1][w-1];
        //System.out.println(maxCherry);
        if(maxCherry == -1)
            return 0;
        for(int i = h-1, j=w-1; direct[i][j] != 0; ){
            grid[i][j] = 0;
            if(direct[i][j] == 1)
                i--;
            else
                j--;
        }
        grid[0][0] = 0;
        
        f[h-1][w-1] = grid[h-1][w-1];
        for(int i =h-1; i>=0; i--){
            for(int j=w-1; j>=0; j--){
                if(i==h-1 && j == w-1)
                    continue;
                if(grid[i][j] == -1){
                    f[i][j] = -1;
                    continue;
                }
                f[i][j] = -1;
                if(i<h-1){
                    f[i][j] = f[i+1][j];
                }
                if(j<w-1 && f[i][j+1] > f[i][j]){
                        f[i][j] = f[i][j+1];
                }
                if(f[i][j] != -1)
                    f[i][j] += grid[i][j];
            }
        }
        maxCherry += f[0][0];
        return maxCherry;
        
    }
    */
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0)
            return 0;
        int n  = grid[0].length;
        int[][][] cherry = new int[2*n-1][n][n];
        /*
        * need do initiallization for all elements, otherwise may cause error, as default '0' also has meanings
        */
        for(int i = 0; i<2*n-1; i++)
            for(int j = 0; j<n; j++)
                Arrays.fill(cherry[i][j], -1);
        cherry[0][0][0] = grid[0][0];
        for(int i = 1; i<2*n-1; i++){
            for(int j  = 0; j<n && j<=i; j++){
                if(i-j >= n)
                    continue;
                for(int k = 0; k<n && k<=i; k++){
                    if(i-k>=n)
                        continue;
                    if(grid[j][i-j] == -1 || grid[k][i-k] == -1){
                       cherry[i][j][k] = -1;
                       continue;
                    }
                    int c = cherry[i-1][j][k];
                    if(j>0)
                        c = Math.max(c, cherry[i-1][j-1][k]);
                    if(k>0)
                        c = Math.max(c, cherry[i-1][j][k-1]);
                    if(j>0 && k>0)
                        c = Math.max(c, cherry[i-1][j-1][k-1]);
                    if(c != -1){
                        if(j==k)
                            cherry[i][j][k] = c + grid[j][i-j] ;
                        else
                            cherry[i][j][k] = c + grid[j][i-j] + grid[k][i-k];
                    }else
                        cherry[i][j][k] = -1;
                    /*
                    if(i>7){
                        System.out.print(i);System.out.print(" ");
                        System.out.print(j);System.out.print(" ");
                        System.out.print(k);System.out.print(":");
                        System.out.print(cherry[i][j][k]);System.out.println(" ");
                    }
                    */
        
                }
            }
        }
        //System.out.println(cherry[2*n-2][n-1][n-1]);
        if(cherry[2*n-2][n-1][n-1] == -1)
            return 0;
        else
            return cherry[2*n-2][n-1][n-1];
    }

}
