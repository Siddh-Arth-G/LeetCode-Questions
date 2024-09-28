// class MyCircularDeque {
    
//     static Deque<Integer> d;
//     static int size;

//     public MyCircularDeque(int k) {
//         d = new LinkedList<>();
//         size = k;
//     }
    
//     public boolean insertFront(int value) {
//         if(d.size() < size){
//             d.addFirst(value);
//             return true;
//         }
//         return false;
//     }
    
//     public boolean insertLast(int value) {
//         if(d.size() < size){
//             d.addLast(value);
//             return true;
//         }
//         return false;
//     }
    
//     public boolean deleteFront() {
//         if(d.size()>0){
//             d.removeFirst();
//             return true;
//         }
//         return false;
//     }
    
//     public boolean deleteLast() {
//         if(d.size()>0){
//             d.removeLast();
//             return true;
//         }
//         return false;
//     }
    
//     public int getFront() {
//         if(d.size() <= 0){
//             return -1;
//         }
//         return d.getFirst();
//     }
    
//     public int getRear() {
//         if(d.size() <= 0){
//             return -1;
//         }
//         return d.getLast();
//     }
    
//     public boolean isEmpty() {
//         if(d.size() == 0){
//             return true;
//         }
//         return false;
//     }
    
//     public boolean isFull() {
//         if(d.size() == size){
//             return true;
//         }
//         return false;
//     }
// }











class MyCircularDeque {
    private int head, tail, size, n;
    private final int[] a;
    public MyCircularDeque(int k) {
        a = new int[k];
        n = a.length;
        tail = 1;
    }
    
    public boolean insertFront(int x) {
        if (size == n) return false;
        a[head = ++head % n] = x;
        size++;
        return true;
    }
    
    public boolean insertLast(int x) {
        if (size == n) return false;
        a[tail = (--tail + n) % n] = x;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (size == 0) return false;
        head = (--head + n) % n;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (size == 0) return false;
        tail = ++tail % n;
        size--;
        return true;
    }
    
    public int getFront() {
        return size == 0 ? -1 : a[head];
    }
    
    public int getRear() {
        return size == 0 ? -1 : a[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == a.length;
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */