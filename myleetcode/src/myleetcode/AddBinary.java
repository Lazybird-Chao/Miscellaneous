package myleetcode;

public class AddBinary {
	public String addBinary(String a, String b){
		int c = 0;
		char[] res = new char[a.length()>b.length()?a.length()+1:b.length()+1];
		int i,j,k;
		for( i=a.length()-1, j=b.length()-1, k=res.length-1; i>=0 && j>=0; i--,j--,k--){
			int sum = (a.charAt(i) -'0') + (b.charAt(j)-'0') + c;
			res[k] = sum%2 == 0? '0':'1';
			c = sum/2;
		}
		if(i<0){
			for(;j>=0; j--,k--){
				int sum = (b.charAt(j)-'0') + c;
				res[k] = sum%2 == 0? '0':'1';
				c = sum/2;
			}
		}
		else{
			for(;i>=0; j--,k--){
				int sum = (a.charAt(i)-'0') + c;
				res[k] = sum%2 == 0? '0':'1';
				c = sum/2;
			}
		}
		res[k] = c==0?'0':'1';
		return c==0? new String(res,1,res.length-1):new String(res);
		
	}
	
	public String method2(String a, String b){
		int c = 0;
		char[] res = new char[a.length()>b.length()?a.length()+1:b.length()+1];
		int i,j,k;
		for( i=a.length()-1, j=b.length()-1, k=res.length-1; i>=0 || j>=0; i--,j--,k--){
			int sum = c;
			if(i>=0) sum += (a.charAt(i) -'0');
			if(j>=0) sum += (b.charAt(i) -'0');
			res[k] = sum%2 == 0? '0':'1';
			c = sum/2;
		}
		res[k] = c==0?'0':'1';
		return c==0? new String(res,1,res.length-1):new String(res);
	}
}
