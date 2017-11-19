package contest;

public class SelfDividingNumbers_728 {
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = left; i<=right; i++){
            int n = i;
            while(n > 0){
                int digit = n%10;
                if(digit == 0 || i % digit !=0)
                    break;
                n = n/10;
            }
            if(n==0)
                ans.add(i);
        }
        return ans;
    }

}
