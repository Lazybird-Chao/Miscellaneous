package mylintcode;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if(divisor==0)
			return dividend>=0?Integer.MAX_VALUE:Integer.MIN_VALUE;
		if(dividend==0)
			return 0;
		if(dividend==Integer.MIN_VALUE && divisor==-1)
			return Integer.MAX_VALUE;
		boolean sign = true;
		if(dividend<0) {
			sign = !sign;
			dividend = Math.abs(dividend);
		}
		if(divisor<0) {
			sign = !sign;
			divisor = Math.abs(divisor);
		}
		int res = 0;
		while(dividend>=divisor) {
			dividend -= divisor;
			if(sign)
				res++;
			else
				res--;
		}
		return res;
		
		
	}
	
	public int method2(int dividend, int divisor) {
		if(divisor==0)
			return dividend>=0?Integer.MAX_VALUE:Integer.MIN_VALUE;
		if(dividend==0)
			return 0;
		if(dividend==Integer.MIN_VALUE && divisor==-1)
			return Integer.MAX_VALUE;
		boolean sign = true;
		if(dividend<0) {
			sign = !sign;	
		}
		if(divisor<0) {
			sign = !sign;
		}
		
		long a = Math.abs((long)dividend);;
		long b =  Math.abs((long)divisor);
		int res = 0;
		while(a >= b) {
			int shift =0;
			while(a >= (b<<shift))
				shift++;
			shift--;
			a -= b<<shift;
			if(sign)
				res += 1<<shift;
			else
				res -= 1<<shift;
		}
		return res;
	}

}
