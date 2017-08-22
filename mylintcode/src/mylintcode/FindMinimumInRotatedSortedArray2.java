package mylintcode;

public class FindMinimumInRotatedSortedArray2 {
	public int findMin(int[] num) {
		if(num==null || num.length==0)
			return -1;
		int head = num[0];
		int end = num[num.length-1];
		int left = 0;
		int right = num.length-1;
		while(right>left && num[right]==num[left])
		    --right;
		while(left+1<right){
			int mid = left + (right-left)/2;
			if(num[mid]<=num[right])
				right = mid;
			else if(num[mid]>=num[left])
				left = mid;
		}
		if(num[left]<=num[right])
			return num[left];
		else
			return num[right];
	}

}
