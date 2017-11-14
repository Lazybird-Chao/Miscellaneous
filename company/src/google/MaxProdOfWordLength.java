package google;

public class MaxProdOfWordLength {
	public int maxProduct(String[] words) {
        if(words == null || words.length ==0)
            return 0;
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                if(a.length() != b.length())
                    return a.length() - b.length();
                else
                    return a.compareTo(b);
            }
        });
        int[] mask = new int[words.length];
        for(int i= 0; i < words.length; i++){
            for(int j= 0; j < words[i].length(); j++){
                mask[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        int maxprod = 0;
        for(int i = words.length-1; i>=0;  i--){
            for(int j = i-1; j>=0; j--){
                if((mask[i] & mask[j]) ==0){
                    int tmp = words[i].length()*words[j].length();
                    if(tmp <= maxprod)
                        break;
                    else
                       maxprod = tmp; 
                }
            }
            
        }
        return maxprod;
    }

}
