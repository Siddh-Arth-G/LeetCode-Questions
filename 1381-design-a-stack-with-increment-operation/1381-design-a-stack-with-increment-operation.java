class CustomStack {
    
    private int i, arr[];
    private Stack<Integer> stack;

    public CustomStack(int maxSize) {
        this.i = maxSize;
        this.arr = new int[i];
        this.stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.size() < i){
            stack.push(x);
        }
    }
    
    public int pop() {
        int j = stack.size() - 1;
        if(j < 0){
            return -1;
        }
        if(j>0){
            arr[j-1] += arr[j];
        }
        int res = stack.pop() + arr[j];
        arr[j] = 0;
        
        return res;
    }
    
    public void increment(int k, int val) {
        int j = Math.min(k, stack.size()) - 1;
        if(j >= 0){
            arr[j] += val;
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