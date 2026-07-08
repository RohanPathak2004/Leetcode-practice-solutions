class Solution {
public:

    pair<TreeNode*,int> dfs(TreeNode* root,int lvl) {
        if(root == nullptr) return make_pair(new TreeNode(),-1);
        if(root->left == nullptr && root->right == nullptr){
            return make_pair(root,lvl+1);
        }
        pair<TreeNode*,int> lp = dfs(root->left,lvl+1);
        pair<TreeNode*,int> rp = dfs(root->right,lvl+1);
        if(lp.first == nullptr) return rp;
        if(rp.first == nullptr) return lp;
        if(lp.second>rp.second) return lp;
        if(lp.second<rp.second) return rp;
        return make_pair(root,lp.second);

    }

    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        pair<TreeNode*,int> res = dfs(root,0);
        return res.first;
    }
};