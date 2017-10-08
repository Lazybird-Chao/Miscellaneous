package contest;

public class StickersToSpellWord {
	public int minStickers(String[] stickers, String target) {
        if(stickers == null || stickers.length == 0 || target == null || target.length() ==0)
            return 0;
        record = new HashMap<String, Integer>();
        return helper(stickers, target);
        
    }
    Map<String, Integer> record;
    int helper(String[] stickers, String target){
        if(target.isEmpty())
            return 0;
        if(record.containsKey(target))
            return record.get(target);
        int curmatch = 0;
        int minstickers = Integer.MAX_VALUE;
        for(int i = 0; i < stickers.length; i++){
            char[] t = target.toCharArray();
            curmatch = matchCount(stickers[i].toCharArray(), t);
            if(curmatch != 0){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < t.length; j++){
                    if(t[j] != '#')
                        sb.append(t[j]);
                }
                int tmp = helper(stickers, sb.toString());
                if(tmp != -1)
                    minstickers = Math.min(minstickers, tmp+1); 
            }
                
        }
        if(minstickers == Integer.MAX_VALUE){
            record.put(target, -1);
            return -1;
        }else{
            record.put(target, minstickers);
            return minstickers;
        }
    }
    
    int matchCount(char[] s, char[] t){
        int match = 0;
        int[] lettermap = new int[26];
        for(int i = 0; i<s.length; i++)
            lettermap[s[i] - 'a']++;
        for(int i = 0; i<t.length; i++){
            if(t[i] >= 'a'){
                lettermap[t[i]-'a']--;
                if(lettermap[t[i]-'a'] >= 0){
                    t[i] = '#';
                    match++; 
                }
            }
        }
        return match;
    }

}
