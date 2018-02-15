package google;

public class RearrangeStringKapart {
	 class mycomp{
		    public:
		        bool operator()(const pair<char, int>& a, const pair<char, int>& b){
		            return a.second < b.second;
		        }
		        
		    };
		public:
		    string rearrangeString(string s, int k) {
		        if(s.empty())
		            return "";
		        if(k<2)
		            return s;
		        unordered_map<char, int> m;
		        for(int i=0; i<s.size(); i++){
		            if(m.find(s[i]) == m.end())
		                m[s[i]] = 1;
		            else
		                m[s[i]] += 1;
		        }
		        priority_queue<pair<char, int>, vector<pair<char, int>>, mycomp> q1;
		        vector<pair<char, int>> q2(k);
		        for(auto &it : m){
		            q1.push(it);
		        }
		        string res;
		        int i=0;
		        int j=0;
		        int head = 0;
		        int tail = 0;
		        while(i<s.size()){
		            if(j>=k){
		                if(q2[head].second > 0)
		                    q1.push(q2[head]);
		                head = (head+1)%k;
		            }
		            if(q1.empty()){
		                res.push_back(' ');
		                q2[tail] = make_pair(0, 0);
		            }else{
		                pair<char, int> cur = q1.top();
		                q1.pop();
		                res.push_back(cur.first);
		                cur.second--;
		                i++;
		                q2[tail] = cur;
		            }
		            tail = (tail+1)%k;
		            j++;
		        }
		        //cout<<res<<endl;
		        if(res.find(' ') != -1)
		            return "";
		        else
		            return res;
		    }

}
