package contest;

public class ChampaneTower_799 {
	double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0 || query_glass > query_row)
            return 0.0;
        vector<vector<double>> holds(100, vector<double>(100, 0.0));
        int r = 0;
        holds[0][0] = poured;
        int flag = 0;
        while(r < query_row){
            flag = 0;
            for(int i=0; i<=r; i++){
                if(holds[r][i] > 1){
                    flag = 1;
                    holds[r+1][i] += (holds[r][i]-1)/2;
                    holds[r+1][i+1] += (holds[r][i]-1)/2;
                    holds[r][i] = 1;
                }
            }
            if(flag == 0)
                break;
            r++;
        }
        return holds[query_row][query_glass] >=1? 1 : holds[query_row][query_glass];
    }

}
