package facebook;

public class PowXn {
	public double myPow(double x, int n) {
        if(x == 0)
            return x;
        if(n == 0)
            return 1;
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double sign = 1;
        if(x < 0 && n%2 ==1){
            x = -x;
            sign = -1;
        } else if(x < 0 && n%2 ==0){
            x = -x;
        }
        double res = 1;
        double unitx = x;
        while(N > 0){
            if((N & 1) == 1){
                res *= unitx;
            }
            unitx *= unitx;
            N /=2;
        }
        return res*sign;
    }

}
