package myleetcode;

public class AddStrings {
	public String addStrings(String num1, String num2){
		int size = num1.length()>num2.length()?num1.length():num2.length();
		char[] num={'0','1','2','3','4','5','6','7','8','9'};
		char[] res = new char[size+1];
		int carry = 0;
		int i=num1.length()-1;
		int j=num2.length()-1;
		int k=0;
		/*while(i>=0 && j>=0){
			int r = num1.charAt(i)-'0' + num2.charAt(j)-'0' + carry;
			carry = r /10;
			res[k]=num[r%10];
			k++;
			i--;
			j--;
		}
		if(j>=0){
			while(j>=0){
				int r = num2.charAt(j)-'0' + carry;
				carry = r /10;
				res[k]=num[r%10];
				k++;
				j--;
			}
		}
		else if(i>=0){
			while(i>=0){
				int r = num1.charAt(i)-'0' + carry;
				carry = r /10;
				res[k]=num[r%10];
				k++;
				i--;
			}
		}*/
		while(i>=0 ||j>=0){
		    int r1 = i>=0?num1.charAt(i)-'0':0;
		    int r2 = j>=0?num2.charAt(j)-'0':0;
		    int r = r1 + r2 + carry;
		    carry = r/10;
		    res[k]= num[r%10];
		    k++;
		    i--;
		    j--;
		}
		if(carry>0){
			res[k]=num[carry];
			k++;
		}
		char[] tmp = new char[k];
		for(i=0; i<k;i++)
			tmp[i] = res[k-1-i];
		return new String(tmp);
	}
}
