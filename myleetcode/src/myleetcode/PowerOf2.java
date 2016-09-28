package myleetcode;

public class PowerOf2 {
	public boolean isPowerOfTwo(int n){
		if(n>0){
			int i=1;
			int c=0;
			while(i<32){
				c += n&1;
				n = n>>1;
				i++;
			}
			if(c==1)
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
