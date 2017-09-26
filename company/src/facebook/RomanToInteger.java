package facebook;

public class RomanToInteger {
	public int romanToInt(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] romanUnit = new int[128];
        romanUnit['I']  = 1;
        romanUnit['V'] = 5;
        romanUnit['X'] = 10;
        romanUnit['L'] = 50;
        romanUnit['C'] = 100;
        romanUnit['D'] = 500;
        romanUnit['M'] = 1000;
        char[] num = s.toCharArray();
        int n = 0;
        for(int i = 0; i<num.length-1; i++){
            if(romanUnit[num[i]] < romanUnit[num[i+1]])
                n = n - romanUnit[num[i]];
            else
                n = n + romanUnit[num[i]];
        }
        n += romanUnit[num[num.length-1]];
        return n;
    }

}
