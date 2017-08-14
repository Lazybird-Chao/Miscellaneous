package mylintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		if(s==null || s=="" || wordDict==null || wordDict.size()==0)
			return new ArrayList<String>();
		ans = new ArrayList<String>();
		StringBuilder curS = new StringBuilder();
		helper(s, wordDict, curS);
		return ans;
		
	}
	
	List<String> ans;
	
	void helper(String s, Set<String> wordDict, StringBuilder curS) {
		if(s.isEmpty()) {
			ans.add(curS.substring(0, curS.length()-1));
			return;
		}
		for(String word: wordDict) {
			if(s.startsWith(word)) {
				curS.append(word);
				curS.append(" ");
				helper(s.substring(word.length()), wordDict, curS);
				curS.delete(curS.length()-word.length()-1, curS.length());
			}
		}
		return;
	}
	
	public List<String> method2(String s, Set<String> wordDict) {
		if(s==null || s=="" || wordDict==null || wordDict.size()==0)
			return new ArrayList<String>();
		List<String>[] subStringSentence = new List[s.length()];
		for(int i=0; i<s.length(); i++)
			subStringSentence[i] = new ArrayList<String>();
		boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                isWord[i][j] = wordDict.contains(word);
            }
        }
        if(isWord[0][0])
        	subStringSentence[0].add(s.substring(0,1));
		for(int i=1; i<s.length(); i++) {
			if(isWord[0][i])
				subStringSentence[i].add(s.substring(0,i+1));
			for(int j=1; j<=i; j++) {
				if(isWord[j][i]) {
					String tmp = s.substring(j,i+1);
					for(String tmps : subStringSentence[j-1])
							subStringSentence[i].add(tmps+" "+tmp);
				}
			}
		}
		return subStringSentence[s.length()-1];
		
	}

}
