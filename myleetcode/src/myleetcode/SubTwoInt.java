package myleetcode;

public class SubTwoInt {
	public int getSum(int a, int b){
		int i;
		for(i=0; i<a; i++);
		for(int j=0; j<b; j++)
			i++;
		return i;
	}
	
	public int method2(int a, int b){
		if(a==0)
			return b;
		if(b==0)
			return a;
		int r_xor = a^b;
		int r_and = (a&b)<<1;
		return method2(r_and, r_xor);
	}
}
