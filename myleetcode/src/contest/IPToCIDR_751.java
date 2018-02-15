package contest;

public class IPToCIDR_751 {
	vector<string> ipToCIDR(string ip, int range) {
        long nip = 0;
        int p1 = 0;
        int p2 = ip.find('.');
        while(p2 != -1){
            nip = nip*256 + stol(ip.substr(p1, p2));
            p1 = p2+1;
            p2 = ip.find('.', p2+1);
        }
        nip = nip*256 + stol(ip.substr(p1));
        long startip = nip;
        long endip = nip + range-1;
        vector<string> ips;
        while(startip <= endip){
            startip = helper(startip, endip, ips);
        }
        return ips;
        
    }
    long helper(long startip, long endip, vector<string> &ips){
        long ipmask1 = 255 <<24;
        long ipmask2 = 255 <<16;
        long ipmask3 = 255 <<8;
        long ipmask4 = 255;
        long i= 0;
        while((startip & (1<<i))==0)
            i++;
        long sufmask = (1<<i)-1;
        long pre = startip & (~sufmask);
        while(pre + sufmask > endip){
            sufmask = sufmask >>1;
            i--;
            pre = startip &(~sufmask);
        }
        string ip1 = to_string((pre & ipmask1)>>24);
        string ip2 = to_string((pre & ipmask2)>>16);
        string ip3 = to_string((pre & ipmask3)>>8);
        string ip4 = to_string((pre & ipmask4));
        string count = to_string(32-i);
        ips.push_back(ip1+"."+ip2+"."+ip3+"."+ip4+"/"+count);
        
        return pre+sufmask+1;  
    }

}
