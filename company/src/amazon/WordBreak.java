package amazon;
import java.util.*;

public class WordBreak {
	
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size()==0)
            return false;
        Map<String, Boolean> record = new HashMap<String, Boolean>();
        return helper(s, wordDict, record);
    }
    
    boolean helper(String s, List<String> wordDict, Map<String, Boolean> record){
        if(s.isEmpty())
            return true;
        if(record.containsKey(s))
            return record.get(s);
        for(String w : wordDict){
            int index = s.indexOf(w, 0);
            while(index != -1){
                String pre = s.substring(0, index);
                String sub = s.substring(index+w.length(), s.length());
                if(helper(pre, wordDict, record) && helper(sub, wordDict, record)){
                    record.put(s, true);
                    return true;
                } 
                index = s.indexOf(w, index+1);
            }
        }
        record.put(s, false);
        return false;
    }
    
    
    public boolean method2(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size()==0)
            return false;
        
        boolean[] f = new boolean[s.length()+1];
        f[s.length()] = true;
        for(int i=s.length()-1; i>=0; i--){
            f[i] = false;
            for(int j=0; j<wordDict.size(); j++){
                int index = s.indexOf(wordDict.get(j), i);
                if(index == i && f[i+wordDict.get(j).length()]){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }

}
