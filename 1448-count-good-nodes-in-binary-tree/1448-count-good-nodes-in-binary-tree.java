
class Solution {
    public int find(TreeNode root,int curMax){
        if(root==null) return 0;
        int leftVal=0;
        int rightVal = 0;
        int leftMax = curMax;
        int rightMax = curMax;
        if(root.left!=null&&root.left.val>=curMax){
            leftVal = 1;
            leftMax = Math.max(root.left.val,curMax);
        }
        
        if(root.right!=null&&root.right.val>=curMax){
            rightVal = 1;
            rightMax = Math.max(root.right.val,curMax);
        }
        
        return leftVal+rightVal+find(root.left,leftMax)+find(root.right,rightMax);
    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return 1+find(root,root.val);
    }
}