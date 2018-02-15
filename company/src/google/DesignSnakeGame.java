package google;

public class DesignSnakeGame {
	class SnakeGame {
		public:
		    /** Initialize your data structure here.
		        @param width - screen width
		        @param height - screen height 
		        @param food - A list of food positions
		        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
		    SnakeGame(int width, int height, vector<pair<int, int>> food) {
		        H = height;
		        W = width;
		        this->food = food;
		        board = vector<vector<char>>(H, vector<char>(W, 0));
		        board[0][0] = 's';
		        snake_pos.push(make_pair(0, 0));
		        snake_size = 1;
		        for(int i=0; i<food.size(); i++){
		            if(food[i].first != 0 || food[i].second!=0){
		                board[food[i].first][food[i].second] = 'f';
		                food_idx = i+1;
		                break;
		                
		            }
		        }
		    }
		    
		    /** Moves the snake.
		        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
		        @return The game's score after the move. Return -1 if game over. 
		        Game over when snake crosses the screen boundary or bites its body. */
		    int move(string direction) {
		        pair<int, int> cur_head = snake_pos.back();
		        pair<int, int> next_head;
		        if(direction == "U")
		            next_head = make_pair(cur_head.first-1, cur_head.second);
		        else if(direction == "D")
		            next_head = make_pair(cur_head.first+1, cur_head.second);
		        else if(direction == "L")
		            next_head = make_pair(cur_head.first, cur_head.second-1);
		        else if(direction == "R")
		            next_head = make_pair(cur_head.first, cur_head.second+1);
		        if(next_head.first<0 || next_head.first>=H || next_head.second<0 || next_head.second >= W)
		            return -1;
		    
		        snake_pos.push(next_head);
		        //cout<<next_head.first<<" "<<next_head.second<<" "<<board[next_head.first][next_head.second]<<" "<<snake_pos.size()<<endl;
		        if(board[next_head.first][next_head.second] != 'f'){
		            pair<int, int> tail = snake_pos.front();
		            snake_pos.pop();
		            board[tail.first][tail.second] = 0;
		            if(board[next_head.first][next_head.second] == 's')
		                return -1;
		            board[next_head.first][next_head.second] = 's';
		        }else{
		            board[next_head.first][next_head.second] = 's';
		            snake_size++;
		            for(int i=food_idx; i<food.size(); i++){
		                //cout<<food[i].first<<" "<<food[i].second<<" "<<board[food[i].first][food[i].second]<<endl;
		                if(food[i].first<0 || food[i].first>=H || food[i].second<0 || food[i].second >=W)
		                    continue;
		                if(board[food[i].first][food[i].second] != 's'){
		                    board[food[i].first][food[i].second] = 'f';
		                    food_idx = i+1;
		                    break;
		                }
		            }
		        }
		        
		        return snake_size-1;
		    }
		private:
		    vector<vector<char>> board;
		    int H;
		    int W;
		    vector<pair<int, int>> food;
		    int food_idx;
		    queue<pair<int, int>> snake_pos;
		    int snake_size;
		    
		};

}
