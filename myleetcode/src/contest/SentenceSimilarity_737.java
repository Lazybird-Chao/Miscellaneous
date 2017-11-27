package contest;

public class SentenceSimilarity_737 {
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || pairs == null)
            return false;
        if(words1.length != words2.length)
            return false;
        Map<String, String> farther = new HashMap<String, String>();
        for(int i =0; i<pairs.length; i++){
            String s1 = pairs[i][0];
            String s2 = pairs[i][1];
            union(farther, s1, s2);
        }
        for(int i =0; i<words1.length; i++){
            if(words1[i].equals(words2[i]))
                continue;
            if(find(farther, words1[i]).equals(find(farther, words2[i])))
                continue;
            return false;
        }
        return true;
        
    }
    String find(Map<String, String> farther, String s){
        if(!farther.containsKey(s)){
            farther.put(s,s);
            return s;
        }else{
            if(farther.get(s).equals(s))
                return s;
            else{
                String tmp = farther.get(s);
                String root = find(farther, tmp);
                farther.put(s, root);
                return root;
            }
        }
    }
    void union(Map<String, String> farther, String s1, String s2){
        String r1 = find(farther, s1);
        String r2 = find(farther, s2);
        farther.put(r1, r2);
    }

}
