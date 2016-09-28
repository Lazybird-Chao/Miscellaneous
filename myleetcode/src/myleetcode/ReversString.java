package myleetcode;

public class ReversString {
	public String reverseString(String s){
		return method1(s);
	}
	
	public String method1(String s){
		StringBuilder res = new StringBuilder(s);
		res.reverse();
		return res.toString();
	}
	
	public String method2(String s){
		char[] res = s.toCharArray();
		char temp;
		for(int i=0, j=s.length()-1; i<j; i++,j--){
			temp=res[i];
			res[i]=res[j];
			res[j]=temp;
		}
		return new String(res);
	}
}
