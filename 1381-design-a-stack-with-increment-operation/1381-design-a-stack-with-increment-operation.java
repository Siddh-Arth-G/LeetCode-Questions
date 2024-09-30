// class CustomStack {
    
//     private int i, arr[];
//     private Stack<Integer> stack;

//     public CustomStack(int maxSize) {
//         this.i = maxSize;
//         this.arr = new int[i];
//         this.stack = new Stack<Integer>();
//     }
    
//     public void push(int x) {
//         if(stack.size() < i){
//             stack.push(x);
//         }
//     }
    
//     public int pop() {
//         int j = stack.size() - 1;
//         if(j < 0){
//             return -1;
//         }
//         if(j>0){
//             arr[j-1] += arr[j];
//         }
//         int res = stack.pop() + arr[j];
//         arr[j] = 0;
        
//         return res;
//     }
    
//     public void increment(int k, int val) {
//         int j = Math.min(k, stack.size()) - 1;
//         if(j >= 0){
//             arr[j] += val;
//         }
//     }
// }









class CustomStack {

    // Array to store stack elements
    private int[] stackArray;

    // Array to store increments for lazy propagation
    private int[] incrementArray;

    // Current top index of the stack
    private int topIndex;

    public CustomStack(int maxSize) {
        stackArray = new int[maxSize];
        incrementArray = new int[maxSize];
        topIndex = -1;
    }

    public void push(int x) {
        if (topIndex < stackArray.length - 1) {
            stackArray[++topIndex] = x;
        }
    }

    public int pop() {
        if (topIndex < 0) {
            return -1;
        }

        // Calculate the actual value with increment
        int result = stackArray[topIndex] + incrementArray[topIndex];

        // Propagate the increment to the element below
        if (topIndex > 0) {
            incrementArray[topIndex - 1] += incrementArray[topIndex];
        }

        // Reset the increment for this position
        incrementArray[topIndex] = 0;

        topIndex--;
        return result;
    }

    public void increment(int k, int val) {
        if (topIndex >= 0) {
            // Apply increment to the topmost element of the range
            int incrementIndex = Math.min(topIndex, k - 1);
            incrementArray[incrementIndex] += val;
        }
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */