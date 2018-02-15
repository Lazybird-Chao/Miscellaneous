package google;

public class ShortestParlindrome {
	 /*
    string shortestPalindrome(string s) {
        if(s.empty())
            return s;
        int i = s.size()-1;
        while(i>=0){
            if(s[0] == s[i]){
                if(isPalindrome(s.substr(0, i+1)))
                    break;
            }
            i--;
        }
        string suf = s.substr(i+1);
        reverse(suf.begin(), suf.end());
        return suf+s;
    }
    
    bool isPalindrome(string s){
        int i = 0, j = s.size() -1;
        while(i<j){
            if(s[i] != s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    */
    string shortestPalindrome(string s){
        if(s.empty())
            return s;
        int f[s.size()];
        memset(f, 0, s.size()*sizeof(char));
        f[0] = 0;
        for(int i=1; i<s.size(); i++){
            int j = i-1;
            while(j>=0 && s[i] != s[f[j]])
                j = f[j]-1;
            if(j<0){
                f[i] = 0;
            }else{
                f[i] = f[j]+1;
            }
        }
        cout<<s.size()<<endl;
        int i1 = 0;
        int i2 = s.size()-1;
        while(i1 < i2){
            if(s[i1] == s[i2]){
                i1++;
                i2--;
                continue;
            }
            if(i1==0)
                i2--;
            else
                i1 = f[i1-1]; 
        }
        int len = 0;
        if(i1==i2)
            len = i1*2 + 1;
        else
            len = i1*2;
        string suf = s.substr(len);
        reverse(suf.begin(), suf.end());
        return suf + s;
    }

}
