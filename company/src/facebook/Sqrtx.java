package facebook;

public class Sqrtx {
	 public int mySqrt(int x) {
	        if(x<2)
	            return x;
	        int rx = x;
	        while(rx > x/rx){
	            //long tmp = (long)rx + x/rx;
	            //rx = (int)(tmp/2);
	            rx = rx/2 + x/rx/2;
	        }
	        if((rx+1) > x/(rx+1))
	            return rx;
	        return rx + 1;
	        
	    }

}
