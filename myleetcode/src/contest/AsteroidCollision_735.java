package contest;

public class AsteroidCollision_735 {
	/*
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length ==0)
            return new int[0];
        int collide = 0;
        while(true){
            collide = 0;
            int i = 0;
            while(i<asteroids.length && asteroids[i] ==0)
                i++;
            if(i>=asteroids.length)
                break;
            int pre = i;
            i++;
            while(i<asteroids.length){
                if(asteroids[i] == 0){
                    i++;
                    continue;
                }
                if((asteroids[i] < 0 && asteroids[pre] > 0)){
                    if(Math.abs(asteroids[i]) > Math.abs(asteroids[pre])){
                        asteroids[pre] = 0;
                        pre = i;
                        i++;
                        collide++;
                        continue;
                    }else if(Math.abs(asteroids[i]) < Math.abs(asteroids[pre])){
                        asteroids[i] = 0;
                        i++;
                        collide++;
                        continue;
                    }else{
                        asteroids[i] = 0;
                        asteroids[pre] = 0;
                        collide++;
                        i++;
                        while(i<asteroids.length && asteroids[i] ==0)
                            i++;
                        if(i>=asteroids.length)
                            break;
                        pre = i;
                        i++;
                        continue;
                    }
                }else{
                    pre = i;
                    i++;
                    continue;
                }
            }
            if(collide == 0)
                break;
        }
        ArrayList<Integer> r = new ArrayList<Integer>();
        for(int i = 0; i<asteroids.length; i++){
            if(asteroids[i] != 0)
                r.add(asteroids[i]);
        }
        int[] res = new int[r.size()];
        for(int i = 0; i<r.size(); i++)
            res[i] = r.get(i);
        return res;
    }
    */
    
    public int[] asteroidCollision(int[] asteroids){
        if(asteroids == null || asteroids.length ==0)
            return new int[0];
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while(i < asteroids.length){
            if(stack.isEmpty() || asteroids[i] > 0){
                stack.push(asteroids[i]);
                i++;
            } else{
                int pre = stack.peek();
                if(pre > 0){
                    if(pre < -asteroids[i])
                        stack.pop();
                    else if(pre == -asteroids[i]){
                        stack.pop();
                        i++;
                    }else
                        i++;
                }else{
                    stack.push(asteroids[i]);
                    i++;
                }
            }
        }
        int[] res = new int[stack.size()];
        for( i = res.length-1; i>=0; i--)
            res[i] = stack.pop();
        return res;
    }

}
