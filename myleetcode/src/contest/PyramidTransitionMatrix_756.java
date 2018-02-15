package contest;

public class PyramidTransitionMatrix_756 {
	bool pyramidTransition(string bottom, vector<string>& allowed) {
        int trans[26][26][26];
        memset(trans, 0, 26*26*26*sizeof(int));
        for(int i=0; i<allowed.size(); i++){
            string s = allowed[i];
            trans[s[0]-'A'][s[1]-'A'][s[2]-'A'] = 1;
        }
        int n = bottom.size();
        int f[n][n][26];
        memset(f, 0, n*n*26*sizeof(int));
        for(int j=0; j<n; j++)
            f[n-1][j][bottom[j]-'A'] = 1;
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                for(int k1=0; k1<26; k1++){
                    if(f[i+1][j][k1]==1){
                        for(int k2=0; k2<26; k2++){
                            if(f[i+1][j+1][k2]==1){
                                for(int k3=0; k3<26; k3++){
                                    if(trans[k1][k2][k3]==1)
                                       f[i][j][k3] = 1; 
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<26; i++)
            if(f[0][0][i]==1)
                return true;
        return false;
    }

}
