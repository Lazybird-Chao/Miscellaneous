package myleetcode;

public class BullsCows {
	public String getHint(String secret, String guess){
		int bulls=0;
		int cows=0;
		int[] digit = new int[10];
		for(int i=0; i<guess.length(); i++){
			if(secret.charAt(i)==guess.charAt(i))
				bulls++;
			else{
				if(digit[secret.charAt(i)-'0'] >0){
					cows++;
				}
				if(digit[guess.charAt(i)-'0']<0){
					cows++;
				}
				digit[secret.charAt(i)-'0']--;
				digit[guess.charAt(i)-'0']++;
			}
		}
		String ret = Integer.toString(bulls)+"A"+
						Integer.toString(cows)+"B";
		return ret;
	}
}
