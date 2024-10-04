// class Solution {
//     public long dividePlayers(int[] skill) {
//         Arrays.sort(skill);
//         int i = 0;
//         int j = skill.length-1;
//         long sum = skill[i] + skill[j];
//         long totalSkill = skill[i]*skill[j];
//         i++;
//         j--;
//         while(i<j){
//             long tempSum = skill[i] + skill[j];
//             if(tempSum != sum){
//                 return -1;
//             }
//             long tempSkill = skill[i]*skill[j];
//             totalSkill += tempSkill;
//             i++;
//             j--;
//         }
//         return totalSkill;
//     }
// }







class Solution {

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        int[] skillFrequency = new int[1001];

        for (int playerSkill : skill) {
            totalSkill += playerSkill;
            skillFrequency[playerSkill]++;
        }

        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetTeamSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        for (int playerSkill : skill) {
            int partnerSkill = targetTeamSkill - playerSkill;

            if (skillFrequency[partnerSkill] == 0) {
                return -1;
            }

            totalChemistry += (long) playerSkill * (long) partnerSkill;
            skillFrequency[partnerSkill]--;
        }

        return totalChemistry / 2;
    }
}