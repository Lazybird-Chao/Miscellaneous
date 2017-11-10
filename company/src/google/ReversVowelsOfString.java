package google;

public class ReversVowelsOfString {
	public String reverseVowels(String s) {
        if(s == null || s.isEmpty())
            return "";
        char[] sa = s.toCharArray();
        int i = 0; 
        int j = sa.length-1;
        while( i < j){
            while(i<j && (sa[i] != 'a' && sa[i] != 'e' &&
                         sa[i] != 'i' && sa[i] != 'o' && sa[i] != 'u' &&
                         sa[i] != 'A' && sa[i] != 'E' && sa[i] != 'I' && sa[i] != 'O' && sa[i] != 'U')){
                i++;
            }
            while(i<j && (sa[j] != 'a' && sa[j] != 'e' &&
                         sa[j] != 'i' && sa[j] != 'o' && sa[j] != 'u' &&
                         sa[j] != 'A' && sa[j] != 'E' && sa[j] != 'I' && sa[j] != 'O' && sa[j] != 'U')){
                j--;
            }
            if(i<j){
                char c = sa[i];
                sa[i] = sa[j];
                sa[j] = c;
                i++;
                j--;
            }
        }
        return new String(sa);
    }

}
