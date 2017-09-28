package facebook;

public class CountAndSay {
	public String countAndSay(int n) {
        if(n < 1)
            return "";
        List<Integer> num = helper(n);
        char[] s = new char[num.size()];
        for(int i = 0; i < num.size(); i++)
            s[i] = (char)(num.get(i)+'0');
        return String.valueOf(s);
    }
    
    List<Integer> helper(int n){
        if(n == 1){
            List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            return res;
        }
        List<Integer> pren = helper(n-1);
        List<Integer> res = new ArrayList<Integer>();
        int pre = pren.get(0);
        int count = 0;
        for(int i = 0; i < pren.size(); i++){
            if(pren.get(i) == pre)
                count++;
            else{
                res.add(count);
                res.add(pre);
                pre = pren.get(i);
                count = 1;
            }
        }
        res.add(count);
        res.add(pre);
        return res;
    }

}
