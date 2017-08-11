package mylintcode;

public class DropEggs {
	public int dropEggs(int n) {
		if(n==0)
			return 0;
		
		int k_max=1;
		while((1+k_max)*k_max/2<n)
			k_max *=2;
		if(k_max==1)
			return k_max;
		int left = k_max/2;
		int right = k_max;
		while(left+1<right) {
			int mid = left+(right-left)/2;
			int tmp =(1+mid)*mid/2; 
			if(tmp>=n)
				right = mid;
			else
				left = mid;
		}
		if((1+left)*left/2>=n)
			return left;
		else
			return right;
	}
	
	public int method2(int n) {
		if(n==0)
			return 0;
		int sum=0;
		int i;
		for( i=1;i<n; i++) {
			sum += i;
			if(sum>=n)
				break;
		}
		return i;
	}

}
