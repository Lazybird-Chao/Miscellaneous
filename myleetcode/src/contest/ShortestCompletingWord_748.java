package contest;

public class ShortestCompletingWord_748 {
	string shortestCompletingWord(string licensePlate, vector<string>& words) {
        if(licensePlate.empty() || words.empty())
            return "";
        vector<int> lettermap(26, 0);
        for(int i = 0; i<licensePlate.size(); i++){
            char c = licensePlate[i];
            if(c>='a' && c<='z'){
                lettermap[c-'a'] += 1;
                //cout<<c<<" "<<lettermap[c-'a']<<endl;
            }
            else if(c>='A' && c<='Z'){
                lettermap[c-'A'] += 1;
                //cout<<c<<" "<<lettermap[c-'A']<<endl;
            }
            
        }
        int lettercount = 0;
        for(int i=0; i<26; i++){
            if(lettermap[i]>0){
                lettercount++;
                //cout<<lettermap[i]<<endl;
            }
        }
        int minwordLen=0;
        string minword;
        for(int i=0; i<words.size(); i++){
            string word = words[i];
            if(validWord(lettermap, lettercount, word)){
                if(minwordLen==0 || minwordLen > word.size()){
                    minwordLen = word.size();
                    minword = word;
                }
            }
        }
        return minword;
        
    }
    bool validWord(vector<int> lettermap, int count, string word){
        for(int i=0; i<word.size(); i++){
            char c = word[i];
            lettermap[c-'a']--;
            if(lettermap[c-'a'] == 0)
                count--;
        }
        //cout<<word<<count<<endl;
        return count==0;
    }

}
