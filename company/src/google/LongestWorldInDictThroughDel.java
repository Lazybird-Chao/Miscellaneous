package google;

public class LongestWorldInDictThroughDel {
	/*
    public String findLongestWord(String s, List<String> d) {
        if(s == null || d == null || s.isEmpty() || d.isEmpty())
            return "";
        record = new HashMap<String, String>();
        String max = "";
        Set<String> dict = new HashSet<String>();
        dict.addAll(d);
        return helper(s, dict);
    }
    Map<String, String> record;
    String helper(String s, Set<String> d){
        String matchs = "";
        if(d.contains(s)){
            matchs = s;   
        }else if(record.containsKey(s)){
            matchs = record.get(s);
        }else{
            for(int i = 0; i < s.length(); i++){
                String tmp = s.substring(0, i) + s.substring(i+1, s.length());
                String tmp2 = helper(tmp, d);
                if(matchs.length() < tmp2.length())
                    matchs = tmp2;
                else if(matchs.length() == tmp2.length() && matchs.compareTo(tmp2) > 0)
                    matchs = tmp2;
            }
            record.put(s, matchs);
        }
        return matchs;   
    }
    */
    public String findLongestWord(String s, List<String> d) {
        if(s == null || d == null || s.isEmpty() || d.isEmpty())
            return "";
        Collections.sort(d, new Comparator<String>(){
            public int compare(String a, String b){
                if(a.length() != b.length())
                    return b.length() - a.length();
                else
                    return a.compareTo(b);
            }
        });
        for(int i = 0; i < d.size(); i++){
            if(contains(s, d.get(i)))
                return d.get(i);
        }
        return "";
    }
    boolean contains(String s, String w){
        char[] sa = s.toCharArray();
        char[] wa = w.toCharArray();
        int i = 0;
        int j = 0;
        while( i < sa.length && j < wa.length){
            if(sa[i] == wa[j])
                j++;
            i++;
        }
        return j == wa.length;
    }

}
