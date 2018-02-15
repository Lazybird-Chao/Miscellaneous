package google;

public class ZerosAndOnes {
	/*
    int findMaxForm(vector<string>& strs, int m, int n) {
        if(strs.empty())
            return 0;
        int p = strs.size();
        int count0[p];
        int count1[p];
        for(int i=0; i<p; i++){
            int c = 0;
            int j = 0;
            while(j<strs[i].size()){
                if(strs[i][j]=='0')
                    c++;
                j++;
            }
            count0[i] = c;
            count1[i] = strs[i].size()-c;
        }
        int f[p+1][m+1][n+1];
        memset(f, 0, sizeof(int)*(p+1)*(m+1)*(n+1));
        for(int k=1; k<=p; k++){
            for(int i=m; i>=0; i--){
                for(int j=n; j>=0; j--){
                    if(i>=count0[k-1] && j>=count1[k-1])
                        f[k][i][j] = max(f[k-1][i][j], f[k-1][i-count0[k-1]][j-count1[k-1]]+1);
                    else
                        f[k][i][j] = f[k-1][i][j];
                    //cout<<k<<" "<<i<<" "<<j<<":"<<f[k][i][j]<<endl;
                }
            }
        }
        return f[p][m][n];
    }
    */
    int findMaxForm(vector<string>& strs, int m, int n){
        if(strs.empty())
            return 0;
        int p = strs.size();
        int count0[p+1];
        int count1[p+1];
        count0[0] = count1[0] = 0;
        int total0 = 0;
        int total1 = 0;
        for(int i=1; i<=p; i++){
            int c = 0;
            int j = 0;
            while(j<strs[i-1].size()){
                if(strs[i-1][j]=='0')
                    c++;
                j++;
            }
            count0[i] = c;
            count1[i] = strs[i-1].size()-c;
            total0 += count0[i];
            total1 += count1[i];
        }
        int f[m+1][n+1];
        memset(f, 0, sizeof(int)*(m+1)*(n+1));
        for(int k=1; k<=p; k++){
            total0 = total0-count0[k-1];
            total1 = total1-count1[k-1];
            int bound0 = max(count0[k], m-total0);
            int bound1 = max(count1[k], n-total1);
            for(int i=m; i>=bound0; i--){
                for(int j=n; j>=bound1; j--){
                    //cout<<j<<" "<<bound1<<endl;
                    f[i][j] = max(f[i][j], f[i-count0[k]][j-count1[k]]+1);
                }
            }
        }
        return f[m][n];
    }

}
