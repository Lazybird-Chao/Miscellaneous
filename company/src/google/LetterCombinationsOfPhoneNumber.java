package google;

public class LetterCombinationsOfPhoneNumber {
	class Solution {
		public:
		    vector<string> letterCombinations(string digits) {
		        if(digits.empty())
		            return vector<string>();
		        string map[10] = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		        if(digits.find('0') != -1)
		            return vector<string>();
		        if(digits.find('1') != -1)
		            return vector<string>();
		        queue<string> q;
		        q.push("");
		        for(int i = 0; i<digits.size(); i++){
		            int idx = digits[i]-'0';
		            int count = q.size();
		            while(count>0){
		                string cur = q.front();
		                q.pop();
		                count--;
		                for(int j = 0; j<map[idx].size(); j++)
		                    q.push(cur+string(1, map[idx][j]));
		            }
		        }
		        vector<string> res;
		        while(!q.empty()){
		            res.push_back(q.front());
		            q.pop();
		        }
		        //sort(res.begin(), res.end(), mysort);
		        return res;
		    }
		    
		    static bool mysort(string a, string b){
		        return a>b;
		    }
		             
		};

}
