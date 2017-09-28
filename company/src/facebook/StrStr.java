package facebook;

public class StrStr {
	public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        if(haystack.isEmpty())
            return needle.isEmpty() ? 0:-1;
        else if(needle.isEmpty())
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for(int i = 0; i <= h.length - n.length; i++){
            int j = 0;
            for(; j < n.length; j++){
                if(h[i+j] != n[j])
                    break;
            }
            if(j == n.length)
                return i;
        }
        return -1;
    }
	
}
