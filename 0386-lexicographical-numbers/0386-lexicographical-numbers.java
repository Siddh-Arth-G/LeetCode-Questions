class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> output = new ArrayList<>();
        addLexical(output, 1, n);
        return output;
    }
    void addLexical(List<Integer> list, int num, int n){
        if(num <= n){
            list.add(num);
            addLexical(list, num*10, n);
            
            for(int i=1; i<(num < 10 ? 9: 10) && (num + i <= n); i++){
                list.add(num+i);
                if((num+i)*10 <= n ){
                    addLexical(list, (num + i)*10, n);
                }
            }
        }
    }
}