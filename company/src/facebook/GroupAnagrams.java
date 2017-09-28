package facebook;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0)
            return res;
        Map<Long, List<Integer>> record = new HashMap<Long, List<Integer>>();
        for(int i = 0; i < strs.length; i++){
            char[] curs = strs[i].toCharArray();
            long hcode = myHash(curs);
            if(record.containsKey(hcode)){
                List<Integer> l = record.get(hcode);
                int j = 0;
                for(; j < l.size(); j++){
                    String s = res.get(l.get(j)).get(0);
                    if(isAnagrams(curs, s.toCharArray())){
                        res.get(l.get(j)).add(strs[i]);
                        break;
                    }      
                }
                if(j == l.size()){
                    List<String> newone = new ArrayList<String>();
                    newone.add(strs[i]);
                    res.add(newone);
                    l.add(res.size()-1);
                }    
            } else{
                List<String> newone = new ArrayList<String>();
                newone.add(strs[i]);
                res.add(newone);
                List<Integer> l = new ArrayList<Integer>();
                l.add(res.size()-1);
                record.put(hcode, l);
            }
        }
        return res;
    }
    
    long myHash(char[] s){
        long[] letterCode = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 
                             47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        long max = Long.MAX_VALUE/101;
        long h = 1;
        for(int i = 0; i < s.length; i++){
            h = (h*letterCode[s[i]-'a']) % max;
        }
        return h;
    }
    
    boolean isAnagrams(char[] s1, char[] s2){
        if(s1.length != s2.length)
            return false;
        int[] lettercount = new int[26];
        for(int i = 0; i < s1.length; i++)
            lettercount[s1[i]-'a']++;
        for(int i = 0; i < s2.length; i++){
            if(--lettercount[s2[i]-'a'] < 0)
                return false;
        }
        return true;
    }

}
