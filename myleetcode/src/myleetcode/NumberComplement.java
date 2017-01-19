package myleetcode;

public class NumberComplement {
	public int findComplement(int num){
		int res = 0;
		int shift = 0;
		while(num !=0){
			int bit = ((num & 1) +1)%2 ;
			res = res + bit<<shift;
			num = num >> 1;
			shift++;
		}
		return res;
	}
	
	public int method2(int num){
		int mask = (Integer.highestOneBit(num)<<1)-1;
		return (~num) & mask;
	}
}
