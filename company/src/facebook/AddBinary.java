package facebook;

public class AddBinary {
	public String addBinary(String a, String b) {
        if(a == null || a.isEmpty())
            return b;
        if(b == null || b.isEmpty())
            return a;
        
        char[] aS = a.toCharArray();
        char[] bS = b.toCharArray();
        int i = 0;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(aS.length - i-1 >=0 && bS.length - i-1 >=0){
            int ai = aS[aS.length-i-1]-'0';
            int bi = bS[bS.length - i -1]-'0';
            int ri = (ai+bi+carry)%2;
            carry = (ai+bi+carry)/2;
            res.append(String.valueOf(ri));
            i++;
        } 
        while(aS.length - i-1 >=0){
            int ai = aS[aS.length-i-1]-'0';
            int ri = (ai+carry)%2;
            carry = (ai+carry)/2;
            res.append(String.valueOf(ri));
            i++;
        }
        while(bS.length - i-1 >=0){
            int bi = bS[bS.length-i-1]-'0';
            int ri = (bi+carry)%2;
            carry = (bi+carry)/2;
            res.append(String.valueOf(ri));
            i++;
        }
        if(carry == 1)
            res.append("1");
        return res.reverse().toString();
        
    }

}
