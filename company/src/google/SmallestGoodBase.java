package google;

public class SmallestGoodBase {
	string smallestGoodBase(string n) {
        if(n.empty())
            return "";
        long num = stol(n);
        int minlen = 2;
        int maxlen = (int)floor(log2(num));
        long base=0;
        for(int len = maxlen; len>=minlen; len--){
            int b = findbase(len, num);
            if(b != 0){
                base = b;
                break;
            }
        }
        if(base==0)
            base = num-1;
        return to_string(base);
    }
    
    long findbase(int len, long n){
        long left = 2;
        long right = (long)floor(pow(n, 1.0/len));
        while(left < right){
            long mid = left + (right-left)/2;
            long tmpn = 0;
            int j = 0;
            while(j <= len){
                tmpn = tmpn*mid + 1;
                j++;
                if(tmpn > (n-1)/mid)
                    break;
            }
            //cout<<tmpn<<" "<<j<<endl;
            if(tmpn == n)
                return mid;
            else if(j <= len)
                right = mid-1;
            else
                left = mid+1;
        }
        //cout<<len<<" "<<left<<" "<<right<<endl;
        if(left == right){
            long tmpn = 0;
            int j = 0;
            while(j <= len){
                tmpn = tmpn*left + 1;
                j++;
                if(tmpn >(n-1)/left)
                    break;
            }
            if(tmpn == n)
                return left;
            else
                return 0;
        }else
            return 0;
        
    }

}
