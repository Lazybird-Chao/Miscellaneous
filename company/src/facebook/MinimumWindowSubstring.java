package facebook;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        if(s == null || t == null)
            return "";
        if(s.isEmpty() || t.isEmpty())
            return "";
        int[] cmap = new int[256];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for(int i=0; i<ta.length; i++)
            cmap[ta[i]]++;
        int start = 0;
        int end = 0;
        int validcount = 0;
        int minlength = Integer.MAX_VALUE;
        int minstart = 0;
        int minend = 0;
        while(start <= end){
            // move window end
            while(validcount < ta.length && end<sa.length){
                cmap[sa[end]]--;
                if(cmap[sa[end]] >=0 )
                    validcount++;
                end++;
            }
            if(validcount < ta.length)
                break;
            // move window start
            while(validcount == ta.length && start <= end){
                if(minlength > end - start){ // end is at next pos of current windwon end
                    minstart = start;
                    minend = end-1;
                    minlength = end - start;
                }
                //System.out.println(s.substring(minstart, minend+1));
                cmap[sa[start]]++;
                if(cmap[sa[start]] > 0)
                    validcount--;
                start++;
            }
            if(minlength == ta.length)
                break;
        }
        if(minlength == Integer.MAX_VALUE)
            return "";
        else
            return s.substring(minstart, minend+1);
        
    }

}
