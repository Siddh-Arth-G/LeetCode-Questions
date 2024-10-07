// class Solution {
//     public String predictPartyVictory(String senate) {
//         Queue<Integer> radiant = new LinkedList<>();
//         Queue<Integer> dire = new LinkedList<>();
        
//         for (int i = 0; i < senate.length(); i++) {
//             if (senate.charAt(i) == 'R') {
//                 radiant.offer(i);
//             } else {
//                 dire.offer(i);
//             }
//         }
        
//         int n = senate.length();
//         while (!radiant.isEmpty() && !dire.isEmpty()) {
//             int r = radiant.poll();
//             int d = dire.poll();
        
//             if (r < d) {
//                 radiant.offer(r + n);
//             } else {
//                 dire.offer(d + n);
//             }
//         }
//         return radiant.isEmpty() ? "Dire" : "Radiant";
//     }
// }




class Solution {
    public String predictPartyVictory(String senate) {
        return round(senate.toCharArray(), 0);
    }
    public String round(char[] senators, int votes){
        int r = 0;
        int d = 0;
        for (int i = 0; i < senators.length; i++) {
            if(senators[i] == 'R') {
                if (votes >= 0) r++;
                else senators[i] = '0';
                votes++;
            } else if (senators[i] == 'D'){
                if (votes <= 0) d++;
                else senators[i] = '0';
                votes--;
            }
        }
        if (d !=0 && r == 0) return "Dire";
        else if (d == 0 && r != 0) return "Radiant";
        else return round(senators, votes);
    }
}