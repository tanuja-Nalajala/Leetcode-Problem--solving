class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int [] indx = new int[3];
        Arrays.fill(indx, -1);

        for(int i = 0; i < n; ++i){

            //update idx of current char
            char currChar = s.charAt(i);
            indx[currChar - 'a'] = i;
            if(indx[0] != -1 && indx[1] != -1 && indx[2] != -1){
                count += 1 + Math.min(indx[0], Math.min( indx[1], indx[2]) );
            }
        }
        return count;
    }
}