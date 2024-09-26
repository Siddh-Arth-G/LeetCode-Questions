class MyCalendar {
    
    TreeMap<Integer, Integer> calender = new TreeMap<>();

    public MyCalendar() {
        calender.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pair = calender.higherEntry(start);
        boolean res = end<=pair.getValue();
        if(res){
            calender.put(end, start);
        }
        return res;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */