package google;

public class DeleteOpsForTwoStrings {
	int minDistance(string word1, string word2) {
        if(word1.empty())
            return word2.size();
        else if(word2.empty())
            return word1.size();
        int f[word1.size()][word2.size()];
        if(word1[0] == word2[0])
            f[0][0] = 1;
        else
            f[0][0] = 0;
        for(int j=1; j<word2.size(); j++){
            f[0][j] = f[0][j-1];
            if(word1[0] == word2[j])
                f[0][j] = max(f[0][j], 1);
        }
        for(int i=1; i<word1.size(); i++){
            if(word1[i] == word2[0])
                f[i][0] = 1;
            else
                f[i][0] = f[i-1][0];
            for(int j=1; j<word2.size(); j++){
                f[i][j] = max(f[i-1][j], f[i][j-1]);
                if(word1[i] == word2[j])
                    f[i][j] = max(f[i][j], f[i-1][j-1]+1);
            }
        }
        return word1.size() + word2.size() - 2*f[word1.size()-1][word2.size()-1];
    }

}
