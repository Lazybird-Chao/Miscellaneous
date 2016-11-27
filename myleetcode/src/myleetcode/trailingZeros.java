package myleetcode;

public class trailingZeros {
	public int trailingZero(int n){
		if(n==0)
			return 0;
		return n/5 + trailingZero(n/5);
	}
}
