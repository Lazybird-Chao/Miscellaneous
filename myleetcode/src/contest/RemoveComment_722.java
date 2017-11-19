package contest;

public class RemoveComment_722 {
	public List<String> removeComments(String[] source) {
        if(source == null || source.length == 0)
            return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int status = 0;
        char[] currentLine = null;
        while(i < source.length){ 
            if(currentLine == null)
                currentLine = source[i].toCharArray();
            if(status == 0){
                while(j < currentLine.length && currentLine[j] != '/'){
                    sb.append(currentLine[j]);
                    j++;
                }
                if(j == currentLine.length){
                    if(sb.length() != 0)
                        res.add(sb.toString());
                    sb.setLength(0);
                    currentLine = null;
                    i++;
                    j = 0;
                }else{
                    if(j+1 < currentLine.length){
                        if(currentLine[j+1]=='/'){
                            status = 1;
                            j += 2;
                        }
                        else if(currentLine[j+1] == '*'){
                            status = 2;
                            j += 2;
                        }else{
                            sb.append(currentLine[j]);
                            j++; 
                        }
                    }else{
                        sb.append(currentLine[j]);
                        j++;
                    }
                }
            }else if(status == 1){
                if(sb.length() != 0)
                    res.add(sb.toString());
                sb.setLength(0);
                currentLine = null;
                i++;
                j = 0;
                status = 0;
            }else if(status == 2){
                 while(j < currentLine.length && currentLine[j] != '*'){
                    j++;
                }
                if(j == currentLine.length){
                    currentLine = null;
                    //if(sb.length() != 0)
                    //    res.add(sb.toString());
                    //sb.setLength(0);
                    i++;
                    j = 0;
                }else{
                    if(j+1 < currentLine.length){
                        if(currentLine[j+1] == '/'){
                            status = 0;
                            j+= 2;
                        }else
                            j++;
                    }else
                        j++;
                }
            }
        }
        if(sb.length() != 0)
            res.add(sb.toString());
        return res;
    }

}
