package contest;

public class StringCompression {
	public int compress(char[] chars) {
        if(chars == null || chars.length == 0)
            return 0;
        int count = 0;
        int index = 0;
        char c = chars[0];
        int i = 0;
        while(i < chars.length){
            if(chars[i] == c){
                count++;
                i++;
                continue;
            }else{
                if(count >= 2){
                    chars[index] = c;
                    index++;
                    String n = String.valueOf(count);
                    for(int j = 0; j<n.length(); j++)
                        chars[index++] = n.charAt(j);
                }else{
                    chars[index++] = c;
                }
                count = 0;
                c = chars[i];
            }
        }
        chars[index++] = c;
        if( count >= 2){
            String n = String.valueOf(count);
            for(int j = 0; j<n.length(); j++)
                chars[index++] = n.charAt(j);
        }
        return index;
    }

}
