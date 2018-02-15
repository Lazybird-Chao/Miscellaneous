package google;

public class ReverseString2 {
	string reverseStr(string s, int k) {
        if(s.empty())
            return "";
        int n = s.size() /(2*k);
        int i=0;
        string res = "";
        int start = 0;
        while(i<n){
            string tmp = s.substr(start, k);
            reverse(tmp.begin(), tmp.end());
            res += tmp;
            start += k;
            res += s.substr(start, k);
            start += k;
            i++;
        }
        string tmp = "";
        if(s.size() - 2*k*n >=k){
            tmp = s.substr(start, k);
            start += k;
        }
        else
            tmp = s.substr(start);
        reverse(tmp.begin(), tmp.end());
        res += tmp;
        if(s.size() - 2*k*n >=k)
            res += s.substr(start);
        return res;
    }

}
