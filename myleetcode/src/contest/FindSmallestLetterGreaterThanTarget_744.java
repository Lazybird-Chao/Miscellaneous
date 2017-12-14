package contest;

public class FindSmallestLetterGreaterThanTarget_744 {
	char nextGreatestLetter(vector<char>& letters, char target) {
        if(letters.empty())
            return 0;
        int left = 0;
        int right = letters.size()-1;
        while(left+1 < right){
            int mid = left + (right-left)/2;
            char c = letters[mid];
            if(c>target)
                right = mid;
            else
                left = mid;
        }
        if(letters[left]>target)
            return letters[left];
        else if(letters[right]>target)
            return letters[right];
        else
            return letters[0];
    }

}
