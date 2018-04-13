package contest;

public class CustomerSortingString_791 {
	string customSortString(string S, string T) {
        if(S.empty())
            return T;
        if(T.empty())
            return "";
        vector<char> letter_order(S.size());
        for(int i=0; i<S.size(); i++){
            letter_order[i] = S[i];
        }
        vector<char> letter_count(26, 0);
        for(int i=0; i<T.size(); i++)
            letter_count[T[i]-'a']++;
        string res;
        for(int i=0; i<S.size(); i++){
            char c = letter_order[i];
            if(letter_count[c-'a']!=0){
                for(int j=0; j<letter_count[c-'a']; j++)
                    res.push_back(c);
                letter_count[c-'a'] = 0;
            }
        }
        for(int i=0; i<26; i++){
            char c = (char)(i+'a');
            if(letter_count[i] != 0){
                for(int j=0; j<letter_count[i]; j++)
                    res.push_back(c);
            }
        }
        return res;
    }

}
