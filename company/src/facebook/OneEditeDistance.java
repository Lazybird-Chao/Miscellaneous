package facebook;

public class OneEditeDistance {
	public boolean isOneEditDistance(String s, String t) {
		if(s == null || t == null)
            return false;
        if(s.isEmpty() && t.isEmpty()){
            return false;
        }
        else if(s.length() + t.length() == 1){
            return true;
        }
        else if(s.isEmpty() || t.isEmpty()){
            return false;
        }
        char[] longs;
        char[] shorts;
        if(s.length() > t.length()){
            longs = s.toCharArray();
            shorts = t.toCharArray();
        } else{
            longs = t.toCharArray();
            shorts = s.toCharArray();
        }
        if(longs.length - shorts.length >1)
            return false;
        int i = 0;
        int j = 0;
        int diffcount = 0;
        while(i<longs.length || j<shorts.length){
            if(j == shorts.length){
                diffcount++;
                i++;
            }
            else if(longs[i] != shorts[j]){
                if(longs.length == shorts.length)
                    j++;
                i++;
                diffcount++;
                
            }else {
                i++;
                j++;
            }
            if(diffcount > 1)
                break;
        }
        return diffcount == 1;
    }

}
