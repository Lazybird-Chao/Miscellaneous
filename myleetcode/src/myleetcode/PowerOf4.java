package myleetcode;

public class PowerOf4 {
	public boolean isPowerOfFour(int num) {
		if(num > 0 && (num & (num-1)) == 0){
			int count =0;
			while(num !=0){
				num = num>>1;
				count++;
			}
			return count%2==1;
		}
		return false;
	}
	
	public boolean method2(int num){
		return Integer.toString(num, 4).matches("10*");
	}
	
	public boolean method3(int num){
		if(num >0 && (num &(num-1))==0){
			return (num & 0x55555555)==0;
		}
		return false;
	}
}
