package facebook;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        if(n<1)
            return "";
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int tmp = n%26;
            if(tmp ==0)
                tmp = 26;
            char c = (char)('A' + tmp-1);
            sb.append(String.valueOf(c));
            n = (n-tmp)/26;
        }
        return sb.reverse().toString();
    }

}
