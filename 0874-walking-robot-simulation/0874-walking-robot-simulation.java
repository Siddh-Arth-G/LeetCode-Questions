class Solution {
    private int f(int x, int y){
        return x*60010 + y;
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int[]dir = {0,1,0,-1,0};
        Set<Integer> set = new HashSet<>(obstacles.length);
        for(var e: obstacles){
            set.add(f(e[0],e[1]));
        }
        int ans = 0;
        int k=0;
        int x = 0;
        int y = 0;
        for(int command : commands){
            if(command == -2){
                k = (k + 3) % 4;
            }else if(command == -1){
                k = (k + 1) % 4;
            }else{
                while(command-- > 0){
                    int mx = x + dir[k];
                    int my = y + dir[k+1];
                    if(set.contains(f(mx,my))){
                        break;
                    }
                    x = mx;
                    y = my;
                    ans = Math.max(ans, x*x + y*y);
                }
            }
        }
        return ans;
    }
}