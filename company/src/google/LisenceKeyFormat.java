package google;

public class LisenceKeyFormat {
	public String licenseKeyFormatting(String S, int K) {
        if(S == null || S.length() == 0)
            return "";
        char[] sa = S.toCharArray();
        int i = sa.length-1;
        String r = ""; 
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(i>=0){
            if(sa[i]>='a' && sa[i]<='z'){
                sb.append((char)(sa[i] - ('a'-'A')));
                count++;
            }
            else if(sa[i] != '-'){
                sb.append(sa[i]);
                count++;
            }
            
            if(count == K){
                r = sb.reverse().toString() + "-" + r;
                count = 0;
                sb.setLength(0);
            }
            i--;
        }
        if(sb.length()>0)
            r = sb.reverse().toString() + "-" + r;
        if(!r.isEmpty())
            return r.substring(0, r.length()-1);
        else
            return r;
    }

}
