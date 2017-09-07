package amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() ==0)
			return 0;
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		Set<String> accessed = new HashSet<String>();
		int count = 0;
		while(!q.isEmpty()) {
            count++;
            int size = q.size();
            for(int i=0; i<size; i++){
               String cur = q.poll();
                for(String word: wordList) {
                    if(!accessed.contains(word) && differ1(word, cur)) {
                        if(word.equals(endWord))
                            return count+1;
                        q.offer(word);
                        accessed.add(word);
                    }
                } 
            }
			
		}
		return 0;
		
	}
	
	boolean differ1(String s1, String s2) {
		int count= 0;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i))
				count++;
			if(count>1)
				break;
		}
		return count==1;
	
    }

}
