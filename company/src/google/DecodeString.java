package google;

public class DecodeString {
	 public String decodeString(String ss) {
	        if(ss == null || ss.length() == 0)
	            return "";
	        char[] sa = ss.toCharArray();
	        Stack<String> s = new Stack<String>();
	        int i = 0;
	        StringBuilder sb = new StringBuilder();
	        while(i < sa.length){
	            if(isDigit(sa[i])){
	                while(i<sa.length && isDigit(sa[i])){
	                    sb.append(sa[i]);
	                    i++;
	                }
	                s.push(sb.toString());
	                sb.setLength(0);
	            }else if(isLetter(sa[i])){
	                while(i<sa.length && isLetter(sa[i])){
	                    sb.append(sa[i]);
	                    i++;
	                }
	                s.push(sb.reverse().toString());
	                sb.setLength(0);
	            }else if(sa[i] == ']'){
	                while(!s.peek().equals("[")){
	                    sb.append(s.pop());
	                }
	                s.pop();
	                String tmp = "";
	                int n = Integer.parseInt(s.pop());
	                for(int j = 0; j<n; j++)
	                    tmp += sb.toString();
	                s.push(tmp);
	                sb.setLength(0);
	                i++;
	            }else if(sa[i] == '['){
	                s.push("[");
	                i++;
	            }
	            //System.out.println(s.peek());
	        }
	        while(!s.isEmpty())
	            sb.append(s.pop());
	        return sb.reverse().toString();
	    }
	    boolean isDigit(char c){
	        return c >= '0' && c<='9';
	    }
	    boolean isLetter(char c){
	        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	    }

}
