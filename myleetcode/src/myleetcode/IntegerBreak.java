package myleetcode;

public class IntegerBreak {
	public int integerBreak(int n){
		if(n<4){
			return n-1;
		}
		int minNum = 4;
		int mul = 4;
		for(int i=5; i<=n; i++){
			if(minNum == 4){
				mul = mul/2;
				mul *=3;
				minNum = 2;
			}
			else if(minNum == 3){
				mul = mul/3;
				mul *=4;
				minNum = 4;
			}
			else{
				// minNum ==2
				mul = mul/2;
				mul *= 3;
				minNum = 3;
			}
			
		}
		return mul;
	}
	
	public int method2(int n){
		if(n<4){
			return n-1;
		}
		int numOf3 = n/3;
		int residue = n%3;
		if(residue ==1){
			numOf3--;
			return (int)Math.pow(3, numOf3) * 4;
		}
		else if(residue ==2)
			return (int)Math.pow(3, numOf3) * 2;
		else
		    return (int)Math.pow(3, numOf3);
	}
}
