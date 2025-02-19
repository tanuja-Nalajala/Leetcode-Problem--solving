class Solution {
    public:
        bool solve(int i, int j, int k, string word, vector<vector<char>>&board,  int m, int n,  vector<vector<int>>&vis){
            
            if(k == word.size()) return true;
    
            if( i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word[k]){
                return false;
            }
            bool ans = false;
            char temp = board[i][j];
            board[i][j] = '*';
                ans =   solve(i-1, j, k+1, word, board, m, n, vis) ||
                        solve(i+1, j, k+1, word, board, m, n, vis) ||
                        solve(i, j+1, k+1, word, board, m, n, vis) ||
                        solve(i, j-1, k+1, word, board, m, n, vis);
            board[i][j] = temp;
            return ans;
    
        }
        bool exist(vector<vector<char>>& board, string word) {
            int m = board.size();
            int n = board[0].size();
            vector<vector<int>>vis(m, vector<int>(n,0));
            bool ans;
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(board[i][j] == word[0])
                        ans = solve(i, j, 0, word, board, m, n, vis);
                        if(ans)
                            return true;
                }
            }
            return ans;
        }
    };