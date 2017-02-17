package myleetcode;

public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n){
		if(n==0)
			return 1;
		int total = 1;
		int A10 = 10;
		int A9 = 1;
		total += A10 -A9;
		for(int i=2; i<=n && i<10; i++){
			A10 = (10-i+1)*A10;
			A9 = (9-i+2)*A9;
			total += A10 -A9;
		}
		return total;
	}
}
