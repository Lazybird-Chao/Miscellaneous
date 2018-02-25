package contest;

public class LetterCasePermutation_784 {
	vector<string> letterCasePermutation(string S) {
        if(S.empty()){
            vector<string> res;
            res.push_back("");
            return res;
        }
       vector<string> res;
       helper(S, 0, res);
       return res;
   }
   
   void helper(string s, int index, vector<string>& slist){
       if(index == s.size()){
           slist.push_back(s);
           return;
       }
       while(index < s.size() && s[index]<='9' && s[index]>='0')
           index++;
       if(index < s.size()){
           helper(s, index+1, slist);
           char c = s[index];
           if(s[index] >='a' && s[index]<='z')
               s[index] = (char)('A' + (s[index]-'a'));
           else
               s[index] = (char)('a' + (s[index]-'A'));
           helper(s, index+1, slist);
           s[index] = c;
       }else
           slist.push_back(s);
       return;
   }

}
