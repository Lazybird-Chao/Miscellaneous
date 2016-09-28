package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num){
		int[] BitArray = new int[10];
		for(int i: BitArray)
			i = 0;
		int index = 0;
		int countOne = num;
		List<String> result = new ArrayList<String>();
		
		findBinary(BitArray, index, countOne, result);
		
		return result;
		
	}
	
	private void findBinary(int[] BitArray, int index, int countOne, List<String> res){
		if(countOne ==0){
			int hour=0;
			int min=0;
			for(int i=index; i<10;i++)
				BitArray[i]=0;
			for(int i=0; i<4 && i<index; i++){
				hour *= 2;
				hour += BitArray[i];
			}
			if(hour >=12)
				return;
			for(int i=4; i<10;i++){
				min *=2;
				min +=BitArray[i];
			}
			if(min >=60)
				return;
			String tmp = Integer.toString(hour);
			tmp += ":";
			if(min<10)
				tmp +="0";
			tmp +=Integer.toString(min);
			res.add(tmp);
			return;
		}
		
		if(countOne > 10 - index)
			return;
		
		BitArray[index] = 1;
		findBinary(BitArray, index+1, countOne-1, res);
		
		BitArray[index]=0;
		findBinary(BitArray, index+1, countOne, res);
	}
}
