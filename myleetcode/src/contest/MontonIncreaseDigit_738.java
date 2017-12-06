package contest;

public class MontonIncreaseDigit_738 {
	public int monotoneIncreasingDigits(int N) {
        if(N<10)
            return N;
        String n = String.valueOf(N);
        int i = 0;
        for(; i<n.length()-1; i++){
            if(n.charAt(i)>n.charAt(i+1))
                break;
        }
        if(i==n.length()-1)
            return N;
        while(i>0){
            if(n.charAt(i) == n.charAt(i-1))
                i--;
            else
                break;
        }
        StringBuilder newn = new StringBuilder(n.substring(0, i));
        newn.append((char)(n.charAt(i)-1));
        i++;
        while(i<n.length()){
            newn.append('9');
            i++;
        }
        if(newn.charAt(0)=='0')
            return Integer.parseInt(newn.toString().substring(1));
        else
            return Integer.parseInt(newn.toString());
        
    }

}
