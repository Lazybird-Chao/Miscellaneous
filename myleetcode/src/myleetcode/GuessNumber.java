package myleetcode;

public class GuessNumber {
	public int gussNumber(int n){
		int left = 1;
		int right = n;
		while(right -left>1){
			int mid = left+(right-left)/2;
			int r = guess(mid);
			if(r==0)
				return mid;
			else if(r>0)
				left = mid+1;
			else
				right = mid-1;
		}
	}
}
