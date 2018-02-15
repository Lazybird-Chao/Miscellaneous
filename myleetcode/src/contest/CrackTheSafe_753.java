package contest;

public class CrackTheSafe_753 {
	public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int m = 1;
        for(int i=0; i<n; i++){
            sb.append('0');
            m *= k;
        }
        Set<String> checked = new HashSet<String>();
        checked.add(sb.toString());
        StringBuilder target = new StringBuilder(sb);
        
        String start = sb.toString();
        while(true){
            boolean stop = true;
            for(int i=k-1; i>=0; i--){
                String next = start.substring(1) + String.valueOf(i);
                if(!checked.contains(next)){
                    checked.add(next);
                    target.append(String.valueOf(i));
                    stop = false;
                    start = next; 
                    break;
                }       
            }
            if(stop == true)
                break;
        }

        return target.toString();
        
    }
    /*
    boolean helper(int n, int k, int m, Set<String> checked, StringBuilder target, StringBuilder cur){
        StringBuilder next = new StringBuilder(cur.substring(1));
        for(int i=0; i<k; i++){
            next.append(String.valueOf(i));
            if(!checked.contains(next.toString())){
                checked.add(next.toString());
                target.append(String.valueOf(i));
                if(target.length() == n+m-1)
                    return true;
                if(helper(n, k, m, checked, target, next))
                    return true;
                checked.remove(next.toString());
                target.setLength(target.length()-1);
            }
            next.setLength(next.length()-1);
        }
        return false;
        
    }
    */

}
