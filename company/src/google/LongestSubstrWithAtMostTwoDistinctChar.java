package google;

public class LongestSubstrWithAtMostTwoDistinctChar {
	int lengthOfLongestSubstringTwoDistinct(string s) {
        if(s.empty())
            return 0;
        int start = 0;
        int end = 0;
        int count = 0;
        int lettermap[256];
        fill(lettermap, lettermap+256, 0);
        int maxlen = 0;
        while(end < s.size()){
            if(count<=2){
                if(lettermap[s[end]]==0)
                    count++;
                lettermap[s[end]]++;
                end++;
            }else{
                if(lettermap[s[start]]==1)
                    count--;
                lettermap[s[start]]--;
                start++;
            }
            if(count<=2)
                maxlen = max(maxlen, end-start);
        }
        return maxlen;
    }

}
