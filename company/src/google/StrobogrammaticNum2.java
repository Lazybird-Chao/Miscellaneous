package google;

public class StrobogrammaticNum2 {
	/*
    public List<String> findStrobogrammatic(int n) {
        if(n < 1)
            return new ArrayList<String>();
        List<String> f1 = new ArrayList<String>();
        f1.addAll(Arrays.asList("0", "1", "8"));
        List<String> f2 = new ArrayList<String>();
        f2.addAll(Arrays.asList("11","69", "96", "88"));
        if(n==1)
            return f1;
        else if(n==2)
            return f2;
        f2.add("00");
        for(int i=3; i<=n; i++){
            List<String> fcur = new ArrayList<String>();
            if(i % 2 == 0){
                for(String s : f1){
                    fcur.add("1"+s+"1");
                    fcur.add("8"+s+"8");
                    fcur.add("6"+s+"9");
                    fcur.add("9"+s+"6");
                    if(i != n)
                        fcur.add("0"+s+"0");
                }
            }else{
                int mid = i/2;
                for(String s : f2){
                    if(i==n && s.charAt(0)=='0')
                        continue;
                    fcur.add(s.substring(0, mid) + "0" + s.substring(mid));
                    fcur.add(s.substring(0, mid) + "1" + s.substring(mid));
                    fcur.add(s.substring(0, mid) + "8" + s.substring(mid));
                }
            }
            f1 = f2;
            f2 = fcur;
        }
        //Collections.sort(f2);
        return f2;
    }
    */
    public List<String> findStrobogrammatic(int n) {
        if(n < 1)
            return new ArrayList<String>();
        List<String> f1 = new ArrayList<String>();
        if(n % 2 ==0)
            f1.add("");
        else
            f1.addAll(Arrays.asList("0", "1", "8"));
        while(n>1){
            List<String> tmp = new ArrayList<String>();
            for(String s: f1){
                if(n-2>1)
                    tmp.add("0"+s+"0");
                tmp.add("1"+s+"1");
                tmp.add("8"+s+"8");
                tmp.add("6"+s+"9");
                tmp.add("9"+s+"6");
            }
            f1 = tmp;
            n -= 2;
        }
        //Collections.sort(f1);
        return f1;
    }

}
