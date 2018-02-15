package google;

public class MaximumVacationDays {
	public int maxVacationDays(int[][] flights, int[][] days) {
        if(flights == null || days == null)
            return 0;
        int n = days.length;
        int k = days[0].length;
        if(n==0 || k ==0)
            return 0;
        int[] f = new int[n];
        int[] f_tmp = new int[n];
        for(int i=0; i<n; i++)
            f[i] = days[i][k-1];
        for(int j = k-2; j>=0; j--){
            for(int i=0; i<n; i++){
                int cur_max = f[i];
                for(int p = 0; p<n; p++){
                    if(flights[i][p]==1)
                        cur_max = Math.max(cur_max, f[p]);
                }
                f_tmp[i] = cur_max + days[i][j];
            }
            System.arraycopy(f_tmp, 0, f, 0, n);
        }
        int res = f[0];
        for(int i=0; i<n; i++){
            if(flights[0][i]==1)
                res = Math.max(res, f[i]);
        }
        return res;
    }
	
	int maxVacationDays(vector<vector<int>>& flights, vector<vector<int>>& days) {
        int n = flights.size();
        int k = days[0].size();
        if(n==0 || k==0)
            return 0;
        vector<vector<int>> memo(n, vector<int>(k, -1));
        helper(flights, days, memo, 0, 0);
        return memo[0][0];
    }
    
    int helper(vector<vector<int>>& flights, vector<vector<int>>& days, vector<vector<int>>& memo, 
               int pre_city_idx, int week_idx){
        int n = days.size();
        int k = days[0].size();
        if(memo[pre_city_idx][week_idx] != -1)
            return memo[pre_city_idx][week_idx];
        if(week_idx==k-1){
            int max_v = days[pre_city_idx][week_idx];
            for(int i=0; i<n; i++){
                if(flights[pre_city_idx][i]==1)
                    max_v = max(max_v, days[i][week_idx]);
            }
            memo[pre_city_idx][week_idx] = max_v;
            return max_v;
        }else{
            int max_v = days[pre_city_idx][week_idx] + helper(flights, days, memo, pre_city_idx, week_idx+1);
            for(int i=0; i<n; i++){
                if(flights[pre_city_idx][i]==1)
                    max_v = max(max_v, days[i][week_idx] + helper(flights, days, memo, i, week_idx+1));
            }
            memo[pre_city_idx][week_idx] = max_v;
            return max_v;
        }
    }

}
