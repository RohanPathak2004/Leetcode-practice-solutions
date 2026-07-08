/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[] dfs(TreeNode root, int[] minmax, int[] ans) {
        if (root == null)
            return new int[] { -1, -1 };
        if (root.left == null && root.right == null)
            return new int[] { root.val, root.val };

        int[] res = { -1, -1 };
        int[] left = dfs(root.left, minmax, ans);
        int[] right = dfs(root.right, minmax, ans);

        if (left[0] != -1 && right[0] != -1 && left[1] != -1 && right[1] != -1) {
            ans[0] = Math.max(ans[0], Math.abs(root.val - left[0]));
            ans[0] = Math.max(ans[0], Math.abs(root.val - left[1]));
            ans[0] = Math.max(ans[0], Math.abs(root.val - right[0]));
            ans[0] = Math.max(ans[0], Math.abs(root.val - right[1]));
            int curmin = Math.min(left[0], Math.min(root.val,right[0]));
            int curmax = Math.max(left[1], Math.max(root.val,right[1]));

            res[0] = curmin;
            res[1] = curmax;
            return res;
        }
        if (left[0] == -1 && left[1] == -1) {
            ans[0] = Math.max(ans[0], Math.abs(root.val - right[0]));
            ans[0] = Math.max(ans[0], Math.abs(root.val - right[1]));
            right[0] = Math.min(right[0],root.val);
            right[1] = Math.max(right[1],root.val);
            return right;
        }
        if (right[0] == -1 && right[1] == -1){
            ans[0] = Math.max(ans[0], Math.abs(root.val - left[0]));
            ans[0] = Math.max(ans[0], Math.abs(root.val - left[1]));
            left[0] = Math.min(left[0],root.val);
            left[1] = Math.max(left[1],root.val);
            return left;
        }
        return res;

    }

    public int maxAncestorDiff(TreeNode root) {
        int[] ans = { 0 };
        int[] f = dfs(root, new int[] { -1, -1 }, ans);
        // System.out.println(f[0]+" "+f[1]);
        return ans[0];
    }
}