package myleetcode;
import java.util.HashSet;

public class HappyNumber {
	public boolean isHappy(int n){
		HashSet<Integer> checkSet = new HashSet<Integer>();
		checkSet.add(n);
		while(n>0){
			int c = 0;
			while(n>0){
				int d = n%10;
				c += d*d;
				n /= 10;
			}
			if(c == 1)
				return true;
			if(checkSet.contains(c))
				return false;
			checkSet.add(c);
			n = c;
		}
		return false;
	}
	
	public boolean method2(int n){
		int fast, slow;
		slow = n;
		fast = digitPowerSum(n);
		fast = digitPowerSum(fast);
		while(slow!=fast){
			slow = digitPowerSum(slow);
			fast = digitPowerSum(n);
			fast = digitPowerSum(fast);
		}
		return slow == 1;
		
	}
	
	public int digitPowerSum(int n){
		int c=0;
		while(n>0){
			int d = n%10;
			c += d*d;
			n /= 10;
		}
		return c;
	}
	
	public static void main(String[] args){
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.method2(119));
	}
}
