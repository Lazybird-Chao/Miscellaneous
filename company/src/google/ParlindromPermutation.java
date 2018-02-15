package google;

public class ParlindromPermutation {
	bool canPermutePalindrome(string s) {
        if(s.empty())
            return true;
        int lettermap[256];
        fill(lettermap, lettermap+256, 0);
        for(int i=0; i<s.size(); i++)
            lettermap[s[i]]++;
        int c = 0;
        for(int i=0; i<256; i++){
            if(lettermap[i] % 2 !=0)
                c++;
            if(c>1)
                return false;
        }
        return true;
    }

}
