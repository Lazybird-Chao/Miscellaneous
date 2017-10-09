
package facebook;

public class PaintHouse2 {
	public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int houses = costs.length;
        int colors = costs[0].length;
        int[][] f = new int[houses][colors];
        int mincostColor1 = -1;
        int mincostColor2 = -1;
        for(int i = 0; i < colors; i++){
            f[0][i] = costs[0][i];
            if(mincostColor1 < 0 || f[0][i] <= f[0][mincostColor1]){
                mincostColor2 = mincostColor1;
                mincostColor1 = i;
            }
            else if(mincostColor2 < 0 || f[0][i] <= f[0][mincostColor2])
                mincostColor2 = i;
        }
        for(int i = 1; i < houses; i++){
            int tmp1 = -1;
            int tmp2 = -1;
            for(int j = 0; j < colors; j++){
                if(j != mincostColor1){
                    f[i][j] = f[i-1][mincostColor1] + costs[i][j];
                } else
                    f[i][j] = f[i-1][mincostColor2] + costs[i][j];
                if(tmp1<0 || f[i][j] < f[i][tmp1]){
                    tmp2 = tmp1;
                    tmp1 = j;
                }else if(tmp2 < 0 || f[i][j] < f[i][tmp2])
                    tmp2 = j;
            }
            System.out.println(mincostColor1);
            System.out.println(mincostColor2);
            mincostColor1 = tmp1;
            mincostColor2 = tmp2;
        }
        return f[houses-1][mincostColor1];
    }

}
