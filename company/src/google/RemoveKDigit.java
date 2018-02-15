package google;

public class RemoveKDigit {
  public String removeKdigits(String num, int k) {
        if(num == null || k>= num.length())
            return "0";
        Stack<Character> s = new Stack<Character>();
        for(int i=0; i<num.length(); i++){
            if(k==0 || s.isEmpty() || num.charAt(i) >= s.peek())
                s.push(num.charAt(i));
            else{
                s.pop();
                k--;
                i--;
            }
        }
        while(k>0){
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
            sb.append(s.pop());
        int e = sb.length()-1;
        while(e>=0 && sb.charAt(e)=='0')
            e--;
        if(e<0)
            return "0";
        else
            return sb.reverse().substring(sb.length()-e-1);
    }

}
