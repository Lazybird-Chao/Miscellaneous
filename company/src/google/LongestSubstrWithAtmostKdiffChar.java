package google;

public class LongestSubstrWithAtmostKdiffChar {
	int lengthOfLongestSubstringKDistinct(string s, int k) {
        if(s.empty() || k<=0)
            return 0;
        int m[256];
        fill(m, m+256, 0);
        int count = 0;
        int start = 0;
        int end = -1;
        int maxlen = 0;
        while(end < (int)s.size()){
            if(count <= k){
                maxlen = max(maxlen, end-start+1);
                end++;
                if(m[s[end]]==0)
                    count++;
                m[s[end]]++;
            }else if(count > k){
                if(m[s[start]]==1)
                    count--;
                m[s[start]]--;
                start++;
            }
            //cout<<count<<endl;
        }
        return maxlen;
    }

}
