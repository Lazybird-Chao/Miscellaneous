package contest;

public class RearrangeString_767 {
	class mycomp{
	    public:
	        bool operator()(const pair<char, int> &a, const pair<char, int> &b){
	            if(a.second != b.second)
	                return a.second < b.second;
	            else
	                return a.first < b.first;
	        }
	    };
	    string reorganizeString(string S) {
	        if(S.empty())
	            return "";
	        int lettermap[26];
	        memset(lettermap, 0, sizeof(int)*26);
	        for(int i=0; i<S.size(); i++){
	            lettermap[S[i]-'a']++;
	        }
	        priority_queue<pair<char, int>, vector<pair<char, int>>, mycomp> q;
	        for(int i=0; i<26; i++){
	            if(lettermap[i] != 0)
	                q.push(make_pair((char)('a'+i), lettermap[i]));
	        }
	        string res = "";
	        pair<char, int> wait((char)0, 0);
	        while(!q.empty()){
	            pair<char, int> tmp = q.top();
	            q.pop();
	            res.push_back(tmp.first);
	            //cout<<tmp.first<<" "<<tmp.second<<endl;
	            tmp.second--;
	            if(wait.second != 0)
	                q.push(wait);
	            wait = tmp;
	        }
	        if(res.size() < S.size())
	            return "";
	        return res;
	    }

}
