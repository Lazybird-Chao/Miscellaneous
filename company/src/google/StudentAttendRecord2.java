package google;

public class StudentAttendRecord2 {
	int checkRecord(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 3;
        long LL0 = 1;
        long LL1 = 0;
        long XL0 = 1;
        long XL1 = 1;
        long XX0 = 2;
        long XX1 = 3;
        for(int i=3; i<=n; i++){
            long tmp_LL0 = XL0;
            long tmp_LL1 = XL1;
            long tmp_XL0 = XX0;
            long tmp_XL1 = XX1;
            long tmp_XX0 = LL0 + XL0 + XX0;
            long tmp_XX1 = (LL0 + XL0 + XX0) + (LL1 + XL1 + XX1);
            
            LL0 = tmp_LL0 %(1000000007);
            LL1 = tmp_LL1 %(1000000007);
            XL0 = tmp_XL0 %(1000000007);
            XL1 = tmp_XL1 %(1000000007);
            XX0 = tmp_XX0 %(1000000007);
            XX1 = tmp_XX1 %(1000000007);
        }
        long total = LL0 + LL1 + XL0 + XL1 + XX0 + XX1;
        return total %(1000000007);
    }

}
