package google;

public class RemoveDuplicateLetters {
	string removeDuplicateLetters(string s) {
        if(s.empty())
            return "";
        int count[26];
        memset(count, 0, sizeof(int)*26);
        for(int i=0; i<s.size(); i++)
            count[s[i]-'a']++;
        vector<char> res;
        int choosed[26];
        vector<char> minc;
        int i=0, j = 0;
        while(i < s.size()){
            char c = s[i];
            if(count[c-'a']==0){
                i++;
                continue;
            }
            if(count[c-'a']>1){
                count[c-'a']--;
                i++;
                continue;
            }
            minc.clear();
            memset(choosed, 0, sizeof(int)*26);
            int posi = 0;
            //cout<<j<<" "<<i<<endl;
            //choosed[s[i]-'a'] = 1;
            for(int k=j; k<=i; k++){
                if((s[k] <= s[i] && count[s[k]-'a']>0 && choosed[s[k]-'a']== 0)){
                    while(!minc.empty() && minc.back() > s[k]){
                        choosed[minc.back()-'a'] = 0;
                        minc.pop_back();
                    }
                    minc.push_back(s[k]);
                    choosed[s[k]-'a'] = 1;
                    if(s[k] == s[i])
                        posi = k;
                    //cout<<s[k]<<" ";
                }
            }
            cout<<endl;
            for(int k=0; k<minc.size(); k++){
                res.push_back(minc[k]);
                //cout<<minc[k]<<" ";
                count[minc[k]-'a'] = 0;
            }
            //cout<<endl;
            j = posi+1;
            i++;
        }
        return string(res.begin(), res.end());
    }

}
