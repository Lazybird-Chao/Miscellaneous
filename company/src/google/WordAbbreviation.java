package google;

public class WordAbbreviation {
	/*
    class Trie{
    public:
        Trie *next[26];
        string s;
        unordered_map<string, int> abbre;
        Trie(){
            for(int i=0; i<26; i++){
                next[i] = nullptr;
            }
            s = "";
        }
    };
    vector<string> wordsAbbreviation(vector<string>& dict) {
        if(dict.empty())
            return vector<string>();
        Trie root;
        for(int i=0; i<dict.size(); i++){
            if(dict[i].size() > 3)
                addWord(&root, dict[i]);
        }
        vector<string> res;
        for(int i=0; i<dict.size(); i++){
            if(dict[i].size() <= 3)
                res.push_back(dict[i]);
            else{
                res.push_back(checkWord(&root, dict[i]));
            }
        }
        return res;
        
    }
    void addWord(Trie *root, string word){
        int i = 0;
        while(i<word.size()){
            if(i>0 && i<word.size()-2){
                string tmp = to_string(word.size()-2-i+1) + word.substr(word.size()-1);
                if(root->abbre.find(tmp) == root->abbre.end())
                    root->abbre[tmp] = 1;
                else
                    root->abbre[tmp] += 1;
            }
            char c = word[i];
            if(root->next[c-'a'] ==nullptr)
                root->next[c-'a'] = new Trie();
            root = root->next[c-'a'];
            i++;
        }
        root->s = word;
        return;
    }
    string checkWord(Trie *root, string word){
        int i=0;
        while(i<word.size()){
            if(i>0 && i<word.size()-2){
                string tmp = to_string(word.size()-2-i+1) + word.substr(word.size()-1);
                if(root->abbre[tmp] == 1)
                    return word.substr(0,i) + tmp;
            }else if(i>=word.size()-2)
                break;
            char c = word[i];
            root = root->next[c-'a'];
            i++;
        }
        return word;
    }
    */
    
    static bool mycomp(const string  &a, const string &b){
        if(a.size() > b.size())
            return false;
        else if(a.size() < b.size())
            return true;
        else{
            if(a.back() < b.back())
                return true;
            else if(a.back() > b.back())
                return false;
            else{
                return a<=b;
            }
        }
    }
    
    vector<string> wordsAbbreviation(vector<string>& dict){
        if(dict.empty())
            return vector<string>();
        vector<string> words;
        for(int i=0; i<dict.size(); i++){
            if(dict[i].size() > 3)
                words.push_back(dict[i]);
        }
        sort(words.begin(), words.end(), mycomp);
        unordered_map<string, string> abbr_map;
        int presame_len = 0;
        int cursame_len = 0;
        int i=0;
        while(i<words.size()-1){
            if(words[i].size() == words[i+1].size() && words[i].back() == words[i+1].back()){
                int j = 0;
                cursame_len = 0;
                for(; j < words[i].size(); j++){
                    if(words[i][j] != words[i+1][j])
                        break;
                    cursame_len++;
                }
                int samelen = max(presame_len, cursame_len);
                if(samelen <words[i].size()-3)
                    abbr_map[words[i]] = words[i].substr(0, samelen+1) + to_string(words[i].size()-samelen-2) + 
                                            words[i].substr(words[i].size()-1);
                presame_len = cursame_len;
            }else{
                if(presame_len < words[i].size()-3)
                    abbr_map[words[i]] = words[i].substr(0, 1) + to_string(words[i].size()-presame_len-2) +
                                            words[i].substr(words[i].size()-1);
                presame_len = 0;
            }
            i++;
        }
        if(presame_len < words.back().size()-3)
            abbr_map[words.back()] = words.back().substr(0, presame_len+1) + to_string(words[i].size()-presame_len-2)
                                        + words.back().substr(words.back().size()-1);
        vector<string> res;
        for(i=0; i<dict.size(); i++){
            if(dict[i].size()<=3 || abbr_map.find(dict[i]) == abbr_map.end())
                res.push_back(dict[i]);
            else
                res.push_back(abbr_map[dict[i]]);
        }
        return res;
            
    }

}
