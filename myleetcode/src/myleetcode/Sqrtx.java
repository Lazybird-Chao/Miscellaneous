package myleetcode;

public class Sqrtx {
	public int mySqrt(int x){
		if(x<2)
			return x;
		int i;
		int max = x;
        for( i=2; i<= max; i++){
			if(i*i == x)
				return i;
			if(i*i >x || i*i<0)
				break;
			max = x/i;
		}
		return i-1;
    }	
	
	public static int method2(int x){
		if(x<2)
			return x;
		int left =1 ;
		int right = x;
		int middle;
		while(right-left>1){
			middle = left + (right-left)/2;
			long tmp = (long)middle*middle;
			if(tmp == x)
				return middle;
			else if(tmp>x || tmp<0)
				right = middle;
			else
				left = middle;
		}
		return left;
		
	}
	
	public static int method3(int x){
		if(x<2)
			return x;
		int left = 1;
		int right = x;
		int middle;
		while(right-left>1){
			middle = left + (right-left)/2;
			long tmp = (long)middle*middle;
			if(tmp == x)
				return middle;
			else if(tmp>x || tmp<0){
				right = middle;
				left = x/middle;
			}
			else{
				left = middle;
				right = x/middle;
			}
		}
		return left;
	}
	
	public static void main(String args[]){
		method2(2147395599);
	}
	
}
