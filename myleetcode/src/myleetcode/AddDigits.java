package myleetcode;

public class AddDigits {
	public int addDigits(int num){
		int res =0;
		while(num >=10){
			res =0;
			while(num!=0){
				int a= num%10;
				res +=a;
				num/=10;
			}
			num = res;
		}
		return num;
	}
}
