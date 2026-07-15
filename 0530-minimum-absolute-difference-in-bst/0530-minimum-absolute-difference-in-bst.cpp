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
    void dfs(TreeNode* root,vector<int>& nums){
        if(root == nullptr) return;
        dfs(root->left,nums);
        nums.push_back(root->val);
        dfs(root->right,nums);
    }
    int getMinimumDifference(TreeNode* root) {
        vector<int> nums;
        dfs(root,nums);
        int ans = INT_MAX;
        for(int i = 0; i<nums.size()-1 ; i++) {
            ans = min(ans,nums[i+1]-nums[i]);
        }
        return ans;
    }
};