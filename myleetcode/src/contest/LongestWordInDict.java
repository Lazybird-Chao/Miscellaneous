package contest;

public class LongestWordInDict {
	public String longestWord(String[] words) {
        if(words == null || words.length == 0)
            return "";
        Set<String> dict = new HashSet<String>();
        for(int i = 0; i< words.length; i++)
            dict.add(words[i]);
        String maxString = "";
        Map<String, Boolean> record = new HashMap<String, Boolean>();
        for(int i = 0; i<words.length; i++){
            String cur = words[i];
            if(cur.length() < maxString.length())
                continue;
            else if(cur.length() == maxString.length() && cur.compareTo(maxString) >= 0)
                continue;
            if(check(dict, cur, record)){
                if(cur.length() > maxString.length())
                    maxString = cur;
                else if(cur.length() == maxString.length() && cur.compareTo(maxString) < 0)
                    maxString = cur;
            }
        }
        return maxString;
    }
    boolean check(Set<String> dict, String s, Map<String,Boolean> record){
        if(s.isEmpty())
            return true;
        if(record.containsKey(s))
            return record.get(s);
        if(dict.contains(s)){
            boolean tmp = check(dict, s.substring(0, s.length()-1), record);
            record.put(s, tmp);
            return tmp;
        }else{
            record.put(s, false);
            return false;
        }
    }

}
