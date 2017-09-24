package facebook;

public class isPalindrome {
	public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        if(s.isEmpty())
            return true;
        int i = 0;
        int j = s.length() - 1;
        char[] ss = s.toCharArray();
        while(i<j){
            if(!isAlphnum(ss[i]))
                ++i;
            else if(!isAlphnum(ss[j]))
                --j;
            else if(ss[i] == ss[j] ||(ss[i] > '9' && ss[j] > '9' && (ss[i]-'a' == ss[j]-'A' ||
              ss[i]-'A' == ss[j]-'a'))){
                ++i;
                --j;
            } else{
                return false;
            }
        }
        return true;
    }
    boolean isAlphnum(char c){
        if( c >= '0' && c <= '9')
            return true;
        else if(c >= 'a' && c<= 'z')
            return true;
        else if(c >= 'A' && c <= 'Z')
            return true;
        else
            return false;
    }

}
