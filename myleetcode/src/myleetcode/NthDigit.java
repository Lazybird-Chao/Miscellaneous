package myleetcode;

public class NthDigit {
	public int findNthDigit(int n){
		int i=1;
		int j=1;
		int k=1;
		while(i<n){
			k = j;
			int dc=0;
			while(k>0){
				dc++;
				k=k/10;
			}
			if(n<=i+dc){
				k=j;
				dc = dc -(n-i);
				while(dc>0){
					k = k/10;
					dc--;
				}
				break;
			}
			else{
				i= i+dc;
				j++;
			}
		}
		return k%10;
	}
	
	public int method2(int n){
		if(n<10)
			return n;
		int i=2;
		int index1=10;
		int t=9;
		int num =1;
		while(i<9){
			t = t*10;
			num = num*10;
			index1 = index1 + t*i -1;
			if(n<=index1)
				break;
			else{
				index1 = index1+1;
				i++;
			}
		}
		int numpos = (n-index1)/i;
		int digitpos = (n-index1)%i;
		if(i==9)
		    num = num*10;
		num = num+numpos;
		return Integer.toString(num).charAt(digitpos)-'0';
	}
	
	public int method3(int n){
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
}
