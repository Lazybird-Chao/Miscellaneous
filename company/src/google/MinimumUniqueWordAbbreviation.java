package google;

public class MinimumUniqueWordAbbreviation {
	vector<int> minabbre;
    string minAbbreviation(string target, vector<string>& dictionary) {
        if(target.empty())
            return "";
        if(dictionary.empty())
            return to_string(target.size());
        vector<vector<int>> words;
        vector<int> oneToCheck(target.size(), 0);
        for(int i=0; i<dictionary.size(); i++){
            if(dictionary[i].size() != target.size())
                continue;
            string w = dictionary[i];
            words.push_back(vector<int>(target.size()));
            for(int j=0; j<w.size(); j++){
                words.back().at(j) = target[j]==w[j]? 0: 1;
                oneToCheck[j] |= words.back().at(j);
            }
        }
        //for(int i=0; i<target.size(); i++)
        //    cout<<oneToCheck[i]<<endl;
        if(words.size() == 0)
            return to_string(target.size());
        vector<int> mask(target.size(), 0);
        minabbre = vector<int>(target.size(), 1);
        helper(target, mask, 0, oneToCheck, words);
        if(minabbre.size() == target.size())
            return target;
        string res = "";
        for(int i= 0; i<minabbre.size(); i++){
            if(minabbre[i] < 22)
                res += to_string(minabbre[i]);
            else 
                res.push_back((char)minabbre[i]);
        }
        return res;
    }
    void helper(string& target, vector<int> mask, int index, vector<int>& oneToCheck, vector<vector<int>>& words){
        if(index >= target.size())
            return;
        for(int i = index; i<target.size(); i++){
            if(oneToCheck[i] == 1){
                mask[i] = 1;
                if(checkConfilict(mask, words) == false){
                    vector<int> tmp = getAbbre(target, mask);
                    if(tmp.size() < minabbre.size()){
                        minabbre = tmp;
                    }
                }
                helper(target, mask, i+1, oneToCheck, words);
                mask[i] = 0;
            }
        }
        return;
    }
    bool checkConfilict(vector<int>& mask, vector<vector<int>>& words){
        for(int i=0; i<words.size(); i++){
            int j = 0;
            for(; j<mask.size(); j++){
                if(mask[j] == 1 && words[i][j] == 1)
                    break;
            }
            if(j == mask.size())
                return true;
        }
        return false;
    }
    vector<int> getAbbre(string& target, vector<int>& mask){
        int c = 0;
        vector<int> res;
        for(int i=0; i<mask.size(); i++){
            if(mask[i]==0)
                c++;
            else{
                if(c>0)
                    res.push_back(c);
                res.push_back(target[i]);
                c = 0;
            }
        }
        if(c >0)
            res.push_back(c);
        return res;
    }

}
