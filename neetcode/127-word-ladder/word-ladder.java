class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        if (!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair pair = q.poll();
            String word = pair.word;
            int steps = pair.steps;
            char []sb = word.toCharArray();
            
            if(word.equals(endWord)) return steps;
            
            for(int i = 0; i < sb.length; ++i){
                char original = sb[i];
                for(char ch = 'a'; ch <= 'z'; ++ch){
                    sb[i] = ch;
                    String newWord = new String(sb);
                    if(set.contains(newWord) == true){
                        q.add(new Pair(newWord, steps + 1));
                        set.remove(newWord);
                    }
                }
                sb[i] = original;
            }
        }
        return 0;
    }
}