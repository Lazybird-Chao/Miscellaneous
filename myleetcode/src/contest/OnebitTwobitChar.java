package contest;

public class OnebitTwobitChar {
	 public boolean isOneBitCharacter(int[] bits) {
	        if(bits == null || bits.length ==0)
	            return false;
	        int i = 0;
	        while(i < bits.length-1){
	            if(bits[i] == 0)
	                i++;
	            else
	                i+=2;
	        }
	        return i == bits.length-1;
	    }

}
