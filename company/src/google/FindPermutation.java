package google;

public class FindPermutation {
	 vector<int> findPermutation(string s) {
	        if(s.empty())
	            return vector<int>();
	        vector<int> res(s.size()+1);
	        s = "I" + s;
	        int i=0;
	        int lasti = 0;
	        while(i<s.size()){
	            if(s[i] == 'I'){
	                while(i+1<s.size() && s[i+1]=='I'){
	                    res[i] = lasti+1;
	                    lasti++;
	                    i++;
	                }
	                int j = i+1;
	                while(j<s.size() && s[j] == 'D')
	                    j++;
	                res[i] = lasti+1+(j-i-1);
	                lasti = res[i];
	                i++;
	            }else if(s[i]=='D'){
	                int j = lasti-1;
	                while(i<s.size() && s[i] == 'D'){
	                    res[i] = j;
	                    i++;
	                    j--;
	                }
	            }
	        }
	        return res;
	    }

}
