package contest;

public class PartitionLabels_763 {
	 vector<int> partitionLabels(string S) {
	        if(S.empty())
	            return vector<int>();
	        int starts[26];
	        int ends[26];
	        for(int i=0; i<26; i++){
	            starts[i] = -1;
	            ends[i] = -1;
	        }
	        for(int i=0; i<S.size(); i++){
	            if(starts[S[i]-'a'] == -1)
	                starts[S[i]-'a'] = i;
	            ends[S[i]-'a'] = i;
	        }
	        vector<int> s;
	        vector<int> e;
	        for(int i=0; i<26; i++){
	            if(starts[i] != -1)
	                s.push_back(starts[i]);
	            if(ends[i] != -1)
	                e.push_back(ends[i]);
	        }
	        sort(s.begin(), s.end());
	        sort(e.begin(), e.end());
	        vector<int> res;
	        int i=0, j=0;
	        int count = 0;
	        int ps = s[0];
	        while(i<s.size() ){
	            if(s[i] <= e[j]){
	                count++;
	                i++;
	            }else{
	                j++;
	                count--;
	                if(count==0){
	                    res.push_back(e[j-1]-ps+1);
	                    ps = s[i];
	                }
	            }
	        }
	        res.push_back(e.back()-ps+1);
	        return res;
	    }

}
