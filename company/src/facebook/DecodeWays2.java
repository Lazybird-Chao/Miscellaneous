package facebook;

public class DecodeWays2 {
	/*
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        char[] sa = s.toCharArray();
        record = new long[s.length()];
        for(int i= 0; i<s.length(); i++)
            record[i] = -1;
        long res = decode(sa, 0);
        return (int)(res % 1000000007);
        
    }
    long[] record;
    long decode(char[] s, int index){
        if(index >= s.length)
            return 1;
        if(record[index] >= 0)
            return record[index];
        if(index == s.length-1){
            if(s[index] == '*')
                record[index] = 9;
            else if(s[index] == '0')
                record[index] = 0;
            else
                record[index] = 1;
            return record[index];
        }
        if(s[index] == '0')
            record[index] = 0;
        else if(s[index] == '*'){
            long n1 = (9 * decode(s, index+1))% 1000000007;
            long n2 = 0;
            if(s[index+1] == '*')
                n2 = ((9+6)*decode(s, index+2))% 1000000007;
            else{
                n2 = decode(s, index+2);   //[1x]......
                if(s[index+1] < '7')  //[2x]......
                    n2 += decode(s, index+2);
            }
            record[index] = (n1 + n2)% 1000000007;
        } else{
            long n1 = decode(s, index+1);
            if(s[index] == '1'){
                if(s[index+1] == '*')
                    n1 += (9*decode(s, index + 2))% 1000000007;
                else
                    n1 += decode(s, index+2);
            }
            else if(s[index] == '2'){
                if(s[index + 1] == '*')
                    n1 += (6*decode(s, index+2))% 1000000007;
                else if(s[index+1] < '7')
                    n1 += decode(s, index+2);
            }
            record[index] =  n1% 1000000007;
        }
        return record[index];
    }
    */
    
    public int numDecodings(String s){
        if(s == null || s.length() == 0)
                return 0;
        char[] sa = s.toCharArray();
        long[] record = new long[s.length()+1];
        record[s.length()] = 1;
        for(int index = sa.length -1; index >=0; index--){
            if(index == sa.length-1){
                if(sa[index] == '*')
                    record[index] = 9;
                else if(sa[index] == '0')
                    record[index] = 0;
                else
                    record[index] = 1;
                continue;
            }
            if(sa[index] == '0')
                record[index] = 0;
            else if(sa[index] == '*'){
                long n1 = (9 * record[index+1])% 1000000007;
                long n2 = 0;
                if(sa[index+1] == '*')
                    n2 = ((9+6)*record[index+2])% 1000000007;
                else{
                    n2 = record[index+2];   //[1x]......
                    if(sa[index+1] < '7')  //[2x]......
                        n2 += record[index+2];
                }
                record[index] = (n1 + n2)% 1000000007;
            } else{
                long n1 = record[index+1];
                if(sa[index] == '1'){
                    if(sa[index+1] == '*')
                        n1 += (9*record[index+2])% 1000000007;
                    else
                        n1 += record[index+2];
                }
                else if(sa[index] == '2'){
                    if(sa[index + 1] == '*')
                        n1 += (6*record[index+2])% 1000000007;
                    else if(sa[index+1] < '7')
                        n1 += record[index+2];
                }
                record[index] =  n1% 1000000007;
            }
            
        }
        return (int)record[0];
    }

}
