// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         Stack<Integer> stack = new Stack<>();
//         int n = temperatures.length;
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//                 int index = stack.pop();
//                 res[index] = i - index;
//             }
//             stack.push(i);
//         }
//         return res;
//     }
// }



class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int n = temperatures.length;
        int hottest = 0;
        for (int i = n-1; i >= 0; i--) {
            int currentTemp = temperatures[i];
            if(currentTemp >= hottest){
                hottest = currentTemp;
                continue;
            }

            int days = 1;
            while(temperatures[days + i] <= currentTemp){
                days += result[i + days];
            }
            result[i] = days;
        }

        return result;
    }
}