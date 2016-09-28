package myleetcode;

public class HammingWeight {
	public int hammingWeight(int n){
		int ret=0;
		while(n!=0){
			if((n&1) == 1)
				ret++;
			n = n>>>1;
		}
		return ret;
	}
	
	public int method2(int n){
		int ret =0;
		while(n!=0){
			ret++;
			n &= n-1;
		}
		return ret;
	}
	
}
