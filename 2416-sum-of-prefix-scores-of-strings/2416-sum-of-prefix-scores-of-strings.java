class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int n = words.length;
        for(String word: words){
            trie.insert(word);
        }
        int[] ans =new int[n];
        for(int i=0; i<n; i++){
            ans[i] = trie.startsWith(words[i]) - n;
        }
        return ans;
    }
}

class Trie{
    int root;
    List<TrieNode> list;
    
    public Trie(){
        root = 0;
        list = new ArrayList<>();
        list.add(new TrieNode());
    }
    
    public void insert(String word){
        int n = word.length();
        TrieNode temp = list.get(root);
        for(int i=0; i<n; i++){
            int cur = word.charAt(i)-'a';
            if(temp.getIndex(cur) == -1){
                temp.addChar(cur, list.size());
                list.add(new TrieNode());
            }
            temp.increaseCount();
            temp = list.get(temp.getNext(cur));
        }
        temp.markEnd();
    }
    
    public int startsWith(String prefix){
        int n = prefix.length();
        TrieNode temp = list.get(root);
        int count = 0;
        for(int i=0; i<n; i++){
            int cur = prefix.charAt(i)-'a';
            if(temp.getIndex(cur) == -1){
                return 0;
            }
            int currCount = temp.getPrefixCount();
            count += temp.getPrefixCount();
            temp = list.get(temp.getNext(cur));
        }
        count += temp.getPrefixCount();
        return count;
    }
}

class TrieNode {
    int endCount;
    int prefixCount;
    int[] map;
    TrieNode() {
        endCount = 0;
        prefixCount = 0;
        map = new int[26];
        Arrays.fill(map, -1);
    }
    
    int getIndex(int cur){
        return map[cur];
    }
    
    int getNext(int cur){
        return (map[cur] == -1) ? -1 : map[cur];
    }
    
    void addChar(int cur, int index){
        map[cur] = index;
    }
    
    void increaseCount(){
        prefixCount++;
    }
    
    void markEnd(){
        prefixCount++;
        endCount++;
    }
    
    int getPrefixCount(){
        return prefixCount; 
    }
}