package facebook;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
        if(n<1)
            return 0;
        int left = 1;
        int right = n;
        while(left+1 < right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            } else{
                left = mid;
            }
        }
        if(isBadVersion(left))
            return left;
        else
            return right;
    }

}
