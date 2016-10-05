package myleetcode;

public class PlusOne {
	public int[] plusOne(int[] digits){
		int carrybit =1;
		int[] ret;
		for(int i=digits.length-1; i>=0; i--){
			int tmp = digits[i]+ carrybit;
			if(tmp>9){
				digits[i] = tmp-10;
				carrybit = 1;
			}
			else{
				digits[i] = tmp;
				carrybit = 0;
			}
			
		}
		if(carrybit >0){
			ret = new int[digits.length+1];
			ret[0] = carrybit;
			for(int i=0; i<digits.length; i++)
				ret[i+1] = digits[i];
		}
		else
			ret = digits;
		return ret;
	}
}
