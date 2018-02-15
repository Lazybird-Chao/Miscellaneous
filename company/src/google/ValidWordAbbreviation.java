package google;

public class ValidWordAbbreviation {
	bool validWordAbbreviation(string word, string abbr) {
        if(word.empty()  && abbr.empty())
            return true;
        else if(word.empty() || abbr.empty())
            return true;
        int i=0;
        int j=0;
        while(i<abbr.size()){
            if(abbr[i]<='9' && abbr[i]>'0'){
                int n = 0;
                while(i<abbr.size() && abbr[i]<='9' && abbr[i]>='0'){
                    n *=10;
                    n += abbr[i]-'0';
                    i++;
                }
                j += n;
            }
            if(i==abbr.size() && j!=word.size())
                return false;
            else if(abbr[i] != word[j])
                return false;
            i++;
            j++;
        }
        return true;
    }

}
