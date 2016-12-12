package myleetcode;

public class NumOfSegments {
	static public int countSegments(String s){
		if(s==null || s.length()==0)
			return 0;
        String[] subs = s.split(" +");
        if(subs.length >0 && subs[0].length()==0)
            return subs.length -1;
		return subs.length;
	}
	
	public int method2(String s){
		int count=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)!= ' ')
				continue;
			count++;
			while(i<s.length() && s.charAt(i)==' '){
				i++;
			}
		}
		if(s.charAt(s.length()-1) != ' ')
		    count++;
		return count;
	}
	
	public static void main(String arg[]){
		System.out.println(countSegments("    "));
	}
}
