package contest;

public class SpecialBinaryString_761 {
	string makeLargestSpecial(string S) {
        if(S.empty())
            return "";
        int count = 0;
        vector<string> sub_specials;
        int start = 0;
        for(int i=0; i<S.size(); i++){
            if(S[i] == '1')
                count++;
            else
                count--;
            if(count==0 && i-start+1 < S.size()){
                // should do recursive for each sub special string here, then sort and re-combine in the following,
                // otherwise (do sort first, then recursive process for each sub-string) my get wrong answer
                sub_specials.push_back(makeLargestSpecial(S.substr(start, i-start+1)));   
                start = i+1;
            }
        }
        if(sub_specials.empty()){
            string sub = S.substr(1, S.size()-2);
            return "1" + makeLargestSpecial(sub) + "0";
        }else{
            sort(sub_specials.begin(), sub_specials.end());
            string res = "";
            for(int i=sub_specials.size()-1; i>=0; i--)
                res += sub_specials[i];
            return res;
        }
    }

}
