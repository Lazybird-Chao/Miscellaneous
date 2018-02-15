package google;

public class StudentAttendenceRecord1 {
	public boolean checkRecord(String s) {
        if(s==null || s.isEmpty())
            return true;
        char[] ss = s.toCharArray();
        int start = 0;
        int end = 0;
        int countL = 0;
        int countA = 0;
        while(end < s.length()){
            if(ss[end] == 'L')
                countL++;
            else if(ss[end] == 'A')
                countA++;
            if(countL > 2 || countA > 1)
                return false;
            end++;
            if(end-start > 2){
                if(ss[start] == 'L')
                    countL--;
                start++;
            }
        }
        return true;
    }

}
