
class Solution {
    public boolean isSame(TreeNode root, TreeNode sub){
        if(root == null && sub == null) return true;
        if(root == null || sub == null) return false;
        if(root.val != sub.val) return false;
        boolean left = isSame(root.left,sub.left);
        boolean right = isSame(root.right,sub.right);
        return left&&right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(root.val == subRoot.val){
            if(isSame(root,subRoot)) return true;
        }
        boolean leftSearch = isSubtree(root.left,subRoot);
        boolean rightSearch = isSubtree(root.right,subRoot);
        return leftSearch||rightSearch;
    }
}