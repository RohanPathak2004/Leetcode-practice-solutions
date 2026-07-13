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
    int maxf = 0;
    void dfs(TreeNode* root,unordered_map<int,int>& map) {
        if(root == NULL) return;
        int key = root->val;
        if(!map.contains(key)) map[key] = 1;
        else map[key]++;
        maxf = max(map[key],maxf);
        dfs(root->left,map);
        dfs(root->right,map);
    }
    vector<int> findMode(TreeNode* root) {
        unordered_map<int,int> map;
        vector<int> ans;
        dfs(root,map);
        for(const auto& [key,val] : map){
            if(val == maxf) ans.push_back(key);
        }
        return ans;
    }
};