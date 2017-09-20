package facebook;

public class DecodeWays {
	public int numDecodings(String s) {
        if(s == null || s.isEmpty())
            return 0;
        if(s.charAt(0) == '0' || s.contains("00"))
            return 0;
        int[] f = new int[s.length()];
        f[0] = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) != '0' && Integer.parseInt(s.substring(i-1,i+1)) <=26){
                f[i] = i-2 >= 0 ? f[i-2]:1;
            }
            if(s.charAt(i) != '0')
                f[i] = f[i] + f[i-1];
            //System.out.println(f[i]);
        }
        return f[s.length()-1];
    }

}
