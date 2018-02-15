package google;

public class EncodeStringWithShortestLength {
	string encode(string s) {
        if(s.empty())
            return "";
        string shortest[s.size()][s.size()];
        for(int i=0; i<s.size(); i++){
            for(int j=0; j<s.size(); j++){
                if(j==i)
                    shortest[i][j] = string(1, s[i]);
                else
                    shortest[i][j] = "";
            }
        }
        for(int i=s.size()-2; i>=0; i--){
            for(int j=i+1; j<s.size(); j++){
                string tmp1 = s.substr(i, j-i+1);
                int len = j-i+1;
                for(int k=i+1; k<=j; k++){
                    if(len%(k-i) == 0 && s.substr(i, j-k+1) == s.substr(k, j-k+1)){
                        string tmp2 = to_string(len/(k-i))+"["+shortest[i][k-1]+"]";
                        if(tmp1.size() > tmp2.size())
                            tmp1 = tmp2;
                    }
                    if(k-i > len/2)
                        break;
                }
                for(int k = i; k<j; k++){
                    string tmp2 = shortest[i][k] + shortest[k+1][j];
                    if(tmp1.size() > tmp2.size())
                        tmp1 = tmp2;
                }
                shortest[i][j] = tmp1;
            }
        }
        return shortest[0][s.size()-1];
    }

}
