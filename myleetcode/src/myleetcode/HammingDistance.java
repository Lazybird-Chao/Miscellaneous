package myleetcode;

public class HammingDistance {
	public int hammingDistance(int x, int y){
		int sum = x^y;
		int res=0;
		for(int i=0; i<32;i++){
			if((sum & 1)== 1)
				res++;
			sum = sum>>>1;
		}
		return res;
			
	}
}
