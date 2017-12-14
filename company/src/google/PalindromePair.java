package google;

public class PalindromePair {
	public List<List<Integer>> palindromePairs(String[] words) {
        if(words == null || words.length==0)
            return new ArrayList<List<Integer>>();
        Map<String, Integer> dicts = new HashMap<String, Integer>();
        for(int i=0; i<words.length; i++)
            dicts.put(words[i], i);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0; i<words.length; i++){
            String w = words[i];
            if(w.isEmpty())
                continue;
            StringBuilder sb = new StringBuilder(w);
            String rw = sb.reverse().toString();
            helper(res, dicts, w, rw, i, true);
            helper(res, dicts, rw, w, i, false);
        }
        return res;
        
    }
    
    void helper(List<List<Integer>> res, Map<String, Integer> dicts, String w, String rw, int i, boolean dir){
        char c = w.charAt(w.length()-1);
        int pos = w.indexOf(c);
        while(pos>=0){
            String sub = w.substring(pos);
            String rsub = rw.substring(0, w.length()-pos);
            if(sub.equals(rsub)){
                String tmp = "";
                if(dir)
                    tmp = rw.substring(w.length()-pos);
                else
                    tmp = w.substring(0, pos);
                if(dicts.containsKey(tmp)){
                    List<Integer> pair = new ArrayList<Integer>();
                    if(dir){
                        pair.add(i);
                        pair.add(dicts.get(tmp));
                    }else{
                        pair.add(dicts.get(tmp));
                        pair.add(i);
                    }
                    res.add(pair);
                }
            }
            pos = w.indexOf(c, pos+1);
        }
        if(dicts.containsKey(rw) && dicts.get(rw) != i){ 
            List<Integer> pair = new ArrayList<Integer>();
            if(dir){
                pair.add(i);
                pair.add(dicts.get(rw));
            }else{
                pair.add(dicts.get(rw));
                pair.add(i);
            }
            res.add(pair);   
        }
        return;
    }

}
