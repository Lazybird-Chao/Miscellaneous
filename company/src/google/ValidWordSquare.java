package google;

public class ValidWordSquare {
	bool validWordSquare(vector<string>& words) {
        if(words.empty())
            return true;
        for(int i=0; i<words.size(); i++){
            string tmp = "";
            for(int j=0; j<words.size(); j++){
                if(words[j].size() <= i)
                    break;
                tmp += words[j][i];
            }
            if(tmp != words[i])
                return false;
        }
        return true;
    }

}
