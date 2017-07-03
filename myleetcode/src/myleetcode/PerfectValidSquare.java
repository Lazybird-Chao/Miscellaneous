package myleetcode;

public class PerfectValidSquare {
	 public boolean isPerfectSquare(int num){
		 if(num<=0)
			 return false;
		 int start = 1; 
		 int end = num/2 == 0 ? 1:num/2;
		 while(start<=end){
			 int mid = start + (end-start)/2;
			 long s = (long)mid*mid;
			 if(s == num)
				 return true;
			 else if(s < num)
				 start = mid+1;
			 else
				 end = mid -1;
		 }
		 return false;
	 }
	 
	 public boolean method2(int num){
		 if(num<=0)
			 return false;
		 int sum =1;
		 while(sum<num){
			 sum = sum+2;
		 }
		 return sum==num;
	 }
	 
	 public boolean medthod3(int num){
		 if(num<=0)
			 return false;
		 long s = num;
		 while(s*s>num){
			 s = (s+num/s)/2;
		 }
		 return s*s == num;
	 }
	 
	 public static void main(String args[]){
		 PerfectValidSquare r = new PerfectValidSquare();
		 System.out.println(r.isPerfectSquare(808201));
	 }
}

