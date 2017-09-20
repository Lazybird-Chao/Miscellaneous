package facebook;

public class IntegerToEnglishWords {
	public String numberToWords(int num) {
        if(num < 0)
            return "";
        String[] unit = {"", "Thousand", "Million", "Billion"};
        String[] digit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] inten = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] outten = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int i= 0;
        int unitIndex = 3;
        String res = "";
        int u = 1000000000;
        while(num != 0){
            if(num >= u){
                int numTmp = num / u;
                if(numTmp >= 100){
                    int tmp = numTmp/100;
                    res += digit[tmp] + " Hundred ";
                    numTmp = numTmp % 100;
                }
                if(numTmp >= 20){
                    int tmp = numTmp/10;
                    res += outten[tmp] + " ";
                    numTmp = numTmp % 10;
                }
                if(numTmp >= 10){
                    numTmp = numTmp%10;
                    res += inten[numTmp] + " ";
                    numTmp = 0;
                }
                if(numTmp > 0){
                    res += digit[numTmp] + " ";
                }
                if(unitIndex > 0)
                    res += unit[unitIndex] + " ";
            }
            num = num % u;
            u = u/1000;
            unitIndex--;   
        }
        
        if(res.isEmpty())
            return "Zero";
        else
            return res.substring(0, res.length()-1);
        
    }

}
