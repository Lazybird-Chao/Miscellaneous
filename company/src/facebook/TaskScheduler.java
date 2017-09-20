package facebook;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;
        if(n <= 0)
            return tasks.length;
        char[] taskcount = new char[26];
        for(int i=0; i<tasks.length; i++){
            taskcount[tasks[i]-'A']++;
        }
        Arrays.sort(taskcount);
        int[] occu = new int[taskcount[25]];
        int startpos = 0;
        for(int i=25; i>=0; --i){
            if(taskcount[i] == 0)
                break;
            for(int j=0; j<taskcount[i]; ++j){
                occu[startpos]++;
                ++startpos;
                if(taskcount[i] == taskcount[25])
                    startpos %= taskcount[25];
                else
                    startpos %= taskcount[25]-1;
            }
        }
        int totalinterval = 0;
        for(int i = 0; i<occu.length-1; i++)
            totalinterval += Math.max(occu[i], n+1);
        totalinterval += occu[occu.length-1];
        return totalinterval;
    }
    
    
    public int method2(char[] tasks, int n){
        if(tasks == null || tasks.length == 0)
            return 0;
        if(n <= 0)
            return tasks.length;
        char[] taskcount = new char[26];
        int maxcount = 0;
        int numMax = 0;
        for(int i=0; i<tasks.length; i++){
            taskcount[tasks[i]-'A']++;
            if(taskcount[tasks[i]-'A'] > maxcount){
                maxcount = taskcount[tasks[i]-'A'];
                numMax = 1;
            } else if(taskcount[tasks[i]-'A'] == maxcount){
                numMax++;
            }
        }
        
        int idlepos = (maxcount-1)*(n+1-numMax);
        int availtasks = tasks.length - maxcount*numMax;
        int totalintervals = 0;
        if(idlepos >= availtasks)
            totalintervals = (maxcount-1)*(n+1) + numMax;
        else
            totalintervals = tasks.length;
        return totalintervals;
    }

}
