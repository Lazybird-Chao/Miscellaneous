package google;

public class NthDigit {
	public int findNthDigit(int n) {
        long countbase1 = 9;
        long countbase2 = 1;
        long ans = 1;
        while(n > countbase1*countbase2){
            n = n-(int)(countbase1*countbase2);
            countbase1 *= 10;
            countbase2++;
            ans *=10;
        }
        ans += (n-1) / countbase2;
        long shift = countbase2 - (n-1)%countbase2-1;
        while(shift>0){
            ans /= 10;
            shift--;
        }
        return (int)ans %10;
        
    }

}
