package facebook;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0){
            res.add("");
            return res;
        }
        
        int i = 0;
        int charSum = 0;
        while(i < words.length){
            //System.out.println(i);
            int start = i;
            charSum = words[i].length();
            while(charSum <= maxWidth){
                i++;
                if(i >= words.length)
                    break;
                charSum += words[i].length() + 1;
            }
            if(i == start){
                res.add(words[i]);
                i++;
                continue;
            }
            int end = i-1;
            if(i < words.length)
                charSum -= words[i].length()+1;
            int extraSpaces = maxWidth - charSum;
            int spaces = 0;
            int residue = 0;
            int tailspaces = 0;
            if(end == start){
                tailspaces = extraSpaces;
            }else{
                spaces = extraSpaces / (end-start) + 1;
                residue = extraSpaces % (end-start);
            }
            if(end == words.length-1 && end != start){
                spaces = 1;
                residue = 0;
                tailspaces = extraSpaces;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            for(int j = 1; j <= end-start; j++){
                for(int k =0; k <spaces; k++)
                    sb.append(" ");
                if(j-1 < residue)
                    sb.append(" ");
                sb.append(words[start+j]);
            }
            for(int k = 0; k<tailspaces; k++)
                sb.append(" ");
            res.add(sb.toString());
            
        }
        if(res.isEmpty())
            res.add("");
        return res;
    }

}
