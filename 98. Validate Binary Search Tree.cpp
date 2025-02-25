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
        bool solve(TreeNode* root, long long int l, long long int r){
            if( root == NULL ) return true;
            if(root -> val < r && root -> val > l )
                return (solve(root -> left,l, root -> val )  && solve(root -> right, root -> val, r));
            else return false;
    
        }
        bool isValidBST(TreeNode* root) {
            if( root == NULL ) return true;
            long long int mini = -1e12;
            long long int maxi = 1e12;
            return solve(root, mini, maxi);
    
        }
    };