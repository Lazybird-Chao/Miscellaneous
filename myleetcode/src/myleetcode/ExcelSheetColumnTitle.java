package myleetcode;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n){
		char[] c_map = new char[26];
		c_map[0] = 'A';
		for(int i=1; i<26; i++)
			c_map[i] = (char) (c_map[i-1]+1);
		char[] tmp = new char[10];
		int i=0;
		while(n!=0){
			n--;
			tmp[i] = c_map[n%26];
			i++;
			n /=26;
		}
		char[] res = new char[i];
		for(int k=0, j=i-1; j>=0; j--,k++)
			res[k] = tmp[j];
		return new String(res);
		
	}
	
	public String method2(int n){
		return n==0?"" : method2((n-1)/26) + (char)('A'+ (n-1)%26);
	}
}
