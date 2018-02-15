package contest;

public class BoldWordsInString_758 {
	static bool mycomp(pair<int, int>& a, pair<int, int>& b){
        return a.first < b.first;
    }
    string boldWords(vector<string>& words, string S) {
        if(S.empty())
            return "";
        if(words.empty())
            return S;
        vector<pair<int, int>> pos_pair;
        for(int i=0; i<words.size(); i++){
            int pos = S.find(words[i]);
            while(pos != -1){
                pos_pair.push_back(make_pair(pos, pos+words[i].size()-1));
                pos = S.find(words[i], pos+1);
            }
        }
        if(pos_pair.empty())
            return S;
        sort(pos_pair.begin(), pos_pair.end(), mycomp);
        int start = pos_pair[0].first;
        int end = pos_pair[0].second;
        string res = "";
        int pre_end = 0;
        for(int i=1; i<pos_pair.size(); i++){
            if(pos_pair[i].first > end+1){
                res += S.substr(pre_end, start-pre_end) + "<b>" + S.substr(start, end-start+1) + "</b>";
                pre_end = end+1;
                start = pos_pair[i].first;
                end = pos_pair[i].second;
            }else{
                end = max(pos_pair[i].second, end);
            }
        }
        res += S.substr(pre_end, start-pre_end) + "<b>" + S.substr(start, end-start+1) + "</b>" + S.substr(end+1);
        return res;
    
    }

}
