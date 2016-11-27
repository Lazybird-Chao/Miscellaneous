package myleetcode;


public class ArrangingCoins {
	public int arrangeCoins(int n){
		int maxH = (int)Math.floor(Math.sqrt((double)2*n));
		int i;
		for( i= maxH; i>0; i--){
			if(n>=i*(i+1)/2 && (n - i*(i+1)/2) <=i)
				break;
		}
		return i;
	}
}
