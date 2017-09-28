package facebook;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.isEmpty())
            return 0;
        Set<String> dict = new HashSet<String>();
        dict.addAll(wordList);
        if(!dict.contains(endWord))
            return 0;
        Set<String> forwardWave = new HashSet<String>();
        forwardWave.add(beginWord);
        Set<String> backwardWave = new HashSet<String>();
        backwardWave.add(endWord);
        dict.remove(endWord);
        if(dict.contains(beginWord))
            dict.remove(beginWord);
        return bfsWave(forwardWave, 1, backwardWave, 1, dict, true);
               
    }
    
    int bfsWave(Set<String> forwardWave, int forwardSteps, Set<String> backwardWave, 
                int backwardSteps, Set<String> dict, boolean isForward){
        if(forwardWave.isEmpty())
            return 0;
        Set<String> nextWave = new HashSet<String>();
        for(String w: forwardWave){
            //System.out.print(w + "  ");
            List<String> wnext = allOneChangeStrings(w);
            for(int i = 0; i < wnext.size(); i++){
                if(backwardWave.contains(wnext.get(i)))
                    return forwardSteps + backwardSteps;
                else if(!dict.isEmpty() && dict.contains(wnext.get(i))){
                    nextWave.add(wnext.get(i));
                    dict.remove(wnext.get(i));
                }
            }
        }
        System.out.println();
        if(nextWave.size() > backwardWave.size())
            return bfsWave(backwardWave, backwardSteps, nextWave, forwardSteps+1, dict, !isForward);
        else
            return bfsWave(nextWave, forwardSteps+1, backwardWave, backwardSteps, dict, isForward);
    }
    
    List<String> allOneChangeStrings(String s){
        List<String> res = new ArrayList<String>();
        char[] sa = s.toCharArray();
        for(int i = 0; i < sa.length; i++){
            char c = sa[i];
            for(int j = 0; j < 26; j++){
                if(c != (char)('a'+j)){
                    sa[i] = (char)('a'+j);
                    res.add(new String(sa));
                }
            }
            sa[i] = c;
        }
        return res;
    }

}
