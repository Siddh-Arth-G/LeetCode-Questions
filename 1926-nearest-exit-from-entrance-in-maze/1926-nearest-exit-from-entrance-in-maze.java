class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
         return bfs(maze, entrance); // bfs is better than dfs because we will be exploring all the possible paths in a single iteration, giving us the minimum path in least amount of exploration. 

    }

    
    private int bfs(char[][] maze, int[] entrance){
        int m = maze.length, n = maze[0].length; 

        // Directions array {Right, left, down, up}
        int[] rowoffset = {0, 0, 1, -1};
        int[] coloffset = {1, -1, 0, 0};

        maze[entrance[0]][entrance[1]] = '+'; // marking the entry as visited
        
       
        Queue<Cell> q = new LinkedList<>();
        int steps = 0;
        
        //Adding all the neighbors of entry so we don't consider entry as exit
        for(int i=0; i<4; i++){
            int x = entrance[0] + rowoffset[i];
            int y = entrance[1] + coloffset[i];
            if(isWithinBoundary(x, y, m, n) && !isWall(x, y, maze)){
                q.add(new Cell(x, y)); 
                maze[x][y] = '+';
            }
        }
        // BFS template
            // Add to the root to the queue
            // forEach node in Queue : 
                // pop a node
                // find  and add valid neighbors to the queue
                // Repeat until queue is not empty
            // Return -1, if we come out of the loop
                
        while(!q.isEmpty()){
            steps++; 
            int size = q.size(); 
            for( int i=0; i<size; i++){
                Cell cell = q.poll(); 
                for(int j=0; j<4; j++){
                    int x = cell.x + rowoffset[j];
                    int y = cell.y + coloffset[j];
                    if(!isWithinBoundary(x, y, m, n)) return steps; 
                    else {
                        if(!isWall(x, y, maze)){
                            q.add(new Cell(x, y));
                            maze[x][y] = '+';
                        }
                    }
                }
            }
        }
        return -1;

    }

    private boolean isWithinBoundary(int x, int y, int m, int n){
        if(x < 0 || x>= m) return false;
        if( y< 0 || y >= n) return false; 
        return true; 
    }

    private boolean isWall(int x, int y, char[][] maze){
        return maze[x][y] == '+';
    }

    // Helper class to easily manage the cell coordinates
    class Cell {
        int x;
        int y;

        public Cell(int x_, int y_){
            x = x_;
            y = y_; 
        }
    }
}