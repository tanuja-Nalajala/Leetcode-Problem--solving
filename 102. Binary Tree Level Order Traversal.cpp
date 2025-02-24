/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    public:
        vector<vector<int>> levelOrder(TreeNode* root) {
            queue<TreeNode *> q;
            TreeNode* temp;
            vector<vector<int>> ans;
            if( root == NULL ) return ans ;
            //vector<vector<int>> ans;
            q.push(root);
            while( !q.empty() ){
                int k = q.size();
                vector<int>level;
                while(k--){
                    temp = q.front();
                    q.pop();
                    level.push_back( temp->val );
                    if(temp -> left ) q.push(temp -> left);
                    if(temp -> right ) q.push(temp -> right);
                }
                ans.push_back(level);
            }
            return ans;
        }
    };