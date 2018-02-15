package google;

public class EncodeDecodeString {
	 // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        if(strs.empty())
            return "";
        string res = "";
        for(int i=0; i<strs.size(); i++){
            res += to_string(strs[i].size());
            res += "#";
            res += strs[i];
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        vector<string> res;
        int i=0;
        while(i<s.size()){
            int j=i;
            while(j<s.size() && s[j]!='#')
                j++;
            long count = stol(s.substr(i, j-i)); 
            i = j+1;
            res.push_back(s.substr(i, count));
            i += count;
        }
        return res;
    }

}
