package mylintcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumber2 {
	 public int nthUglyNumber(int n) {
		 if(n<=0)
			 return 0;
		 Queue<Long> minQ = new PriorityQueue<Long>();
		 minQ.add(1L);
		 int count=0;
		 long lastN = 0;
		 while(count<n) {
			 long cur = minQ.poll();
			 if(cur ==lastN)
				 continue;
			 count++;
			 lastN = cur;
			 minQ.add(cur*2);
			 minQ.add(cur*3);
			 minQ.add(cur*5);
		 }
		 return (int)lastN;
	 }

}
