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
    int prev = INT_MAX;
    int min_ans = INT_MAX;
    int getMinimumDifference(TreeNode* root) {
        if(root == NULL) return INT_MAX;
        getMinimumDifference(root->left);
        if(prev!=INT_MAX) min_ans = min(min_ans,root->val-prev);
        prev = root->val;
        getMinimumDifference(root->right);
        return min_ans;
    }
};