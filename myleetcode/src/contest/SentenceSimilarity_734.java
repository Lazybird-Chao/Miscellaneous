package contest;

public class SentenceSimilarity_734 {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || pairs == null)
            return false;
        if(words1.length != words2.length)
            return false;
        Map<String, Set<String>> similar = new HashMap<String, Set<String>>();
        for(int i =0; i<pairs.length; i++){
            if(!similar.containsKey(pairs[i][0]))
                similar.put(pairs[i][0], new HashSet<String>());
            similar.get(pairs[i][0]).add(pairs[i][1]);
        }
        for(int i =0; i<words1.length; i++){
            String w1 = words1[i];
            String w2 = words2[i];
            if(w1.equals(w2))
                continue;
            if(similar.containsKey(w1) && similar.get(w1).contains(w2))
                continue;
            if(similar.containsKey(w2) && similar.get(w2).contains(w1))
                continue;
            return false;
        }
        return true;
    }

}
