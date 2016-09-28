package myleetcode;
import java.lang.*;

public class PowerOf3 {
	public boolean isPowerOfThree(int n){
		double res = Math.log(n) / Math.log(3);
		if(Math.floor(res) == res)
		//if((res + EPSILON) % 1 <= 2*EPSILON)
			return true;
		else
			return false;
	}
}
