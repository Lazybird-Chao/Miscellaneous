package google;

public class GroupShiftedString {
	vector<vector<string>> groupStrings(vector<string>& strings) {
        if(strings.empty())
            return vector<vector<string>>();
        unordered_map<string, vector<string>> smap;
        for(int i=0; i<strings.size(); i++){
            string s = moveToFirst(strings[i]);
            if(smap.find(s) == smap.end())
                smap[s] = vector<string>();
            smap[s].push_back(strings[i]);
        }
        vector<vector<string>> res;
        for(auto &it : smap){
            res.push_back(it.second);
        }
        return res;
    }
    string moveToFirst(string s){
        int diff = s[0] - 'a';
        for(int i=0; i<s.size(); i++)
            s[i] = (s[i]-'a' + 26 - diff)%26 + 'a';
        return s;
    }

}
