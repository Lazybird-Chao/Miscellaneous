package google;

public class FreedomTrail {
	int findRotateSteps(string ring, string key) {
        if(ring.empty() || key.empty())
            return 0;
        int m = ring.size();
        int n = key.size();
        int f[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                f[i][j] = -1;
        for(int i=0; i<m; i++){
            if(ring[i] == key[0])
                f[i][0] = min(i, m-i)+1;
        }
        for(int j=1; j<n; j++){
            for(int i=0; i<m; i++){
                if(ring[i] != key[j])
                    f[i][j] = -1;
                else{
                    int tmp = INT_MAX;
                    for(int k=0; k<m; k++){
                        if(f[k][j-1]!=-1){
                            int dis = abs(k-i);
                            dis = min(dis, m-dis);
                            tmp = min(tmp, dis+f[k][j-1]);
                        }
                    }
                    f[i][j] = tmp+1;
                }
            }
        }
        int minstep = INT_MAX;
        for(int i=0; i<m; i++){
            if(f[i][n-1] != -1)
                minstep = min(minstep, f[i][n-1]);
        }
        return minstep;
    }

}
