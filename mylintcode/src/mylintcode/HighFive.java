package mylintcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HighFive {
	class Record {
		      public int id, score;
		      public Record(int id, int score){
		          this.id = id;
		          this.score = score;
		      }
		  }
	
	public Map<Integer, Double> highFive(Record[] results) {
		if(results == null || results.length ==0)
			return new HashMap<Integer, Double>();
		Map<Integer, Double> avgScore = new HashMap<Integer, Double>();
		Map<Integer, Queue<Integer>> scoreRecored = new HashMap<Integer, Queue<Integer>>();
		for(int i=0; i<results.length; i++) {
			Queue<Integer> scores;
			if(scoreRecored.containsKey(results[i].id)) {
				scores = scoreRecored.get(results[i].id);
			}
			else {
				scores = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
					@Override
					public int compare(Integer a, Integer b){
						return b-a;
						}
					});
				scoreRecored.put(results[i].id, scores);
			}
			scores.add(results[i].score);
		}
		for(int id : scoreRecored.keySet()) {
			Queue<Integer> scores = scoreRecored.get(id);
			int sum = 0;
			for(int i=0; i<5; i++) {
				sum += scores.poll();
			}
			avgScore.put(id, (double)sum/5);
		}
		return avgScore;
		
	}
	

}
