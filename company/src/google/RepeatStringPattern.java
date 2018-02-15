package google;

public class RepeatStringPattern {
	bool repeatedSubstringPattern(string s) {
        if(s.empty())
            return true;
        int f[s.size()];
        memset(f, 0, sizeof(int)*s.size());
        for(int i=1; i<s.size(); i++){
            int j = i-1;
            while(j>=0 && s[f[j]] != s[i])
                j = f[j]-1;
            if(j<0)
                f[i] = 0;
            else
                f[i] = f[j]+1;
        }
        return f[s.size()-1]>0 && (s.size() % (s.size()-f[s.size()-1]) ==0);
    }

}
