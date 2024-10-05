// import java.util.Stack;

// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> st = new Stack<>();
//         for (int num : asteroids) {
//             boolean isExploded = false;
//             // Handle collisions
//             while (!st.isEmpty() && num < 0 && st.peek() > 0) {
//                 if (st.peek() < -num) {
//                     st.pop(); // Top asteroid explodes, check next
//                 } else if (st.peek() == -num) {
//                     st.pop(); // Both explode
//                     isExploded = true;
//                     break;
//                 } else {
//                     isExploded = true; // Incoming asteroid explodes
//                     break;
//                 }
//             }
//             // If asteroid did not explode, push it to the stack
//             if (!isExploded) {
//                 st.push(num);
//             }
//         }

//         // Prepare result array from stack
//         int[] ans = new int[st.size()];
//         for (int i = ans.length - 1; i >= 0; i--) {
//             ans[i] = st.pop();
//         }
//         return ans;
//     }
// }





class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int index = 0;    
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            
            while (index > 0 && asteroids[index - 1] > 0 && asteroid < 0) {
                if (asteroids[index - 1] < -asteroid) {
                    index--;
                } else if (asteroids[index - 1] == -asteroid) {
                    index--;
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            
            if (!destroyed) {
                asteroids[index] = asteroid;
                index++;
            }
        }
        
        int[] result = new int[index];
        System.arraycopy(asteroids, 0, result, 0, index);
        return result;
    }
}