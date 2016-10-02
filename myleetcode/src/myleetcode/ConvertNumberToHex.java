package myleetcode;

public class ConvertNumberToHex {
	public String toHex(int num){
		if(num ==0)
            return new String("0");
		char[] res = new char[8];
		int x = 1<<28-1;
		x = ~x;
		int i=0;
		for(; i<32; i+=4){
			int tmp = num & x;
			tmp = tmp>>>28;
			if(tmp >0)
				break;
			num = num<<4;
		}
		int j=0;
		for(; i<32; i+=4){
			int tmp = num & x;
			tmp = tmp>>>28;
			if(tmp<10){
				res[j] = '0';
				for(int k=0; k<tmp; k++)
					res[j]++;
			}	
			else{
				res[j] = 'a';
				for(int k=0; k<tmp-10; k++)
					res[j]++;
			}	
			j++;
			num = num<<4;
		}
		
		return new String(res, 0, j);
	}
}
