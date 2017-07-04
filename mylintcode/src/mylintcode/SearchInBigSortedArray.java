package mylintcode;

public class SearchInBigSortedArray {
	 public int searchBigSortedArray(ArrayReader reader, int target) {
		 if(reader == null)
			 return -1;
		 int step=1;
		 int upper = 0;
		 while(reader.get(upper)<target){
			 upper += step;
			 step *=2;
		 }
		 int start = upper - step/2;
		 int end = upper;
		 while(start+1 < end){
			 int mid = start + (end-start)/2;
			 if(reader.get(mid)>target)
				 end = mid;
			 else if(reader.get(mid)<target)
				 start = mid;
			 else
				 end = mid;
		 }
		 if(reader.get(start)==target)
			 return start;
		 else if(reader.get(end)==target)
			 return end;
		 else
			 return -1;
	 }

}
