package google;

public class FindDiffence {
	public char findTheDifference(String s, String t) {
        if(s.isEmpty())
            return t.charAt(0);
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        char[] map = new char[26];
        for(int i = 0; i < sa.length; i++){
            map[sa[i]-'a']++;
        }
        for(int i = 0; i < ta.length; i++){
            map[ta[i]-'a']--;
        }
        for(int i= 0; i<26; i++){
            if(map[i] != 0)
                return (char)(i+'a');
        }
        return 0;
    }

}
