class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] minutes = new int[size];
        int result = Integer.MAX_VALUE;
        for(int i=0; i<size; i++){
            String time = timePoints.get(i);
            
            int hour = Integer.parseInt(time.substring(0,2));
            int minute = Integer.parseInt(time.substring(3));
            
            minutes[i] = hour*60 + minute;
        }
        Arrays.sort(minutes);
        for(int i=1; i<size; i++){
            result = Math.min(result, minutes[i]-minutes[i-1]);
        }
        
        return Math.min(result, 24*60-minutes[size-1]+minutes[0]);
    }
}