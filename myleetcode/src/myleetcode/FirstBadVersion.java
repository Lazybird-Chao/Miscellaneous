package myleetcode;

public class FirstBadVersion {
	public int firstBadVersion(int n){
		int left = 1; 
		int right = n;
		while(right-left>1){
			int middle = left+(right-left)/2;
			if(isBadVersion(middle)){
				right = middle;
			}
			else
				left = middle;
		}
		if(isBadVersion(left))
			return left;
		if(isBadVersion(right))
			return right;
		return 0;
	}
}
