package google;

public class AlienDictionary {
	 string alienOrder(vector<string>& words) {
	        if(words.empty())
	            return "";
	        vector<vector<int>> neighbors(26, vector<int>(26, 0));
	        vector<int> indegree(26, 0);
	        vector<int> letter(26, 0);
	        for(int i=0; i<words.size()-1; i++){
	            int j= 0;
	            while(j<words[i].size() && j<words[i+1].size()){
	                letter[words[i][j]-'a'] = 1;
	                if(words[i][j] != words[i+1][j])
	                    break;
	                j++;
	            }
	            if(j<words[i].size() && j<words[i+1].size()){
	                char from = words[i][j];
	                char to = words[i+1][j];
	                if(neighbors[from-'a'][to-'a'] == 0){
	                    indegree[to-'a']++;
	                    neighbors[from-'a'][to-'a'] = 1;
	                }
	            }
	            while(j<words[i].size()){
	                letter[words[i][j]-'a'] = 1;
	                j++;
	            }
	        }
	        for(int j=0; j<words.back().size(); j++)
	            letter[words.back().at(j)-'a']= 1;
	        deque<int> q;
	        for(int i=0; i<26; i++){
	            if(letter[i]==1 && indegree[i] ==0){
	                //cout<<i<<endl;
	                q.push_back(i);
	            }
	        }
	        string res;
	        //cout<<q.size()<<endl;
	        while(!q.empty()){
	            int cur = q.front();
	            //cout<<cur<<endl;
	            res.push_back((char)(cur+'a'));
	            q.pop_front();
	            for(int i=0; i<26; i++){
	                if(neighbors[cur][i]==1){
	                    indegree[i]--;
	                    if(indegree[i]==0)
	                        q.push_back(i);
	                }
	            }
	        }
	        int count = 0;
	        for(int i=0; i<26; i++){
	            if(letter[i]==1)
	                count++;
	        }
	        if(count == res.size())
	            return res;
	        else
	            return "";
	        
	    }

}
