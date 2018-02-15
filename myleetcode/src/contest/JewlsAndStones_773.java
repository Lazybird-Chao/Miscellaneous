package contest;

public class JewlsAndStones_773 {
	int numJewelsInStones(string J, string S) {
        if(J.empty() || S.empty())
            return 0;
        int lettermap[256];
        fill(lettermap, lettermap+256, 0);
        for(int i=0; i<J.size(); i++)
            lettermap[J[i]] = 1;
        int count = 0;
        for(int i=0; i<S.size(); i++){
            if(lettermap[S[i]]==1)
                count++;
        }
        return count;
    }

}
