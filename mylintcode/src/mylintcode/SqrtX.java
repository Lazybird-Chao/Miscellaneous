package mylintcode;

public class SqrtX {
	public int sqrt(int x) {
		if(x<0)
			return -1;
		else if(x<2)
			return x;
		
		int left=1;
		int right = x;
		while(left+1 < right) {
			int mid = left + (right-left)/2;
			long tmp = ((long)mid)*mid;
			if(tmp>x)
				right = mid;
			else if(tmp<x)
				left = mid;
			else
				return mid;
		}
		if(right*right==x)
			return right;
		else
			return left;
	}
	
	public int method2(int x) {
		if(x<0)
			return -1;
		else if(x<2)
			return x;
		int left=1;
		int right = x;
		while(left+1 < right) {
			int mid = left + (right-left)/2;
			long tmp = ((long)mid)*mid;
			if(tmp>x) {
				left = x/mid;
				right = mid;
			}
			else if(tmp<x) {
				right = x/mid;
				left = mid;
			}
			else
				return mid;
		}
		if(right*right==x)
			return right;
		else
			return left;				
			
	}
	
	public int method3(int x) {
		if(x<0)
			return -1;
		else if(x<2)
			return x;
		
		int ans = x/2+1;
		while(true) {
			long tmp = (long)ans*ans;
			if(tmp<=x)
				return ans;
			else
				ans = (ans+x/ans)/2;
		}
	}
	

}
