package google;

public class AndroidUnlockPattern {
	int numberOfPatterns(int m, int n) {
        if(n==0)
            return 0;
        vector<vector<int>> neighbors = {{},
                                         {2,4,5,6,8},
                                         {1,4,7,5,6,9,3},
                                         {2,4,5,6,8},
                                         {1,2,5,8,7,9,3},
                                         {1,2,3,4,6,7,8,9},
                                         {3,2,5,8,9,1,7},
                                         {4,5,8,2,6},
                                         {7,4,5,6,9,1,3},
                                         {8,5,6,2,4}};
        int count = 0;
        int accessed[10] = {0,0,0,0,0,0,0,0,0,0};
        
        for(int i=1; i<=9; i++){
            accessed[i] = 1;
            dfs(neighbors, i, num[i], accessed, 1, count, m, n);
            accessed[i] = 0;
        }
        return count;
        
    }
    unordered_map<int, vector<int>> memo;
    int num[10]= {1, 2, 3, 5, 7, 11, 13, 17, 19, 23};
    void dfs(vector<vector<int>> &neighbors, int start, int key, int accessed[10], int len, int &count, int m, int n){
        if(len > n)
            return;
        int prec = count;
        if(memo.find(key) != memo.end()){
            if(memo[key][start] != -1){
                count += memo[key][start];
                return;
            }
        }
        if(len >= m )
            count++;
        for(int i=0; i<neighbors[start].size(); i++){
            if(accessed[neighbors[start][i]] == 0){
                accessed[neighbors[start][i]] = 1;
                dfs(neighbors, neighbors[start][i], key*num[start], accessed, len+1, count, m, n);
                accessed[neighbors[start][i]] = 0;
            }
            else{
                int s1 = neighbors[start][i];
                for(int j=0; j<neighbors[s1].size(); j++){
                    int s2 = neighbors[s1][j];
                    if(accessed[s2]==0 && abs(s1-start) == abs(s2-s1)){
                        if(s1 == 3 || s1 == 7)
                            continue;
                        if((s1==4 || s1==6) && abs(s1-start) == 1)
                            continue;
                        accessed[s2] = 1;
                        dfs(neighbors, s2, key*num[start],accessed, len+1, count, m, n);
                        accessed[s2] = 0;
                    }
                }
            }
        }
        if(memo.find(key) == memo.end())
            memo[key] = vector<int>(10, -1);
        memo[key][start] = count-prec;
        
        return;
    }

}
