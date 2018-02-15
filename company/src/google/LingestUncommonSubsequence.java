package google;

public class LingestUncommonSubsequence {
	class mycomp{
        public:
        bool operator()(const string &a, const string &b) const{
        if(a.size() != b.size())
            return a.size() > b.size();
        else
            return a > b;
        }
    };
    
    bool isSubseq(const string& s, const string& t){
        if(s.size() > t.size())
            return false;
        if(s.size() == t.size())
            return s==t;
        int i=0, j=0;
        while(i<s.size() && j<t.size()){
            if(t[j] == s[i]){
                i++;
                j++;
            }else
                j++;
        }
        return i==s.size();
    }
    int findLUSlength(vector<string>& strs) {
        if(strs.empty())
            return 0;
        map<string, int, mycomp> m;
        for(string &s : strs){
            if(m.find(s) == m.end())
                m[s] = 1;
            else
                m[s]++;
        }
        if(m.begin()->second == 1)
            return m.begin()->first.size();
        //cout<<m.size()<<endl;
        vector<string> tocheck;
        for(auto &s : m){
            //cout<<s.first<<endl;
            if(s.second > 1)
                tocheck.push_back(s.first);
            else{
                int i=0;
                while(i<tocheck.size()){
                    if(isSubseq(s.first, tocheck[i]))
                        break;
                    i++;
                }
                if(i==tocheck.size())
                    return s.first.size();
                else
                    tocheck.push_back(s.first);
            }
        }
        return -1;
    }

}
