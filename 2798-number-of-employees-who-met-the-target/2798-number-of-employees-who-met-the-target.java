class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int employeeWhoMetTheTarget = 0;
        for(int hour: hours){
            if(hour >= target){
                employeeWhoMetTheTarget++;
            }
        }
        return employeeWhoMetTheTarget;
    }
}