package myleetcode;

public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration){
		int total_duration = 0;
		for(int i=0; i<timeSeries.length-1; i++){
			if(timeSeries[i+1] >= timeSeries[i] + duration)
				total_duration += duration;
			else
				total_duration += timeSeries[i+1] - timeSeries[i] + 1;
		}
		if(timeSeries.length>0)
			total_duration += duration;
		return total_duration;
	}
}
