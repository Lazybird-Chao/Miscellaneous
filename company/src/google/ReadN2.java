package google;

public class ReadN2 {
	char cached_data[4];
    int  used_count = 0;
    int  effect_count = 0;
    int read(char *buf, int n) {
        //cout<<used_count<<" "<<effect_count<<endl;
        int i = 0;
        if(used_count < effect_count){
            while(i<n && used_count<effect_count){
                buf[i] = cached_data[used_count];
                i++;
                used_count++;
            }
        }
        int tmp = 4;
        while(i+4<n){
            tmp = read4(buf+i);
            if(tmp < 4){
                i += tmp;
                break;
            }
            i += 4;
        }
        if(i<n && tmp==4){
            effect_count = read4(cached_data);
            int j=0;
            int remain = n-i;
            for(; j<remain && j<effect_count; j++)
                buf[i++] = cached_data[j];
            used_count = j;
        }
        
        return i;
    }

}
