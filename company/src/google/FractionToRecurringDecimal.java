package google;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator ==0)
            return "0";
        if(denominator ==0)
            return String.valueOf(Integer.MAX_VALUE);
        List<Long> r = new ArrayList<Long>();
        Map<Long, Integer> m = new HashMap<Long, Integer>();
        int repPos = -1;
        int sign = (long)numerator*denominator >= 0 ? 1: -1;
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        while(n != 0){
            if(m.containsKey(n)){
                repPos = m.get(n);
                break;
            }
            long r1 = n/d;
            long r2 = n%d;
            r.add(r1);
            m.put(n, r.size()-1);
            n = r2*10;
        }
        StringBuilder sb = new StringBuilder();
        if(sign == -1)
            sb.append('-');
        sb.append(String.valueOf(r.get(0)));
        if(r.size()>1){
            sb.append('.');
            for(int i=1; i<r.size(); i++){
                if(repPos == i)
                    sb.append('(');
                sb.append(String.valueOf(r.get(i)));
            }
            if(repPos != -1)
                sb.append(')');
        }
        return sb.toString();
    }

}
