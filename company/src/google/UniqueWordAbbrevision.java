package google;

public class UniqueWordAbbrevision {
	unordered_map<string, string> abbrevisions;
    ValidWordAbbr(vector<string> dictionary) {
        for(auto &w : dictionary){
            if(w.size() <= 2){
                if(abbrevisions.find(w) == abbrevisions.end())
                    abbrevisions[w] = w;
                else if(abbrevisions[w] != w)
                    abbrevisions[w] = "#";
            }
            else{
                string s = "";
                s.push_back(w[0]);
                s += to_string(w.size()-2);
                s.push_back(w.back());
                if(abbrevisions.find(s) == abbrevisions.end())
                    abbrevisions[s] = w;
                else if(abbrevisions[s] != w)
                    abbrevisions[s] = "#";
            }
        }
    }
    
    bool isUnique(string word) {
        if(word.size()<=2){
            if(abbrevisions.find(word) != abbrevisions.end()){
                if(abbrevisions[word] == "#" || abbrevisions[word]!=word)
                    return false;
            }
            return true;
        }
        else{
            string s = "";
            s.push_back(word[0]);
            s += to_string(word.size()-2);
            s.push_back(word.back());
            if(abbrevisions.find(s) != abbrevisions.end()){
                if(abbrevisions[s] == "#" || abbrevisions[s] != word)
                    return false;
            }
            return true;
        }
    }

}
