// class CountCharacter{
//     int count;
//     char c;

//     public CountCharacter(int ct, char c){
//         this.count = ct;
//         this.c = c;
//     }
// }

// class Solution {
//     public String longestDiverseString(int a, int b, int c) {
//         PriorityQueue<CountCharacter> pq = new PriorityQueue<>((c1,c2) -> c2.count - c1.count);

//         if(a > 0){
//             pq.add(new CountCharacter(a, 'a'));
//         }
//         if(b > 0){
//             pq.add(new CountCharacter(b, 'b'));
//         }
//         if(c > 0){
//             pq.add(new CountCharacter(c, 'c'));
//         }

//         StringBuilder sb = new StringBuilder();
//         while(!pq.isEmpty()){
//             CountCharacter ele = pq.poll();

//             int count = ele.count;
//             char c1 = ele.c;

//             if(sb.length() >= 2 && sb.charAt(sb.length()-1) == c1 && sb.charAt(sb.length()-2) == c1){
//                 if(pq.isEmpty()){
//                     break;
//                 }
//                 CountCharacter second = pq.poll();
//                 int count2 = second.count;
//                 char c2 = second.c;
//                 count2 = count2 - 1;
//                 sb.append(c2);

//                 if(count2 > 0){
//                     pq.add(new CountCharacter(count2, c2));
//                 }
//             } else{
//                 count = count - 1;
//                 sb.append(c1);
//             }


//             if(count > 0){
//                 pq.add(new CountCharacter(count, c1));
//             }
//         }
//         return sb.toString();
//     }
// }





class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        
        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;
        
        for(int i = 0; i < totalLength; i++) {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0))  {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;  
            } else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0) || (continuousC == 2 && b > 0)) {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0) || (continuousA == 2 && c > 0)) {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;  
            }
        }
        return sb.toString();
    }
}