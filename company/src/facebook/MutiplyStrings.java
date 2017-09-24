package facebook;

public class MutiplyStrings {
	public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty())
            return "";
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        for(int i=0; i<num1.length(); i++){
            n1[i] = num1.charAt(num1.length()-i-1)-'0';
        }
        for(int i=0; i<num2.length(); i++){
            n2[i] = num2.charAt(num2.length()-i-1)-'0';
        }
        int[] res = new int[num1.length() + num2.length() +1];
        for(int i =0; i < n1.length; i++){
            int c = 0;
            int index = i;
            for(int j= 0; j < n2.length; j++){
                int tmp = n1[i]*n2[j] + c + res[index];
                res[index++] = tmp % 10;
                c = tmp/10;
            }
            res[index] += c;  // both multiple and sum can only advance at most one more digit
        }
        int end = res.length-1;
        while(res[end] == 0 && end > 0)
            end--;
        StringBuilder r = new StringBuilder();
        while(end >=0){
            r.append((char)(res[end]+'0'));
            end--;
        }
        return r.toString();
    }

}
