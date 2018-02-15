package google;

public class GenerallizedAbbreviation {
	vector<string> generateAbbreviations(string word) {
        if(word.empty())
            return vector<string>(1,"");
        unordered_map<string, vector<string>> record;
        return helper(word, record);
    }
    vector<string> helper(string word, unordered_map<string, vector<string>>& record){
        if(word.empty())
            return vector<string>(1,"");
        if(record.find(word) != record.end())
            return record[word];
        vector<string> res;
        string tmp1 = word.substr(0, 1);
        vector<string> suf = helper(word.substr(1, word.size()-1), record);
        for(int i=0; i<suf.size(); i++){
            res.push_back(tmp1 + suf[i]);
            if(suf[i][0]<'1' || suf[i][0]>'9')
                res.push_back("1" + suf[i]);
        }
        
        for(int i=2; i<=word.size(); i++){
            string tmp2 = to_string(i);
            suf = helper(word.substr(i, word.size()-i), record);
            for(int j=0; j<suf.size(); j++){
                if(suf[j][0]<'1' || suf[j][0]>'9')
                    res.push_back(tmp2 + suf[j]);
            }
        }
        record[word] = res;
        return res;
    }

}
