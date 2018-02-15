package google;

public class FindLonlyPixel2 {
	 int findBlackPixel(vector<vector<char>>& picture, int N) {
	        if(picture.empty() || picture[0].empty())
	            return 0;
	        vector<int> blackInCol(picture[0].size(), 0);
	        unordered_map<string, int> row_count;
	        for(int i=0; i<picture.size(); i++){
	            string s = "";
	            int tmp = 0;
	            for(int j=0; j<picture[0].size(); j++){
	                s.push_back(picture[i][j]);
	                if(picture[i][j]=='B'){
	                    blackInCol[j]++;
	                    tmp++;
	                }  
	            }
	            if(tmp!= N)
	                continue;
	            if(row_count.find(s) == row_count.end())
	                row_count[s] = 1;
	            else
	                row_count[s] = row_count[s]+1;
	        }
	        int res = 0;
	        for(auto &it : row_count){
	            if(it.second == N){
	                string s = it.first;
	                for(int i=0; i<s.size(); i++){
	                    if(s[i] == 'B' && blackInCol[i] == N)
	                        res += N;
	                }
	            }
	        }
	        return res;
	    }

}
