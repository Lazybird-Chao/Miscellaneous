package google;

public class WordBrak2 {
	class Solution {
		public:
		    vector<string> wordBreak(string s, vector<string>& wordDict) {
		        if(s.empty() || wordDict.empty())
		            return vector<string>();
		        bool hasWord[1000][1000];
		        for(int i =0; i<s.size(); i++)
		            for(int j=0; j<s.size(); j++)
		                hasWord[i][j] = false;
		        for(int i = 0; i<wordDict.size(); i++){
		            string w = wordDict[i];
		            int pos = 0;
		            while(pos != -1){
		                pos = s.find(w, pos);
		                if(pos != -1){
		                    hasWord[pos][pos+w.size()-1] = true;
		                    pos++;
		                }
		            }
		        }
		        unordered_map<int, vector<string>> record;
		        vector<string> res = helper(s, 0, record, hasWord);
		        return res; 
		        
		    }
		    vector<string> helper(string s, int start, unordered_map<int, vector<string>> &record, bool hasWord[1000][1000]){
		        if(start == s.size()){
		            vector<string> res;
		            return res;
		        }
		        if(record.find(start) != record.end())
		            return record[start];
		        vector<string> res;
		        for(int j = start; j<s.size(); j++){
		            if(hasWord[start][j]){
		                string cur = s.substr(start, j-start+1);
		                vector<string> subres = helper(s, j+1, record, hasWord);
		                if(!subres.empty()){
		                    for(int i = 0; i<subres.size(); i++)
		                        res.push_back(cur+" "+subres[i]);
		                }
		            }
		        }
		        if(hasWord[start][s.size()-1])
		            res.push_back(s.substr(start));
		        record.insert(make_pair(start, res));
		        return res;
		    }
		};

}
