package google;

public class FlipGame2 {
	bool canWin(string s) {
        if(s.empty())
            return false;
        unordered_map<string, bool> record;
        return helper(s, record);
    }
    bool helper(string s,  unordered_map<string, bool>& record){
        if(s.find("++") == -1){
            return false;
        }
        if(record.find(s) != record.end())
            return record[s];
        bool win = true;
        for(int i=0; i<s.size()-1; i++){
            if(s[i] == '+' && s[i+1] == '+'){
                string tmp = s.substr(0, i) + "--" + s.substr(i+2, s.size() - i -2);
                win = helper(tmp, record);
                if(win == false)
                    break;
            }
        }
        if(win == false){
            record[s] = true;
            return true;
        }else{
            record[s] = false;
            return false;
        }
    }

}
