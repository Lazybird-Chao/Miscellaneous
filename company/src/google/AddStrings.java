package google;

public class AddStrings {
	 public String addStrings(String num1, String num2) {
	        if(num1 == null || num2 == null)
	            return "";
	        if(num1.length() == 0)
	            return num2;
	        else if(num2.length() ==0)
	            return num1;
	        char[] n1 = num1.toCharArray();
	        char[] n2 = num2.toCharArray();
	        char[] ans = new char[Math.max(n1.length, n2.length)+1];
	        int i = n1.length-1;
	        int j = n2.length-1;
	        int k = ans.length-1;
	        int carry = 0;
	        while(i>=0 && j>=0){
	            int sum = n1[i--]-'0'+n2[j--]-'0'+carry;
	            carry = sum /10;
	            ans[k--] = (char)((sum%10) + '0');
	        }
	        while(i>=0){
	            int sum = n1[i--]-'0'+carry;
	            carry = sum /10;
	            ans[k--] = (char)((sum%10) + '0');
	        }
	        while(j>=0){
	            int sum = n2[j--]-'0'+carry;
	            carry = sum /10;
	            ans[k--] = (char)((sum%10) + '0');
	        }
	        if(carry !=0){
	            ans[k] = '1';
	            return new String(ans);
	        }else
	            return new String(ans, 1, ans.length-1);
	        
	    }

}
