package contest;

public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
        if(s == null || s.isEmpty())
            return 0;
        int find = 0;
        char[] sa = s.toCharArray();
        int precount = 0;
        char preChar = 0;
        int curcount = 0;
        char curChar = 0;
        int i = 1;
        preChar = sa[0];
        precount = 1;
        while(i < sa.length && sa[i] == preChar){
            precount++;
            i++;
        }
        if(i < sa.length){
            curChar = sa[i];
            curcount= 0;
        }
        while(i < sa.length){
            while(i < sa.length && sa[i] == curChar){
                curcount++;
                i++;
            }
            find += Math.min(precount, curcount); 
            preChar = curChar;
            precount = curcount;
            if(i < sa.length){
                curChar = sa[i];
                curcount= 0;
            }
        }
        return find;
    }

}
