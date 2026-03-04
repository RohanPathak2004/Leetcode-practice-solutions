class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int up = 0;
        int down = mat.length-1;
        int left = 0;
        int right = mat[0].length-1;
        while(up<=down&&left<=right){
            for(int i = left ; i<=right ; i++){
                ans.add(mat[up][i]);
            }
            up++;
            
            for(int i = up;i<=down;i++){
                ans.add(mat[i][right]);
            }
            right--;
            if(left>right||up>down) break;
            for(int i = right ;i>=left ; i--){
                ans.add(mat[down][i]);
            }
            down--;
            for(int i = down ; i>=up ; i--){
                ans.add(mat[i][left]);
            }
            left++;
            // System.out.println(ans);
        }
        return ans;
    }
}