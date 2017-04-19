package myleetcode;

import java.util.ArrayList;

public class Base7 {
	public String convertToBase7(int num){
		ArrayList<Character> r = new ArrayList<Character>();
		if(num==0)
			return new String("0");
		if(num<0){
			r.add('-');
			num *=-1;
		}
		while(num>0){
			r.add((char) (num%7+'0'));
			num /= 7;
		}
		char[] res = new char[r.size()];
		if(r.get(0)=='-'){
			res[0]='-';
			for(int i=r.size()-1, j=1; i>=1; i--,j++)
				res[j] = r.get(i);
		}
		else{
			for(int i=r.size()-1, j=0; i>=0; i--,j++)
				res[j] = r.get(i);
		}
		return new String(res);
	}
	
	public String method2(int num){
		if(num==0)
			return new String("0");
		int x = num>0? num: -1*num;
		String res = new String("");
		while(x>0){
			res = Integer.toString(num%7) + res;
			x /= 7;
		}
		return num>0?res: "-"+res;
	}
}
